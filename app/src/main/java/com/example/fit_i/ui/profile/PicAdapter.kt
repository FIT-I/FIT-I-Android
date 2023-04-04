package com.example.fit_i.ui.profile


import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fit_i.data.model.response.GetTrainerInfoResponse
import com.example.fit_i.databinding.ItemPicBinding

class PicAdapter(private val dataList: GetTrainerInfoResponse.Result): RecyclerView.Adapter<PicAdapter.ViewHolder>() {
    inner class ViewHolder(private val binding: ItemPicBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(position: Int) {

            Glide.with(itemView)
                .load("${dataList.imageList?.get(position)}")
                .into(binding.ivPic)
            binding.ivPic.clipToOutline = true
            Log.d("post", dataList.imageList.toString())

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding =
            ItemPicBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)

        holder.itemView.setOnClickListener {}
    }

    override fun getItemCount(): Int = dataList.imageList!!.size

}