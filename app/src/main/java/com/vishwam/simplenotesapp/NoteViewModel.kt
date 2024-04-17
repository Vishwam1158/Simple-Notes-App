package com.vishwam.simplenotesapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
class NoteViewModel: ViewModel() {

    var noteTitleState by mutableStateOf("")
    var noteDescriptionState by mutableStateOf("")

    fun onNoteTitleChange(newString: String) {
        noteTitleState = newString
    }

    fun onNoteDescriptionChange(newString: String) {
        noteDescriptionState = newString
    }
}