package com.mkiperszmid.nav3.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.mkiperszmid.nav3.navigation.Person
import kotlin.random.Random

@Composable
fun HomeScreen(
    onGenerateClick: (Person) -> Unit,
) {
    Scaffold(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it), contentAlignment = Alignment.Center
        ) {
            Button(onClick = {
                val person = Person(name = "John", age = Random.nextInt(18, 60))
                onGenerateClick(person)
            }) {
                Text(text = "Click Me")
            }
        }
    }
}