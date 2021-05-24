package com.x5s.room_assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.x5s.room_assignment.db.NoteRepository
import com.x5s.room_assignment.db.entities.NoteEntity

class AddNoteActivity : AppCompatActivity() {
    private lateinit var titleEditText: EditText
    private lateinit var descriptionEditText: EditText
    private lateinit var addBtn : Button
    private lateinit var noteRepository:NoteRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)
        init()
    }

    private fun init(){
        titleEditText = findViewById(R.id.note_title_edittext)
        descriptionEditText = findViewById(R.id.description_edit_text)
        addBtn = findViewById(R.id.addButton)
        noteRepository = NoteRepository(this)
        addBtn.setOnClickListener{
            saveNote()
        }

    }

    private fun saveNote(){
        if(titleEditText.text.isNullOrEmpty() || descriptionEditText.text.isNullOrEmpty()){
            Toast.makeText(this ,"All Fields are required", Toast.LENGTH_SHORT).show()
        }else{
            val note = NoteEntity(title = titleEditText.text.toString(), description = descriptionEditText.text.toString())
            noteRepository.insertNote(note)
            finish()
        }
    }
}