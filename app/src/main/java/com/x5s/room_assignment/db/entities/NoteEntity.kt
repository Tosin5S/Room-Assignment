package com.x5s.room_assignment.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note")
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0,
    var title : String,
    var description : String
)

