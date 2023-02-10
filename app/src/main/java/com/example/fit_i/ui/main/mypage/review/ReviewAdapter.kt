package com.example.fit_i.ui.main.mypage.review


import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.fit_i.data.model.response.GetMCResponse
import com.example.fit_i.databinding.ItemReviewBinding
import com.example.fit_i.ui.profile.ProfileActivity

class ReviewAdapter(private val dataList: List<GetMCResponse.Result>):        RecyclerView.Adapter<ReviewAdapter.ViewHolder>(){
    inner class ViewHolder(private val binding: ItemReviewBinding):
    RecyclerView.ViewHolder(binding.root) {

        fun onBind(position: Int) {
            binding.reviewIm.text = dataList[position].name
            binding.reviewStar.text = dataList[position].grade.toString()
            binding.reviewUni.text = dataList[position].school

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding = ItemReviewBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return ViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(position)

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, ProfileActivity::class.java)
            intent.putExtra(
                "Id", dataList[position].trainerId)
            ContextCompat.startActivity(holder.itemView.context, intent, null)
        }
    }

    override fun getItemCount(): Int= dataList.size

}

