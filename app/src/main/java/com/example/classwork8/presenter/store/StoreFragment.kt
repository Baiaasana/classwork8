package com.example.classwork8.presenter.store

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.classwork8.adapter.StoreAdapter
import com.example.classwork8.common.BaseFragment
import com.example.classwork8.databinding.FragmentStoreBinding
import com.example.classwork8.utility.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class StoreFragment : BaseFragment<FragmentStoreBinding>(FragmentStoreBinding::inflate) {

    private val viewModel: StoreViewModel by viewModels()

    private lateinit var storeAdapter: StoreAdapter

    override fun listeners() {
    }

    override fun init() {
        initRecyclers()
        viewModel.getInfo()
    }

    private fun initRecyclers(){
        storeAdapter = StoreAdapter()

        binding.rvStore.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = storeAdapter
        }
    }

    override fun observers() {

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.infoState.collect {
                    viewModel.infoState.collect{
                        storeAdapter.submitList(it.data)
                    }
                }
            }
        }
    }
}