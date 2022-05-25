package com.dwinabela.modul5.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.dwinabela.modul5.R
import com.dwinabela.modul5.databinding.FragmentProvinsiListBinding

class ProvinsiListFragment: Fragment() {
    private val myViewModel : ProvinsiViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentProvinsiListBinding.inflate(inflater)
        myViewModel.getProvinsi()
        binding.lifecycleOwner = this
        binding.data = myViewModel
        binding.recyclerView.adapter = ProvinsiListAdapter(ProvinsiListener { provinsi ->
            myViewModel.onProvinsiClicked(provinsi)
            findNavController()
                .navigate(R.id.action_provinsiListFragment_to_provinsiDetailFragment)
        })
        return binding.root
    }
}