package com.example.fit_i.ui.main.chat

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fit_i.Message
import com.example.fit_i.databinding.ItemChatBinding

class ChatRoomAdapter(private val dataList:ArrayList<Message>):
        RecyclerView.Adapter<ChatRoomAdapter.ViewHolder>(){
            inner class ViewHolder(private val binding: ItemChatBinding) :
                    RecyclerView.ViewHolder(binding.root){

                        fun onBind(position: Int){
                            binding.itemName.text = dataList[position].name
                            binding.itemDate.text = dataList[position].date
                            binding.itemText.text = dataList[position].content


                            itemView.setOnClickListener{
                                Log.d("Click","success")
                            }
                        }
                    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding = ItemChatBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(position)
    }

    override fun getItemCount(): Int =dataList.size

    }


