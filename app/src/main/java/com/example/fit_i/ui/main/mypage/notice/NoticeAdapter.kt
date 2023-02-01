package com.example.fit_i.ui.main.mypage.notice

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
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
//
//
//    interface OnItemClickListener : AdapterView.OnItemClickListener {
//        fun onClick(v: View, position: Int)
//        fun onItemClick(v: View, data: NoticeData, position: Int)
//        override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
//        }
//    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding =
            ItemNoticeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)

        holder.itemView.setOnClickListener {

//            val mypageSettingFragment = MypageSettingFragment()
//            val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()
//
//            transaction.add(R.id.fl_container, mypageSettingFragment)
//            transaction.commit()

//            Toast.makeText(context,"토스트 메세지 띄우기 입니다.", Toast.LENGTH_SHORT).show()

            val noticeIntent = Intent(holder.itemView.context, MypageNoticeMoreActivity::class.java)
            noticeIntent.putExtra("title", dataList[position].title)
            noticeIntent.putExtra("contents", dataList[position].contents)
            noticeIntent.putExtra("createdAt", dataList[position].createdAt)


            startActivity(holder.itemView.context, noticeIntent, null)
        }
    }

    override fun getItemCount(): Int = dataList.size

}