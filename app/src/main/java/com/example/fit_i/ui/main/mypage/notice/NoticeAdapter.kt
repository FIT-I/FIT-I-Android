package com.example.fit_i.ui.main.mypage.notice

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.example.fit_i.TrainerData
import com.example.fit_i.data.model.response.GetAnnouncementResponse
import com.example.fit_i.databinding.ItemNoticeBinding


class NoticeAdapter(private val dataList: List<GetAnnouncementResponse.Result>): RecyclerView.Adapter<NoticeAdapter.ViewHolder>() {
    inner class ViewHolder(private val binding: ItemNoticeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(position: Int) {

            binding.tvNoticeTitle.text = dataList[position].title
            binding.tvNoticeDate.text = dataList[position].createdAt

            //viewBinding.imgFricard.setImageResource(dataList[position].front)
            itemView.setOnClickListener {
                Log.d("Click", "success")
            }
        }

    }


    interface OnItemClickListener : AdapterView.OnItemClickListener {
        //fun onClick(v: View, position: Int)
        fun onItemClick(v: View, data: TrainerData, position: Int)
        //override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        //  TODO("Not yet implemented")
        //}
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding =
            ItemNoticeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)

        holder.itemView.setOnClickListener {
//            val intent = Intent(holder.itemView?.context, ProfileActivity::class.java)
//            intent.putExtra("name", dataList[position].title)
//            ContextCompat.startActivity(holder.itemView.context, intent, null)
        }
    }

    override fun getItemCount(): Int = dataList.size

}