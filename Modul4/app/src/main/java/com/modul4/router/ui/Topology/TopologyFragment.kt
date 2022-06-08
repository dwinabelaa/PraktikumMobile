package com.modul4.router.ui.Topology

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.modul4.router.adapter.TopologyAdapter
import com.modul4.router.databinding.FragmentTopologyBinding
import com.modul4.router.model.Topology

class TopologyFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private var _binding: FragmentTopologyBinding? = null
    private var recyclerViewAdapter : TopologyAdapter? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val slideshowViewModel =
            ViewModelProvider(this)[SlideshowViewModel::class.java]
        slideshowViewModel.mutableLiveDataTopology.observe(viewLifecycleOwner,listUpdateObserver)
        _binding = FragmentTopologyBinding.inflate(inflater, container, false)
        val root: View = binding.root
        recyclerView = _binding!!.recylerViewBir
        recyclerView.setHasFixedSize(true)
        return root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private var listUpdateObserver : Observer<ArrayList<Topology>?> =
        Observer<ArrayList<Topology>?> { arrayListCompetition ->
            recyclerViewAdapter = TopologyAdapter(requireContext(),arrayListCompetition)
            recyclerView.layoutManager = LinearLayoutManager(context)
            recyclerView.adapter = recyclerViewAdapter
        }
}