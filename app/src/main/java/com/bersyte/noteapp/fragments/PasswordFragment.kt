package com.bersyte.noteapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bersyte.noteapp.R
import com.bersyte.noteapp.databinding.PasswordFragmentBinding
import com.bersyte.noteapp.viewmodel.PasswordViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel

class PasswordFragment: BaseFragment<PasswordViewModel, PasswordFragmentBinding>() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = PasswordFragmentBinding.inflate(
            inflater,
            container,
            false
        )

        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = getViewModel()
        super.onViewCreated(view, savedInstanceState)

        binding!!.generatePassword.setOnClickListener {
            viewModel.generatePassword(10)
        }

        viewModel.password.observe(viewLifecycleOwner, { pass ->
            binding!!.password.text = pass
        })

        binding!!.savePassword.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("pass", binding!!.password.text as String?)
            findNavController().navigate(R.id.action_passwordFragment_to_newNoteFragment, bundle)
        }
    }
}