package com.spaceflight.ui.fragment

import android.os.Binder
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.spaceflight.databinding.ActivityHomeBinding
import com.spaceflight.databinding.FragmentNewsBinding
import com.spaceflight.network.response.NewsResponse
import org.koin.android.viewmodel.ext.android.viewModel


class NewsFragment : Fragment() {

    private val viewModel: NewsViewModel by viewModel()
    lateinit var binding: FragmentNewsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initViewModel()

    }

    private fun initViews() {}

    private fun initViewModel() {
        binding.viewmodel = viewModel
        viewModel.initViewModel()

        viewModel.newList.observe(requireActivity(), Observer< List<NewsResponse>>{


        }

    }
}