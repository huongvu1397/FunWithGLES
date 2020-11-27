package com.excalibur.funwithgles.opengl_slide_show.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.excalibur.funwithgles.R
import com.excalibur.funwithgles.models.MyMedia
import com.excalibur.funwithgles.models.TypeMedia
import kotlinx.android.synthetic.main.item_media_capture.view.*

class SelectAdapter : ListAdapter<MyMedia,SelectAdapter.SelectHolder>(MyMediaDiffCallback()) {

    var listSelect = HashMap<Int,String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_media_capture,parent,false)
        return SelectHolder(view)
    }

    override fun onBindViewHolder(holder: SelectHolder, position: Int) {
        holder.onBind(getItem(holder.adapterPosition))
    }

    inner class SelectHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun onBind(myMedia: MyMedia){
            Glide.with(itemView).load(myMedia.path).into(itemView.imgPreview)
            if(myMedia.typeMedia == TypeMedia.VIDEO){
                itemView.imgPlay.visibility = View.VISIBLE
            }else{
                itemView.imgPlay.visibility = View.GONE
            }
            itemView.setOnClickListener {
                if(listSelect.containsKey(adapterPosition)){
                    listSelect.remove(adapterPosition)
                }else {
                    listSelect[adapterPosition] = myMedia.path
                }
                notifyItemChanged(adapterPosition)
            }
            itemView.cbSelect.isChecked = listSelect.containsKey(adapterPosition)
        }
    }

}

class MyMediaDiffCallback : DiffUtil.ItemCallback<MyMedia>() {
    override fun areItemsTheSame(oldItem: MyMedia, newItem: MyMedia): Boolean {
        return oldItem.path == newItem.path
    }

    override fun areContentsTheSame(oldItem: MyMedia, newItem: MyMedia): Boolean {
        return oldItem.path == newItem.path && oldItem.name == newItem.name && oldItem.typeMedia == newItem.typeMedia
    }
}