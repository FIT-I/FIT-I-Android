package com.example.fit_i.ui.main.matching

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import com.example.fit_i.data.model.response.GetMCResponse
import com.example.fit_i.databinding.ItemMatchBinding
import com.example.fit_i.ui.profile.ProfileActivity

class MatchingAdapter(private val dataList: List<GetMCResponse.Result>): RecyclerView.Adapter<MatchingAdapter.ViewHolder>(){
    inner class ViewHolder(private val binding: ItemMatchBinding) :
            RecyclerView.ViewHolder(binding.root){

                fun onBind(position: Int){
                    binding.matchIm.text = dataList[position].name
                    binding.matchStar.text = dataList[position].grade.toString()
                    binding.matchUni.text= dataList[position].school
                    binding.matchDay.text=dataList[position].orderDate
                    //binding.matchProfile.imageAlpha = dataList[position].profile.toInt()


                }
            }

    //초기화 시켜주는 기능
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding = ItemMatchBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(viewBinding)
    }

    //view 연결하는 기능, viewholder와 아이템
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(position)

        //아이템 클릭시 트레이너 프로필란으로 이동하는 기능
        holder.itemView.setOnClickListener{

            val matchingIntent = Intent(holder.itemView.context, MatchingListActivity::class.java)
            matchingIntent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(holder.itemView.context,matchingIntent,null)

//            matchingIntent.putExtra("matching",MatchingData(dataList[position].profile,dataList[position].name,dataList[position].grade,dataList[position].school,dataList[position].orderDate))


        }
    }

    override fun getItemCount(): Int {
        Log.d("size", dataList.size.toString())
        return dataList.size
    }
    }




