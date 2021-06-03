package com.bersyte.noteapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bersyte.noteapp.R
import com.bersyte.noteapp.databinding.TmpFragmentBinding

class TmpFragment: Fragment(R.layout.tmp_fragment) {

    private var _binding: TmpFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = TmpFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.notes.setOnClickListener {
            findNavController().navigate(R.id.action_tmpFragment_to_homeFragment)
        }

        binding.flashlight.setOnClickListener {
            findNavController().navigate(R.id.action_tmpFragment_to_flashlightFragment)
        }

        binding.passwordGenerator.setOnClickListener {
            findNavController().navigate(R.id.action_tmpFragment_to_passwordFragment)
        }
    }

}