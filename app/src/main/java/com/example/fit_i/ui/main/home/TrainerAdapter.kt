package com.example.fit_i.ui.main.home

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.fit_i.data.model.response.GetTrainerListResponse
import com.example.fit_i.databinding.ItemTrainerBinding
import com.example.fit_i.ui.profile.ProfileActivity

class TrainerAdapter(private val dataList: List<GetTrainerListResponse.Result.Dto>): RecyclerView.Adapter<TrainerAdapter.ViewHolder>() {
    inner class ViewHolder(private val binding: ItemTrainerBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(position: Int) {
            binding.tvName.text = dataList[position].name
            binding.tvRating.text= dataList[position].grade.toString()
            binding.tvUniv.text=dataList[position].school
            binding.tvPr.text=dataList[position].contents
            binding.tvMoney.text= dataList[position].cost.toString()

            //viewBinding.imgFricard.setImageResource(dataList[position].front)
            itemView.setOnClickListener {
                Log.d("Click", "success")
            }
        }
    }

    interface OnItemClickListener : AdapterView.OnItemClickListener {
        //fun onClick(v: View, position: Int)
        fun onItemClick(v:View, data: TrainerData, position: Int)
        //override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        //  TODO("Not yet implemented")
        //}
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding =
            ItemTrainerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView?.context, ProfileActivity::class.java)
            intent.putExtra("name", dataList[position].name)
            ContextCompat.startActivity(holder.itemView.context, intent, null)
        }
    }

    override fun getItemCount(): Int = dataList.size

}