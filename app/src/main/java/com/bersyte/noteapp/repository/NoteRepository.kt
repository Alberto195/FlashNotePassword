package com.bersyte.noteapp.repository

import com.bersyte.noteapp.db.NoteDao
import com.bersyte.noteapp.db.NoteDatabase
import com.bersyte.noteapp.model.Note

class NoteRepository(private val noteDao: NoteDao) {

    suspend fun insertNote(note: Note) = noteDao.insertNote(note)
    suspend fun deleteNote(note: Note) = noteDao.deleteNote(note)
    suspend fun updateNote(note: Note) = noteDao.updateNote(note)
    fun getAllNotes() = noteDao.getAllNotes()
    fun searchNote(query: String?) = noteDao.searchNote(query)

}