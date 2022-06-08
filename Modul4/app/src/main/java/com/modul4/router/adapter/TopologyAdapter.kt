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
import com.modul4.router.model.Topology

class TopologyAdapter (
    private val context: Context,
    private val arrayList: ArrayList<Topology>
):RecyclerView.Adapter<TopologyAdapter.ItemViewHolder>() {
    class ItemViewHolder(val view: View): RecyclerView.ViewHolder(view){
        val namaTopologitextView: TextView = view.findViewById(R.id.item_title)
        val gambarTopologi: ImageView = view.findViewById(R.id.item_image)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ItemViewHolder {
        val topologyAdapterlayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item,parent,false)
        return ItemViewHolder(topologyAdapterlayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = arrayList[position]
        holder.namaTopologitextView.text = context.resources.getString(item.nama)
        holder.gambarTopologi.setImageResource(item.gambar)
        holder.view.setOnClickListener {
            Toast.makeText(context,
                context.getString(R.string.toast)+"${position+1}", Toast.LENGTH_SHORT).show()
        }
    }
    override fun getItemCount(): Int {
        return arrayList.size
    }
}
