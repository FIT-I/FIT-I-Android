package com.example.fit_i.ui.main.mypage.review


import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fit_i.data.model.response.GetMCResponse
import com.example.fit_i.databinding.ItemReviewBinding
import com.example.fit_i.ui.profile.ProfileActivity

class ReviewAdapter(private val dataList: List<GetMCResponse.Result>):
    RecyclerView.Adapter<ReviewAdapter.ViewHolder>(){
    inner class ViewHolder(private val binding: ItemReviewBinding):
    RecyclerView.ViewHolder(binding.root) {

        fun onBind(position: Int) {
            binding.tvName.text = dataList[position].name
            binding.tvGrade.text = dataList[position].grade.toString()
            binding.tvSchool.text = dataList[position].school

            if (dataList[position].profile != "trainerProfile"|| dataList[position].profile  != null) {
                Glide.with(itemView)
                    .load("${dataList[position]?.profile}")
                    .into(binding.ivProfile)
                Log.d("post", dataList[position].profile)
            }

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding = ItemReviewBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return ViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(position)

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, MypageReviewWriteActivity::class.java)
            intent.putExtra(
                "reviewIdx", dataList[position].trainerId)
            ContextCompat.startActivity(holder.itemView.context, intent, null)
        }
    }

    override fun getItemCount(): Int= dataList.size

}

