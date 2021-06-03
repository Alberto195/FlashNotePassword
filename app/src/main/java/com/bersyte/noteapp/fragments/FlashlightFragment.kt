package com.bersyte.noteapp.fragments

import android.graphics.Camera
import android.hardware.camera2.CameraManager
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.LifecycleOwner
import com.bersyte.noteapp.databinding.FlashlightFragmentBinding
import com.bersyte.noteapp.viewmodel.FlashlightViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.getViewModel


class FlashlightFragment: BaseFragment<FlashlightViewModel, FlashlightFragmentBinding>() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FlashlightFragmentBinding.inflate(
            inflater,
            container,
            false
        )

        return binding!!.root
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = getViewModel()
        viewModel.initCameraManager(requireContext())
        super.onViewCreated(view, savedInstanceState)
        binding!!.power.setOnClickListener {
            viewModel.flashLightOnOrOff(requireContext())
        }

//        binding!!.stroboscope.setOnClickListener {
//            if(!viewModel.isStrobo.value!!) {
//                viewModel.setIsStrobo(true)
//            } else {
//                viewModel.setIsStrobo(false)
//            }
//            loop@ for (i in 1..100) {
//                for (j in 1..100) {
//                    viewModel.flashLightOnOrOff(requireContext())
//                    if (viewModel.isStrobo.value == false) break@loop
//                }
//            }
//        }

    }
}