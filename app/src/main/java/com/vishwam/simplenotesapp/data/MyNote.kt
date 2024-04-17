package com.vishwam.simplenotesapp.data

// This class for only single note but note
data class MyNote(
    val id: Long = 0L,
    val title: String = "",
    val description: String = ""
)

object DummyNote {
    val NoteList = listOf(
        MyNote(title = "Note 1", description = "This is Note 1"),
        MyNote(title = "Note 2", description = "This is Note 2"),
        MyNote(title = "Note 3", description = "This is Note 3"),
        MyNote(title = "Note 4", description = "This is Note 4")
    )
}