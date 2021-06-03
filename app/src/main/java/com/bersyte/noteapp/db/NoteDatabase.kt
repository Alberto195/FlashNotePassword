package com.bersyte.noteapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bersyte.noteapp.model.Note

@Database(entities = [Note::class], version = 7)
abstract class NoteDatabase: RoomDatabase() {

    abstract fun getNoteDao(): NoteDao

    companion object {
        @Volatile
        private var instance: NoteDatabase? = null

        @Synchronized
        fun getInstance(context: Context): NoteDatabase {
            return if(instance == null) {
                instance = Room.databaseBuilder(
                    context,
                    NoteDatabase::class.java,
                    "note_db"
                ).fallbackToDestructiveMigration().build()

                instance as NoteDatabase
            } else instance as NoteDatabase
        }
    }


}