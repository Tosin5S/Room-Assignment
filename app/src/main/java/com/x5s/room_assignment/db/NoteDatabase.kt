package com.x5s.room_assignment.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.x5s.room_assignment.db.dao.NoteDao
import com.x5s.room_assignment.db.entities.NoteEntity

@Database(
    entities = [NoteEntity::class],
    version = 1
)
abstract class NoteDatabase: RoomDatabase() {
    abstract fun noteDao() : NoteDao

    companion object{
        @Volatile private var instance : NoteDatabase? = null
        private val LOCK = Any ()

        operator fun invoke(context : Context) = instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context)
        }

        private fun buildDatabase(context:Context) = Room.databaseBuilder(context,NoteDatabase::class.java, "note.db").build()
    }
}