package com.example.fit_i.ui.main.home

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fit_i.data.model.response.GetTrainerListResponse
import com.example.fit_i.databinding.ItemTrainerBinding
import com.example.fit_i.ui.profile.ProfileActivity
import kotlinx.coroutines.withContext

class TrainerAdapter(private val dataList: List<GetTrainerListResponse.Result.Dto>): RecyclerView.Adapter<TrainerAdapter.ViewHolder>() {
    inner class ViewHolder(private val binding: ItemTrainerBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(position: Int) {
            binding.tvName.text = dataList[position].name
            binding.tvRating.text= dataList[position].grade.toString()
            binding.tvUniv.text=dataList[position].school
            binding.tvPr.text=dataList[position].contents
            binding.tvMoney.text= dataList[position].cost.toString()

            //프로필 이미지 바인딩
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding =
            ItemTrainerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, ProfileActivity::class.java)
            intent.putExtra(
                "trainerIdx", dataList[position].id)
            startActivity(holder.itemView.context, intent, null)
        }
    }

    override fun getItemCount(): Int = dataList.size

}