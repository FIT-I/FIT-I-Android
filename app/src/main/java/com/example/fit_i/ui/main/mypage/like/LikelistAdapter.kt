package com.example.fit_i.ui.main.mypage.like

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fit_i.data.model.response.GetTrainerListResponse
import com.example.fit_i.data.model.response.WishResponse
import com.example.fit_i.databinding.ItemLikelistBinding
import com.example.fit_i.databinding.ItemTrainerBinding
import com.example.fit_i.ui.main.mypage.MypageLikelistFragment
import com.example.fit_i.ui.profile.ProfileActivity

class LikelistAdapter(private val dataList: List<WishResponse.Result>): RecyclerView.Adapter<LikelistAdapter.ViewHolder>() {
    inner class ViewHolder(private val binding: ItemLikelistBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(position: Int) {
            binding.tvName.text = dataList[position].trainerName
            binding.tvStar.text= dataList[position].trainerGrade.toString()
            binding.tvStar.text=dataList[position].trainerSchool
            binding.tvDate.text=dataList[position].createdAt

//            Glide.with(context)
//                .load(dataList[position].trainerProfile)
//                .into(binding.ivProfile)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding =
            ItemLikelistBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, ProfileActivity::class.java)
            intent.putExtra(
                "trainerIdx", dataList[position].trainerIdx)
            startActivity(holder.itemView.context, intent, null)
        }
    }

    override fun getItemCount(): Int = dataList.size

}