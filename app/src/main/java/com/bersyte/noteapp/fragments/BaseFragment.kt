package com.bersyte.noteapp.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.bersyte.noteapp.viewmodel.BaseViewModel
import java.lang.reflect.ParameterizedType

abstract class BaseFragment<VModel : BaseViewModel, Binding: ViewBinding>: Fragment() {

    protected open lateinit var viewModel: VModel

    protected var _binding: Binding? = null
    protected val binding get() = _binding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showError()
    }

    protected fun showError(){
        viewModel.publicErrorMessage.observe(viewLifecycleOwner){
            Toast.makeText(context, it, Toast.LENGTH_LONG).show()
        }
    }

    @Suppress("UNCHECKED_CAST")
    private fun getViewModelClass(): Class<VModel> {
        val type = (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0]
        return type as Class<VModel>
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}