package com.example.fit_i.ui.main.chat

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.fit_i.Message
import com.example.fit_i.data.model.response.GetChatResponse
import com.example.fit_i.databinding.ItemChatBinding
import com.example.fit_i.ui.profile.ProfileActivity

class ChatRoomAdapter(private val dataList: List<GetChatResponse.Result>):
        RecyclerView.Adapter<ChatRoomAdapter.ViewHolder>(){
            inner class ViewHolder(private val binding: ItemChatBinding) :
                    RecyclerView.ViewHolder(binding.root){

                        fun onBind(position: Int){
                            binding.chatIm.text = dataList[position].trainerName
                            binding.chatStar.text = dataList[position].trainerGrade.toString()
                            binding.chatUni.text = dataList[position].trainerSchool
                            binding.chatUrl.text = dataList[position].openChatLink
                            //binding.chatProfile.imageAlpha = dataList[position].trainerProfile

                        }
                    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding = ItemChatBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(position)

        holder.itemView.setOnClickListener{
            val chatIntent = Intent(holder.itemView.context, ProfileActivity::class.java)
            chatIntent.putExtra(
                "chat", ChatRoom(
                    dataList[position].openChatLink,
                    dataList[position].trainerId,
                    dataList[position].trainerName,
                    dataList[position].trainerGrade,
                    dataList[position].trainerSchool,
                    dataList[position].customerId,
                    dataList[position].pickUp,
                    dataList[position].customerLocation,
                    dataList[position].createdAt,
                    dataList[position].matchingId,
                    dataList[position].trainerProfile))
            ContextCompat.startActivity(holder.itemView.context, chatIntent,null)
        }
    }

    override fun getItemCount(): Int =dataList.size

    }


