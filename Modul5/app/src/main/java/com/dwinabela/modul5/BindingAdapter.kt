package com.dwinabela.modul5

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dwinabela.modul5.network.Province
import com.dwinabela.modul5.ui.ProvinsiListAdapter

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Province>?) {
    val adapter = recyclerView.adapter as ProvinsiListAdapter
    adapter.submitList(data)
}