package com.mkiperszmid.nav3.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.mkiperszmid.nav3.navigation.Person

@Composable
fun DetailScreen(person: Person) {
    Scaffold(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.padding(it), contentAlignment = Alignment.Center) {
            Text("Detalle de ${person.name} con edad de ${person.age}")
        }
    }
}