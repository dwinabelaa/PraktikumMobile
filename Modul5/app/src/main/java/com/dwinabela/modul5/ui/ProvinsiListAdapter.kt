package com.dwinabela.modul5.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.ListAdapter
import com.dwinabela.modul5.databinding.ListViewItemBinding
import com.dwinabela.modul5.network.Province

class ProvinsiListAdapter(private val clickListener: ProvinsiListener) :
    ListAdapter<Province, ProvinsiListAdapter.ProvinsiViewHolder>(DiffCallback)
{
    class ProvinsiViewHolder(
        var binding: ListViewItemBinding
    ) : RecyclerView.ViewHolder(binding.root){
        fun bind(clickListener: ProvinsiListener, provinsi: Province){
            binding.provinsi = provinsi
            binding.clicklistener = clickListener
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Province>(){
        override fun areItemsTheSame(oldItem: Province, newItem: Province): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Province, newItem: Province): Boolean {
            return oldItem.id == newItem.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ProvinsiViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ProvinsiViewHolder(
            ListViewItemBinding.inflate(layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ProvinsiViewHolder, position: Int){
        val provinsi = getItem(position)
        holder.bind(clickListener, provinsi)
    }
}

class ProvinsiListener(val clickListener: (provinsi: Province) -> Unit){
    fun onClickk(provinsi: Province) = clickListener(provinsi)
}