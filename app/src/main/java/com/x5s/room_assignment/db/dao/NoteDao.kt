package com.x5s.room_assignment.db.dao

import androidx.room.*
import com.x5s.room_assignment.db.entities.NoteEntity


@Dao
interface NoteDao {
    @Query("SELECT * FROM note")
    fun selectAllNotes(): List<NoteEntity>

    @Insert
    fun insertNotes(noteEntity:NoteEntity)

    @Delete
    fun deleteNOte(noteEntity: NoteEntity)

    @Update
    fun updateNote(noteEntity: NoteEntity)
}