package com.vishwam.simplenotesapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
abstract class NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract suspend fun addNote(noteEntity: MyNote)

    //Loads notes from the note table
    @Query("SELECT * from `note-table`")
    abstract fun getAllNotes(): Flow<List<MyNote>>

    @Update
    abstract suspend fun updateNote(noteEntity: MyNote)

    @Delete
    abstract suspend fun deleteNote(note: MyNote)

    @Query("SELECT * from `note-table` where id = :id" )
    abstract fun getNoteById(id: Long): Flow<MyNote>

}