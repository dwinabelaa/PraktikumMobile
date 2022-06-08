package com.modul4.router.ui.RHardware

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.modul4.router.R
import com.modul4.router.model.RouterHardware

class RHardwareViewModel : ViewModel() {

    var mutableLiveDataRouterHardware: MutableLiveData<ArrayList<RouterHardware>?> = MutableLiveData()
    private var arrayListRouterHardware: ArrayList<RouterHardware>? = null

    private fun init(){
        alist()
        mutableLiveDataRouterHardware.value = arrayListRouterHardware
    }

    private fun alist(){
        var element = RouterHardware(R.string.mikrotik, R.drawable.mikrotik)
        arrayListRouterHardware = ArrayList()
        arrayListRouterHardware!!.add(element)
        element = RouterHardware(R.string.cisco, R.drawable.cisco)
        arrayListRouterHardware!!.add(element)
        element = RouterHardware(R.string.tp_link, R.drawable.tp_link)
        arrayListRouterHardware!!.add(element)
    }
    init {
        init()
    }
}