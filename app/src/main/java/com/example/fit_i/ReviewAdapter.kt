package com.example.fit_i

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fit_i.databinding.ItemLikelistBinding
import com.example.fit_i.databinding.ItemReviewBinding

class ReviewAdapter(private val dataList: ArrayList<ReviewData>):
    RecyclerView.Adapter<ReviewAdapter.ViewHolder>(){
    inner class ViewHolder(private val binding: ItemReviewBinding):
        RecyclerView.ViewHolder(binding.root){



        fun onBind(position: Int){
            binding.reviewIm.text = dataList[position].im
            binding.reviewStar.text = dataList[position].star
            binding.reviewUni.text = dataList[position].uni

            itemView.setOnClickListener{
                Log.d("Click","success")
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding = ItemReviewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(position)
    }

    override fun getItemCount(): Int= dataList.size

}
