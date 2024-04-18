package com.vishwam.simplenotesapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// This class for only single note but note

@Entity(tableName = "note-table")
data class MyNote(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    @ColumnInfo(name = "note-title")
    val title: String = "",
    @ColumnInfo(name = "not-des")
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