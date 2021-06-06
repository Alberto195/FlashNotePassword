package com.bersyte.noteapp.viewmodel

import android.content.Context
import android.hardware.camera2.CameraManager
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import java.lang.Exception

class FlashlightViewModel: BaseViewModel() {
    private lateinit var cameraM : CameraManager
    var isFlash = false

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

    fun initCameraManager(context: Context) {
        cameraM = getSystemService(context, CameraManager::class.java)!!
    }

    private fun textMassage(s: String, c:Context) {
        Toast.makeText(c,s, Toast.LENGTH_SHORT).show()

    }
}