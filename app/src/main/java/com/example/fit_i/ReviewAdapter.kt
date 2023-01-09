package com.example.fit_i

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fit_i.databinding.ItemReviewBinding
import java.lang.reflect.Member


class ReviewAdapter :
RecyclerView.Adapter<Holder>(){
   var listData= mutableListOf<ReviewData>()

    override fun onCreateViewHolder(parent:ViewGroup,viewType:Int):Holder{
        val binding = ItemReviewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Holder(binding)
    }
    override fun onBindViewHolder(holder: Holder, position: Int) {
        val reviewData = listData[position]
        holder.setData(reviewData)
    }
    override fun getItemCount(): Int {
        return listData.size
    }




}
class Holder(val binding: ItemReviewBinding):RecyclerView.ViewHolder(binding.root) {
    fun setData(reviewData: ReviewData) {
        binding.reviewNameItem.text = ReviewData.name
        binding.reviewDateItem.text = ReviewData.date
        binding.reviewContextItem.text = ReviewData.review
    }
}