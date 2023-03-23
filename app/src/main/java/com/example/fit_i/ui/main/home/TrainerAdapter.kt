package com.example.fit_i.ui.main.home

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fit_i.R
import com.example.fit_i.data.model.response.GetTrainerListResponse
import com.example.fit_i.databinding.ItemTrainerBinding
import com.example.fit_i.ui.profile.ProfileActivity

class TrainerAdapter(private val dataList: List<TrainerData>):
    RecyclerView.Adapter<TrainerAdapter.ViewHolder>() {

    //서버 연결 전 버전
    inner class ViewHolder(private val binding: ItemTrainerBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun bind(position: Int){
                binding.tvName.text = dataList[position].name
//                binding.ivProfile.setImageResource(dataList[position].profile)
//                binding.ivRank.setImageResource(dataList[position].grade)//다시 확인 사진
                binding.tvRating.text = dataList[position].contents
                binding.tvReviewCount.text = dataList[position].review
                binding.tvUniv.text = dataList[position].school
                binding.tvKm.text = dataList[position].km
                binding.tvMoney.text = dataList[position].cost

                itemView.setOnClickListener{
                    //이동 기능 넣기
                    Log.d("Click","succuess")
                }

            }
    }

    //서버 연결 후
//        fun bind(position: Int) {
//            binding.tvName.text = dataList[position].name
//            binding.tvRating.text= dataList[position].grade.toString()
//            binding.tvUniv.text=dataList[position].school
//            binding.tvPr.text=dataList[position].contents
//            binding.tvMoney.text= dataList[position].cost.toString()
//
//            //레벨
//            when (dataList[position].levelName) {
//                "gold" -> binding.ivRank.setImageResource(R.drawable.ic_gold)
//                "sliver" -> binding.ivRank.setImageResource(R.drawable.ic_silver)
//                "bronze" -> binding.ivRank.setImageResource(R.drawable.ic_bronze)
//            }
//            if (dataList[position].profile == "trainerProfile"){
//                binding.ivProfile.setImageResource(R.drawable.ic_profile)
//            }
//            else if (dataList[position].profile != "trainerProfile"|| dataList[position].profile != null) {
//                Glide.with(itemView)
//                    .load("${dataList[position].profile}")
//                    .into(binding.ivProfile)
//                binding.ivProfile.clipToOutline = true
//                Log.d("post", dataList[position].profile)
//            }
//        }
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding =
            ItemTrainerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)

//서버 연결시
//        holder.itemView.setOnClickListener {
//            val intent = Intent(holder.itemView.context, ProfileActivity::class.java)
//            intent.putExtra(
//                "trainerIdx", dataList[position].id)
//            startActivity(holder.itemView.context, intent, null)
//        }
    }

    override fun getItemCount(): Int = dataList.size

}