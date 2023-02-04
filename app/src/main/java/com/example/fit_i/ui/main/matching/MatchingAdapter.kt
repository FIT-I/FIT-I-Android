package com.example.fit_i.ui.main.matching

import android.content.Context
import android.provider.ContactsContract.CommonDataKinds.Photo
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fit_i.R
import com.example.fit_i.data.model.response.GetMatchingResponse
import com.example.fit_i.databinding.ItemMatchBinding

class MatchingAdapter(
    private val dataList: List<GetMatchingResponse.Result>, val context: Context?)
    : RecyclerView.Adapter<MatchingAdapter.ViewHolder>(){

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        //여기서 item이랑은 연결된거
        var im: TextView = itemView.findViewById(R.id.match_im)
        var uni: TextView = itemView.findViewById<TextView>(R.id.match_uni)
        var star: TextView = itemView.findViewById<TextView>(R.id.match_star)
        var day: TextView = itemView.findViewById<TextView>(R.id.match_day)
        var prof: ImageView = itemView.findViewById(R.id.match_profile)

    }

    //데이터랑 아이템이랑 연결하는거
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchingAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_match,parent,false)
        return ViewHolder(view)
    }

    //뷰에 들어가는거
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item : GetMatchingResponse.Result = dataList!!.get(position)
        val imgUrl : String = dataList[position].profile

        if (imgUrl.length > 0) {
            Glide.with(holder.prof.context)
                .load(imgUrl)
                .error(android.R.drawable.stat_notify_error)
                .into(holder.prof)
    }else{
        Glide.with(holder.prof.context)
            .load(imgUrl)//가져올 이미지
            .error(android.R.drawable.stat_notify_error)//에러 시 보여줄 이미지
            .into(holder.prof)//이미지를 보여줄 View
        }
        //날짜 구현 자세히 변경하기
//        val date : String = dataList[position].orderDate
//        val dategap : Int = dataList[position].orderDateGap
//        if ()

        holder.star.text = dataList[position].grade.toString()
        holder.day.text = dataList[position].orderDate
        holder.im.text = dataList[position].name
        holder.uni.text = dataList[position].school }


    override fun getItemCount(): Int {
        return dataList.size
    }




//fun bindMatch(dataList : GetMatchingResponse) {
//    val im = itemView.findViewById<TextView>(R.id.match_im)

//            val phto = itemPhoto?.profile.toString()
//            if (phto.isEmpty()) {
//                prof?.setImageResource(R.mipmap.ic_launcher)
//            } else {
//                prof?.visibility = View.GONE
//            }
//            im?.text = itemPhoto?.name
//            star?.text = itemPhoto?.grade.toString()
//            day?.text = itemPhoto?.orderDateGap.toString()
//            uni?.text = itemPhoto?.school
//
//            itemView.setOnClickListener {
//                Log.d("Click", "success")
//

}



//    
//    inner class ViewHolder(private val binding: ItemMatchBinding) :
//            RecyclerView.ViewHolder(binding.root){
//
//                fun onBind(position: Int){
////                    binding.matchIm.text = dataList[position].im
////                    binding.matchStar.text = dataList[position].star
////                    binding.matchUni.text= dataList[position].uni
////                    binding.matchDay.text=dataList[position].day
////                    binding.matchProfile.imageview=dataList[position].prof
//                    val im = ItemMatchBinding.bind(R.id.textView)
//
//                    itemView.setOnClickListener{
//                        Log.d("Click","success")
//                    }
//
//
//                }
//            }





