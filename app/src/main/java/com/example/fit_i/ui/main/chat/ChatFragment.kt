package com.example.fit_i.ui.main.chat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fit_i.Message
import com.example.fit_i.databinding.FragmentChatBinding

class ChatFragment : Fragment() {
    private lateinit var binding: FragmentChatBinding
    private val dataList = ArrayList<Message>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        binding = FragmentChatBinding.inflate(inflater, container, false)

        //임의로 데이터 넣어보기. 나중에 백엔드 연결하면 필요없나?
        //사진은 어떻게하지??
        dataList.apply {
            add(Message("김동현", "2023.1.1", "PT 문의드립니다~!"))
            add(Message("김준기", "2023.1.3", "저의 몸을 건강하게 해주세요..."))
            add(Message("노규리", "2023.1.3", "핫걸이 되고싶습니당"))
        }
        val chatRoomAdapter = ChatRoomAdapter(dataList)
        binding.rcChat.adapter = chatRoomAdapter
        var linearLayoutManager = LinearLayoutManager(context)
        binding.rcChat.layoutManager = linearLayoutManager

        return binding.root


    }


}