package com.bersyte.noteapp.viewmodel

import androidx.lifecycle.viewModelScope
import com.bersyte.noteapp.model.Note
import com.bersyte.noteapp.repository.NoteRepository
import kotlinx.coroutines.launch

class NoteViewModel(
    private val noteRepository: NoteRepository
) : BaseViewModel() {

    var password: String = ""

    fun addNote(note: Note) =
        viewModelScope.launch {
            noteRepository.insertNote(note)
        }

    fun deleteNote(note: Note) =
        viewModelScope.launch {
            noteRepository.deleteNote(note)
        }

    fun updateNote(note: Note) =
        viewModelScope.launch {
            noteRepository.updateNote(note)
        }

    fun getAllNote() = noteRepository.getAllNotes()

    fun searchNote(query: String?) =
        noteRepository.searchNote(query)



}