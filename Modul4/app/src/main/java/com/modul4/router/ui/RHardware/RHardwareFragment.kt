package com.modul4.router.ui.RHardware

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
import com.modul4.router.adapter.RHardwareAdapter
import com.modul4.router.databinding.FragmentHardwareBinding
import com.modul4.router.model.RouterHardware

class RHardwareFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private var gridLayoutManager: GridLayoutManager? = null
    private var _binding: FragmentHardwareBinding? = null
    private var recyclerViewAdapter : RHardwareAdapter? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val RHardwareViewModel =
            ViewModelProvider(this)[RHardwareViewModel::class.java]
        RHardwareViewModel.mutableLiveDataRouterHardware.observe(viewLifecycleOwner,listUpdateObserver)
        _binding = FragmentHardwareBinding.inflate(inflater, container, false)
        val root: View = binding.root
        gridLayoutManager = GridLayoutManager(requireContext(), 2, LinearLayoutManager.VERTICAL, false)
        recyclerView = _binding!!.recylerViewCir
        recyclerView.layoutManager = gridLayoutManager
        recyclerView.setHasFixedSize(true)
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        gridLayoutManager = null
        _binding = null
    }
    private var listUpdateObserver : Observer<ArrayList<RouterHardware>?> =
        Observer<ArrayList<RouterHardware>?> { arrayList ->
            recyclerViewAdapter = RHardwareAdapter(requireContext(),arrayList)
            recyclerView.adapter = recyclerViewAdapter
        }
}