package com.bersyte.noteapp.utils

import com.bersyte.noteapp.db.NoteDatabase
import com.bersyte.noteapp.repository.NoteRepository
import com.bersyte.noteapp.viewmodel.FlashlightViewModel
import com.bersyte.noteapp.viewmodel.NoteViewModel
import com.bersyte.noteapp.viewmodel.PasswordViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val viewModelModule: Module = module {

    viewModel { NoteViewModel(get()) }

    viewModel { FlashlightViewModel() }

    viewModel { PasswordViewModel() }
}

val databaseModule: Module = module {

    single { NoteDatabase.getInstance(androidContext()) }

    single { NoteDatabase.getInstance(androidContext()).getNoteDao() }
}

val repositoryModule: Module = module {

    single { NoteRepository(get()) }
}
