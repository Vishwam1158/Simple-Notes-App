package com.vishwam.simplenotesapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import java.io.StringReader

@Composable
fun AddEditDetailView(
    id: Long,
    viewModel: NoteViewModel,
    navController: NavController
) {
    Scaffold(
        topBar = { AppBarView(title =
            if(id != 0L) stringResource(id = R.string.update_note)
            else stringResource(id = R.string.add_note)
        ) { navController.navigateUp() }
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .wrapContentSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(10.dp))

            NoteTextField(
                noteLabel = "Title",
                noteContent = viewModel.noteTitleState,
                onValueChanged = {
                    viewModel.onNoteTitleChange(it)
                }
            )
            Spacer(modifier = Modifier.height(10.dp))

            NoteTextField(
                noteLabel = "Description",
                noteContent = viewModel.noteDescriptionState,
                onValueChanged = {
                    viewModel.onNoteDescriptionChange(it)
                }
            )
            Spacer(modifier = Modifier.height(10.dp))

            Button(onClick = {
                if(viewModel.noteTitleState.isNotEmpty() &&
                    viewModel.noteDescriptionState.isNotEmpty()) {
                    // TODO update List
                }
                else {

                }
            }

            ) {
                Text(
                    text = if(id != 0L) stringResource(id = R.string.update_note)
                    else stringResource(id = R.string.add_note),
                    style = TextStyle( fontSize = 18.sp)
                )
            }
        }
    }
}


@Composable
fun NoteTextField(
    noteLabel: String,
    noteContent : String,
    onValueChanged: (String) -> Unit
) {
    OutlinedTextField(
        value = noteContent,
        onValueChange = onValueChanged,
        label = { Text(text = noteLabel, color = Color.Black)},
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = Color.Black, // predefined color
            cursorColor = colorResource(id = R.color.black),
            focusedBorderColor = colorResource(id = R.color.black), // own color
            unfocusedBorderColor = colorResource(id = R.color.black),
            focusedLabelColor = colorResource(id = R.color.black),
            unfocusedLabelColor = colorResource(id = R.color.black),
        )
    )
}