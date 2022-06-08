package com.modul4.router.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.modul4.router.R
import com.modul4.router.model.RouterSoftware

class RSoftwareAdapter (
    private val context: Context,
    private val arrayListRouterSoftware: ArrayList<RouterSoftware>
):RecyclerView.Adapter<RSoftwareAdapter.ItemViewHolder>() {
    class ItemViewHolder(val view: View): RecyclerView.ViewHolder(view){
        val namaRouterSoftwaretextView: TextView = view.findViewById(R.id.item_title)
        val gambarRouterSoftware: ImageView = view.findViewById(R.id.item_image)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val RouterSoftwareAdapterlayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item,parent,false)
        return ItemViewHolder(RouterSoftwareAdapterlayout)
    }
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = arrayListRouterSoftware[position]
        holder.namaRouterSoftwaretextView.text =
            context.resources.getString(item.nama)
        holder.gambarRouterSoftware.setImageResource(item.gambar)
        holder.view.setOnClickListener {
            Toast.makeText(context, context.getString(R.string.toast)+"${position+1}", Toast.LENGTH_SHORT).show()
        }
    }
    override fun getItemCount(): Int {
        return arrayListRouterSoftware.size
    }
}
