package com.example.fit_i

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.example.fit_i.databinding.ItemPreviewBinding
import com.example.fit_i.databinding.ItemReviewBinding

class PReviewAdapter (private val dataList: ArrayList<Review>): RecyclerView.Adapter<PReviewAdapter.ViewHolder>() {
        inner class ViewHolder(private val binding: ItemPreviewBinding) :
            RecyclerView.ViewHolder(binding.root) {

            fun bind(position: Int) {
                binding.tvNameT.text = dataList[position].name
                binding.tvStar.text= dataList[position].star.toString()
                binding.tvDateT.text= dataList[position].date
                binding.tvReview.text=dataList[position].review

                //viewBinding.imgFricard.setImageResource(dataList[position].front)
                itemView.setOnClickListener {
                    Log.d("Click", "success")
                }
            }
        }

        interface OnItemClickListener : AdapterView.OnItemClickListener {
            //fun onClick(v: View, position: Int)
            fun onItemClick(v: View, data:ReviewData, position: Int)
            //override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            //  TODO("Not yet implemented")
            //}
        }


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val viewBinding =
                ItemPreviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return ViewHolder(viewBinding)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(position)
            /*
            holder.itemView.setOnClickListener {
                val intent = Intent(holder.itemView?.context, CardDetailActivity::class.java)
                intent.putExtra("front", dataList[position].front)
                intent.putExtra("back", dataList[position].back)
                intent.putExtra("name", dataList[position].name)
                ContextCompat.startActivity(holder.itemView.context, intent, null)
            }*/
        }

        override fun getItemCount(): Int = dataList.size

    }
