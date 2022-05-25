package com.dwinabela.modul5.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dwinabela.modul5.network.Province
import com.dwinabela.modul5.network.ProvinsiApi
import kotlinx.coroutines.launch

class ProvinsiViewModel : ViewModel() {
    private val _provinsi = MutableLiveData<List<Province>>()
    val province: LiveData<List<Province>> = _provinsi

    private val _provinsiTunggal = MutableLiveData<Province>()
    val provinsiTunggal : LiveData<Province> = _provinsiTunggal

    fun getProvinsi() {
        viewModelScope.launch {
            try {
                _provinsi.value = ProvinsiApi.retrofitServiceApi.getData()
                Log.d("berhasil",province.value.toString())
            }catch (e: Exception){
                _provinsi.value = listOf(Province(1,"gagal"))
                Log.d("error", e.stackTraceToString())
            }
        }
    }

    fun onProvinsiClicked(provinsi: Province){
        _provinsiTunggal.value = provinsi
    }
}

