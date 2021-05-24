package com.x5s.room_assignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.x5s.room_assignment.adapter.NoteAdapter
import com.x5s.room_assignment.db.NoteRepository
import com.x5s.room_assignment.db.entities.NoteEntity

class MainActivity : AppCompatActivity() {
    private lateinit var noteAdapter: NoteAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var recyclerView: RecyclerView
    private lateinit var addNoteBtn: FloatingActionButton
    private lateinit var noteRepository: NoteRepository


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init(){
        noteAdapter = NoteAdapter()
        linearLayoutManager = LinearLayoutManager(this)

        recyclerView = findViewById(R.id.recyclerView)

        addNoteBtn = findViewById(R.id.floatingActionButton)

        recyclerView.adapter = noteAdapter

        recyclerView.layoutManager = linearLayoutManager

        noteRepository = NoteRepository(this)

        //insertDataIntoDb()
        addNoteBtn.setOnClickListener{
            openAddNote()
        }
    }

    override fun onResume(){
        super.onResume()
        noteRepository.getAllNotes().observe(this, { notes ->
            noteAdapter.submitList(notes)
            noteAdapter.notifyDataSetChanged()
        })
    }

    private fun openAddNote(){
        val intent = Intent(this,AddNoteActivity::class.java)
        startActivity(intent)
    }

    //private fun insertDataIntoDb(){
      //  val noteEntity = NoteEntity(title ="Hey", description = "Hi, How are you")
       // noteRepository.insertNote(noteEntity)
    //}
}