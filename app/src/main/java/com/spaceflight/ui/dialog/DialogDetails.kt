package com.spaceflight.ui.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.spaceflight.databinding.FragmentDetailsBinding
import org.koin.android.viewmodel.ext.android.viewModel

class DialogDetails : DialogFragment(), DialogListener {
    lateinit var binding: FragmentDetailsBinding
    private val viewModel: DialogDetailsViewModel by viewModel()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        binding.viewmodel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        iniViewModel()
    }

    private fun iniViewModel() {
        viewModel.listener = this

    }

    override fun onClose() {
        dialog?.dismiss()
    }

}