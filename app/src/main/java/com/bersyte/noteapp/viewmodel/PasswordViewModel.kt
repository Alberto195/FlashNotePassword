package com.bersyte.noteapp.viewmodel

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.Navigation
import com.bersyte.noteapp.R

class PasswordViewModel: BaseViewModel() {
    private val charachters = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890!#$%()=?"

    private var _password = MutableLiveData<String>()
    val password: LiveData<String>
        get() = _password


    fun generatePassword(length: Int) {
        val sb = StringBuilder(length)

        for (x in 0 until length) {
            val random = (charachters.indices).random()
            sb.append(charachters[random])
        }
        sb.insert((0 until length).random(), true)

        _password.value = sb.toString()
    }

}