package com.example.fit_i.ui.profile.review

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.example.fit_i.data.model.response.GetReviewListResponse
import com.example.fit_i.databinding.ItemPreviewBinding
import com.example.fit_i.ui.main.mypage.review.ReviewData

class PReviewAdapter (private val dataList: List<GetReviewListResponse.Result>): RecyclerView.Adapter<PReviewAdapter.ViewHolder>() {
        inner class ViewHolder(private val binding: ItemPreviewBinding) :
            RecyclerView.ViewHolder(binding.root) {

            fun bind(position: Int) {
                binding.tvName.text = dataList[position].name
                binding.tvStar.text= dataList[position].grade.toString()
                binding.tvDate.text= dataList[position].createdAt
                binding.tvReview.text=dataList[position].contents

                //viewBinding.imgFricard.setImageResource(dataList[position].front)
                itemView.setOnClickListener {
                    Log.d("Click", "success")
                }
            }
        }


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val viewBinding =
                ItemPreviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return ViewHolder(viewBinding)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(position)
        }

        override fun getItemCount(): Int = dataList.size

    }
