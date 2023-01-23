package com.example.fit_i

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.example.fit_i.databinding.ItemLikelistBinding

class LikelistAdapter(private val dataList: ArrayList<LikelistData>):
RecyclerView.Adapter<LikelistAdapter.ViewHolder>(){
    inner class ViewHolder(private val binding: ItemLikelistBinding):
            RecyclerView.ViewHolder(binding.root){



                fun onBind(position: Int){
                    binding.matchIm.text = dataList[position].im
                    binding.matchStar.text = dataList[position].star
                    binding.matchUni.text = dataList[position].uni

                    itemView.setOnClickListener{
                        Log.d("Click","success")

                    }
//                    val pos = adapterPosition
//                    if(pos!= RecyclerView.NO_POSITION)
//                    {
//                        itemView.setOnClickListener {
//                            listener?.onItemClick(itemView,item,pos)
//                        }
//                    }

                }

            }
    interface OnItemClicklistener : AdapterView.OnItemClickListener{
        fun onItemClick(v:View, data: LikelistData, position: Int)
    }

//    interface OnItemClickListener{
//        fun onItemClick(v:View, data: ProfileData, pos : Int)
//    }
//    private var listener : OnItemClickListener? = null
//    fun setOnItemClickListener(listener : OnItemClickListener) {
//        this.listener = listener
//    }


//넣을 액티비티나 프래그먼트에 추가하기
//    profileAdapter.setOnItemClickListener(object : ProfileAdapter.OnItemClickListener{
//        override fun onItemClick(v: View, data: ProfileData, pos : Int) {
//            Intent(this@MainActivity, ProfileDetailActivity::class.java).apply {
//                putExtra("data", data)
//                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//            }.run { startActivity(this) }
//        }
//
//    })

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding = ItemLikelistBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(position)
    }

    override fun getItemCount(): Int= dataList.size

}
