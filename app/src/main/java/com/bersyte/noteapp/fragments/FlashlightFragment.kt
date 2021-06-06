package com.bersyte.noteapp.fragments

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import com.bersyte.noteapp.databinding.FlashlightFragmentBinding
import com.bersyte.noteapp.viewmodel.FlashlightViewModel
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

        binding!!.stroboscope.setOnClickListener {
            for (i in 1..20) {
                viewModel.flashLightOnOrOff(requireContext())
                Thread.sleep(30)
            }
        }

    }
}