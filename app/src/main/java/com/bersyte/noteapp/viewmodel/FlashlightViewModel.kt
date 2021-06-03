package com.bersyte.noteapp.viewmodel

import android.content.Context
import android.hardware.camera2.CameraManager
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.core.content.ContextCompat.getSystemService
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bersyte.noteapp.R
import kotlinx.coroutines.delay
import java.lang.Exception

class FlashlightViewModel: BaseViewModel() {
    private lateinit var cameraM : CameraManager
    var isFlash = false

    private var _isStrobo = MutableLiveData<Boolean>()
    val isStrobo: LiveData<Boolean>
        get() = _isStrobo

    init {
        _isStrobo.value = false
    }

    fun flashLightOnOrOff(context: Context) {
        /**set flash code*/
        val cameraListId = cameraM.cameraIdList[0]
        try {
            if (!isFlash) {
                cameraM.setTorchMode(cameraListId,true)
                isFlash = true
                textMassage("Flash Light is On", context)
            }
            else {
                cameraM.setTorchMode(cameraListId,false)
                isFlash = false
                textMassage("Flash Light is Off", context)
            }
        } catch (e: Exception) {
            textMassage("Cant connect to flashlight", context)
        }
    }

    fun setIsStrobo(boolean: Boolean) {
        _isStrobo.value = boolean
    }

    fun initCameraManager(context: Context) {
        cameraM = getSystemService(context, CameraManager::class.java)!!
    }

    private fun textMassage(s: String, c:Context) {
        Toast.makeText(c,s, Toast.LENGTH_SHORT).show()

    }
}