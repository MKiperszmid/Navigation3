package com.mkiperszmid.nav3.home

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mkiperszmid.nav3.navigation.Person
import kotlin.random.Random

@Composable
fun HomeScreen(
    onGenerateClick: (Person) -> Unit,
) {
    val people = (1..50).map {
        Person("Name $it", Random.nextInt(1, 100))
    }
    Scaffold(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it), contentAlignment = Alignment.Center
        ) {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(people) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                onGenerateClick(it)
                            }
                            .padding(16.dp),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        Text(it.name)
                    }
                }
            }
        }
    }
}