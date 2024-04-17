package com.vishwam.simplenotesapp

import android.widget.Toast
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun HomeView() {

    val context = LocalContext.current

    Scaffold(
        topBar = { AppBarView(title = "Notes", {
            Toast.makeText(context, "Button Clicked", Toast.LENGTH_SHORT).show()
            })
                 },

        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier.padding(all = 20.dp),
                contentColor = Color.White, // Plus sign color white
                backgroundColor = Color.Black,
                onClick = {  }) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "Add button" )
            }
        }
    ) {
        LazyColumn(modifier = Modifier.padding(it)) {

        }
    }
}