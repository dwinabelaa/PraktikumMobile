package com.modul4.router.ui.RSoftware

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.modul4.router.R
import com.modul4.router.model.RouterSoftware

class RSoftwareViewModel : ViewModel() {

    var mutableLiveDataRSoftware: MutableLiveData<ArrayList<RouterSoftware>?> = MutableLiveData()
    private var arrayListRouterSoftware: ArrayList<RouterSoftware>? = null

    private fun init(){
        alist()
        mutableLiveDataRSoftware.value = arrayListRouterSoftware
    }

    private fun alist(){
        var element = RouterSoftware(R.string.linux, R.drawable.linux)
        arrayListRouterSoftware = ArrayList()
        arrayListRouterSoftware!!.add(element)
        element = RouterSoftware(R.string.windows, R.drawable.windows)
        arrayListRouterSoftware!!.add(element)
        element = RouterSoftware(R.string.macos, R.drawable.macos)
        arrayListRouterSoftware!!.add(element)
    }
    init {
        init()
    }
}