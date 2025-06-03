package com.mkiperszmid.nav3.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.mkiperszmid.nav3.navigation.Person

class DetailViewModel(val person: Person) : ViewModel() {
    var state by mutableStateOf(DetailState(person = person))
        private set
}