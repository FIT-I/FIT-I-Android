package com.example.fit_i.ui.main.mypage.like

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fit_i.databinding.ItemLikelistBinding

class LikelistAdapter(private var dataList: ArrayList<LikelistData>) :
    RecyclerView.Adapter<LikelistAdapter.ViewHolder>() {
    //1 리스트 내 항목 클릭 시 onClick 호출
    override fun onBindViewHolder(holder: ViewHolder, position: Int, payloads: MutableList<Any>) {
        super.onBindViewHolder(holder, position, payloads)
        holder.itemView.setOnClickListener{
            itemClickListener.onClick(it,position)
        }
    }
     // 2 리스너 인터페이스
     interface OnItemClickListener {
     fun onClick(v: View, position: Int)
     }

     // 3 외부에서 클릭 시 이벤트 설정
    fun setItemClickListener(onItemClickListener: OnItemClickListener) {
    this.itemClickListener = onItemClickListener
    }

    // 4 setItemClickListener로 설정한 함수 설정

    private lateinit var itemClickListener: OnItemClickListener

//작동방식은 itemClickListener(어댑터) <-> OnItemClickListener <-> setItemClickListener(액티비티)

inner class ViewHolder(private val binding: ItemLikelistBinding) :
    RecyclerView.ViewHolder(binding.root) {


    fun onBind(position: Int) {
        binding.matchIm.text = dataList[position].im
        binding.matchStar.text = dataList[position].star
        binding.matchUni.text = dataList[position].uni
//        binding.matchIm.text = dataList[position].trainerName
//        binding.matchStar.text = dataList[position].trainerGrade
//        binding.matchUni.text = dataList[position].trainerSchool

        itemView.setOnClickListener {
            Log.d("Click", "success")

        }

    }

}

override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val viewBinding =
        ItemLikelistBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    return ViewHolder(viewBinding)
}

override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.onBind(position)
}

override fun getItemCount(): Int = dataList.size

//API용
fun setList(list: List<LikelistData>){
    //    dataList = list
    }
}



