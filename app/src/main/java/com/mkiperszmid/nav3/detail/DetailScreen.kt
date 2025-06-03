package com.mkiperszmid.nav3.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun DetailScreen(
    viewModel: DetailViewModel
) {
    val state = viewModel.state
    Scaffold(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.padding(it), contentAlignment = Alignment.Center) {
            Text("Detalle de ${state.person.name} con edad de ${state.person.age}")
        }
    }
}