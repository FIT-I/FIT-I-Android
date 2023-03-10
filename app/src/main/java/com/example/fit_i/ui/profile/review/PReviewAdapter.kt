package com.example.fit_i.ui.profile.review

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.example.fit_i.R
import com.example.fit_i.data.model.response.GetReviewListResponse
import com.example.fit_i.databinding.ItemPreviewBinding
import com.example.fit_i.ui.main.mypage.review.ReviewData

class PReviewAdapter (private val dataList: List<GetReviewListResponse.Result>): RecyclerView.Adapter<PReviewAdapter.ViewHolder>() {
        inner class ViewHolder(private val binding: ItemPreviewBinding) :
            RecyclerView.ViewHolder(binding.root) {

            fun bind(position: Int) {
                binding.tvName.text = dataList[position].name
                binding.tvStar.text = dataList[position].grade.toString()
                binding.tvDate.text = dataList[position].createdAt
                binding.tvReview.text = dataList[position].contents

                when (dataList[position].profile) {
                    "customerProfile1" -> binding.ivReviewer.setImageResource(R.drawable.img_char1)
                    "customerProfile2" -> binding.ivReviewer.setImageResource(R.drawable.img_char2)
                    "customerProfile3" -> binding.ivReviewer.setImageResource(R.drawable.img_char3)
                    "customerProfile4" -> binding.ivReviewer.setImageResource(R.drawable.img_char4)
                    "customerProfile5" -> binding.ivReviewer.setImageResource(R.drawable.img_char5)
                    "customerProfile6" -> binding.ivReviewer.setImageResource(R.drawable.img_char6)
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
