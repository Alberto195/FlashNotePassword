package com.bersyte.noteapp

import android.app.Application
import com.bersyte.noteapp.utils.databaseModule
import com.bersyte.noteapp.utils.repositoryModule
import com.bersyte.noteapp.utils.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin


class AppApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@AppApplication)
            androidFileProperties()
            modules( listOf(
                databaseModule,
                repositoryModule,
                viewModelModule
            )
            )
        }

    }
}