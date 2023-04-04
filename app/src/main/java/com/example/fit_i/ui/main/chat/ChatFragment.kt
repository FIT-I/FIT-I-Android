package com.example.fit_i.ui.main.chat

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fit_i.Message
import com.example.fit_i.RetrofitImpl
import com.example.fit_i.data.model.response.GetChatResponse
import com.example.fit_i.data.service.ChatService
import com.example.fit_i.databinding.FragmentChatBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ChatFragment : Fragment() {
    private var _binding: FragmentChatBinding? = null
    private val binding : FragmentChatBinding
    get() = requireNotNull(_binding){"FragmentChatBinding"}


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        _binding = FragmentChatBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadData()

    }

    private fun setAdapter(chatList : List<GetChatResponse.Result>){
        val chatRoomAdpater = ChatRoomAdapter(chatList)
        binding.rcChat.adapter = chatRoomAdpater

        val linearLayoutManager = LinearLayoutManager(context)
        binding.rcChat.layoutManager = linearLayoutManager
        binding.rcChat.setHasFixedSize(true)
    }
    private fun loadData(){
        val chatService = RetrofitImpl.getApiClient().create(ChatService::class.java)
        chatService.chatcustomer().enqueue(object :
        Callback<GetChatResponse>{
            override fun onResponse(
                call: Call<GetChatResponse>,
                response: Response<GetChatResponse>
            ) {
                if (response.isSuccessful){
                    //정상 통신
                    Log.d("post","채팅 onResponse 성공 :" + response.body().toString())
                    if(response.body()?.result?.size==0){
                        binding.clMatchingNo.visibility=View.VISIBLE
                    }
                    else
                        binding.clMatchingNo.visibility=View.INVISIBLE

                    val body = response.body()
                    body?.let {
                        setAdapter(it.result)
                    }
                }else{
                    //통신 실패...
                    Log.d("post","채팅 onResponse 실패")
                }
            }

            override fun onFailure(call: Call<GetChatResponse>, t: Throwable) {
                Log.d("post","onFailure 에러:"+ t.message.toString())
            }

        })
    }


}