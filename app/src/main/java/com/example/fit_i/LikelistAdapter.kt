package com.example.fit_i

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fit_i.databinding.ItemLikelistBinding

class LikelistAdapter(private val dataList: ArrayList<LikelistData>):
RecyclerView.Adapter<LikelistAdapter.ViewHolder>(){
    inner class ViewHolder(private val binding: ItemLikelistBinding):
            RecyclerView.ViewHolder(binding.root){



                fun onBind(position: Int){
                    binding.matchIm.text = dataList[position].im
                    binding.matchStar.text = dataList[position].star
                    binding.matchUni.text = dataList[position].uni

                    itemView.setOnClickListener{
                        Log.d("Click","success")
                    }

                }
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding = ItemLikelistBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(position)
    }

    override fun getItemCount(): Int= dataList.size

}
