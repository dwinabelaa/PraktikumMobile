package com.modul4.router.ui.Topology

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.modul4.router.R
import com.modul4.router.model.Topology

class SlideshowViewModel : ViewModel() {

    var mutableLiveDataTopology: MutableLiveData<ArrayList<Topology>?> = MutableLiveData()
    private var arrayListTopology: ArrayList<Topology>? = null

    private fun init(){
        alist()
        mutableLiveDataTopology.value = arrayListTopology
    }

    private fun alist(){
        var elementTopology = Topology(R.string.topologi_ring, R.drawable.topologi_ring)
        arrayListTopology = ArrayList()
        arrayListTopology!!.add(elementTopology)
        elementTopology = Topology(R.string.topologi_mesh, R.drawable.topologi_mesh)
        arrayListTopology!!.add(elementTopology)
        elementTopology = Topology(R.string.topologi_bus, R.drawable.topologi_bus)
        arrayListTopology!!.add(elementTopology)
        elementTopology = Topology(R.string.topologi_star, R.drawable.topologi_star)
        arrayListTopology!!.add(elementTopology)
        elementTopology = Topology(R.string.topologi_tree, R.drawable.topologi_tree)
        arrayListTopology!!.add(elementTopology)
    }
    init {
        init()
    }
}