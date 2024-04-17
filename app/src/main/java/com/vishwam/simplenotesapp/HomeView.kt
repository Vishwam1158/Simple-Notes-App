package com.vishwam.simplenotesapp

import android.provider.ContactsContract.CommonDataKinds.Note
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.contentColorFor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.vishwam.simplenotesapp.data.DummyNote
import com.vishwam.simplenotesapp.data.MyNote

@Composable
fun HomeView(
    navController: NavController,
    viewModel: NoteViewModel
) {

    val context = LocalContext.current

    Scaffold(
        topBar = { AppBarView(title = "Notes", {
            Toast.makeText(context, "Button Clicked", Toast.LENGTH_SHORT).show()
            })
                 },

        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier.padding(all = 20.dp),
                backgroundColor = Color.White,
                contentColor = Color.Red, // Plus sign with color white
                onClick = {
                    navController.navigate(Screen.AddScreen.route)
                }) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "Add button" )
            }
        }
    ) {
        LazyColumn(modifier = Modifier.padding(it)) {
            items(DummyNote.NoteList){
                note -> NoteItem(note = note) {
            }
            }
        }
    }
}

@Composable
fun NoteItem(note: MyNote, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, start = 8.dp, end = 8.dp)
            .clickable {
                onClick()
            },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = note.title, fontWeight = FontWeight.ExtraBold )
            Text(text = note.description)

        }
    }
}


