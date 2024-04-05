package com.vishwam.simplenotesapp

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

// for Scaffold
@Composable
fun HomeView() {

    Scaffold(
        topBar = { AppBarView(title = "Notes") },
        bottomBar = {}
    ) {
        LazyColumn(modifier = Modifier.padding(it)) {

        }
    }
}