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
import com.modul4.router.model.RouterHardware

class RHardwareAdapter (
    private val context: Context,
    private val arrayListRouterHardware: ArrayList<RouterHardware>
):RecyclerView.Adapter<RHardwareAdapter.ItemViewHolder>() {
    class ItemViewHolder(val view: View): RecyclerView.ViewHolder(view){
        val namaRouterHardwaretextView: TextView =
            view.findViewById(R.id.item_title)
        val gambarRouterHardware: ImageView = view.findViewById(R.id.item_image)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ItemViewHolder {
        val routerHardwareAdapterlayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item,parent,false)
        return ItemViewHolder(routerHardwareAdapterlayout)
    }
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = arrayListRouterHardware[position]
        holder.namaRouterHardwaretextView.text =
            context.resources.getString(item.nama)
        holder.gambarRouterHardware.setImageResource(item.gambar)
        holder.view.setOnClickListener {
            Toast.makeText(context,
                context.getString(R.string.toast)+"${position+1}", Toast.LENGTH_SHORT).show()
        }
    }
    override fun getItemCount(): Int {
        return arrayListRouterHardware.size
    }
}