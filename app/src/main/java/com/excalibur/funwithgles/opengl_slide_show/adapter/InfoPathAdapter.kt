package com.excalibur.funwithgles.opengl_slide_show.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.excalibur.funwithgles.R
import kotlinx.android.synthetic.main.item_info_list.view.*

class InfoPathAdapter : ListAdapter<String,InfoPathAdapter.InfoHolder>(InfoPathDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InfoHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_info_list,parent,false)
        return InfoHolder(view)
    }

    override fun onBindViewHolder(holder: InfoHolder, position: Int) {
        holder.onBind(getItem(holder.adapterPosition))
    }

    inner class InfoHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun onBind(path: String){
            itemView.txtPath.text = path
        }
    }
}

class InfoPathDiffCallback : DiffUtil.ItemCallback<String>() {
    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }
}