package com.mkiperszmid.nav3.navigation

import androidx.compose.animation.ContentTransform
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.navigation3.ListDetailSceneStrategy
import androidx.compose.material3.adaptive.navigation3.rememberListDetailSceneStrategy
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entry
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSavedStateNavEntryDecorator
import androidx.navigation3.ui.DialogSceneStrategy
import androidx.navigation3.ui.NavDisplay
import androidx.navigation3.ui.SinglePaneSceneStrategy
import androidx.navigation3.ui.rememberSceneSetupNavEntryDecorator
import com.mkiperszmid.nav3.detail.DetailScreen
import com.mkiperszmid.nav3.detail.DetailViewModel
import com.mkiperszmid.nav3.home.HomeScreen
import kotlinx.serialization.Serializable

@Serializable
sealed interface NavigationDestination : NavKey {
    @Serializable
    data class Details(val person: Person) : NavigationDestination

    @Serializable
    data object Home : NavigationDestination
}

@Serializable
data class Person(val name: String, val age: Int)

@OptIn(ExperimentalMaterial3AdaptiveApi::class)
@Composable
fun NavigationHost(modifier: Modifier = Modifier) {
    val backStack = rememberNavBackStack(NavigationDestination.Home)
    NavDisplay(
        modifier = modifier,
        backStack = backStack,
        entryDecorators =
            listOf(
                rememberSceneSetupNavEntryDecorator(),
                rememberSavedStateNavEntryDecorator(),
                rememberViewModelStoreNavEntryDecorator()
            ),
        entryProvider = entryProvider {
            entry<NavigationDestination.Home>(
                //metadata = TwoPaneScene.twoPane()
                metadata = ListDetailSceneStrategy.listPane()
            ) {
                HomeScreen(onGenerateClick = {
                    backStack.add(NavigationDestination.Details(it))
                })
            }
            entry<NavigationDestination.Details>(
                //metadata = DialogSceneStrategy.dialog()
                //metadata = TwoPaneScene.twoPane()
                metadata = ListDetailSceneStrategy.detailPane()
            ) {
                DetailScreen(
                    viewModel = viewModel { DetailViewModel(it.person) }
                )
            }
        },
        sceneStrategy = rememberListDetailSceneStrategy(),
        //sceneStrategy = DialogSceneStrategy(),//TwoPaneSceneStrategy(),
        transitionSpec = {
            ContentTransform(
                slideInHorizontally(initialOffsetX = { it }),
                slideOutHorizontally(targetOffsetX = { -it })
            )
        },
        popTransitionSpec = {
            ContentTransform(
                slideInHorizontally(initialOffsetX = { -it }),
                slideOutHorizontally(targetOffsetX = { it })
            )
        }
    )
}