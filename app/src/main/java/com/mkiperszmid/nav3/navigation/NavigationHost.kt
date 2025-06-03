package com.mkiperszmid.nav3.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entry
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.mkiperszmid.nav3.detail.DetailScreen
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

@Composable
fun NavigationHost(modifier: Modifier = Modifier) {
    val backStack = rememberNavBackStack(NavigationDestination.Home)
    NavDisplay(
        modifier = modifier,
        backStack = backStack,
        entryProvider = entryProvider {
            entry<NavigationDestination.Home> {
                HomeScreen(onGenerateClick = {
                    backStack.add(NavigationDestination.Details(it))
                })
            }
            entry<NavigationDestination.Details> {
                DetailScreen(it.person)
            }
        }
    )
}