package com.modul4.router.ui.RSoftware

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.modul4.router.adapter.RSoftwareAdapter
import com.modul4.router.databinding.FragmentSoftwareBinding
import com.modul4.router.model.RouterSoftware

class RSoftwareFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private var gridLayoutManager: GridLayoutManager? = null
    private var _binding: FragmentSoftwareBinding? = null
    private var recyclerViewAdapter : RSoftwareAdapter? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val RSoftwareViewModel =
            ViewModelProvider(this)[RSoftwareViewModel::class.java]
        RSoftwareViewModel.mutableLiveDataRSoftware.observe(viewLifecycleOwner,listUpdateObserver)
        _binding = FragmentSoftwareBinding.inflate(inflater, container, false)
        val root: View = binding.root
        gridLayoutManager = GridLayoutManager(requireContext(), 2, LinearLayoutManager.VERTICAL, false)
        recyclerView = _binding!!.recylerViewAir
        recyclerView.layoutManager = gridLayoutManager
        recyclerView.setHasFixedSize(true)
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        gridLayoutManager = null
        _binding = null
    }
    private var listUpdateObserver : Observer<ArrayList<RouterSoftware>?> =
        Observer<ArrayList<RouterSoftware>?> { arrayList ->
            recyclerViewAdapter = RSoftwareAdapter(requireContext(),arrayList)
            recyclerView.adapter = recyclerViewAdapter
        }
}