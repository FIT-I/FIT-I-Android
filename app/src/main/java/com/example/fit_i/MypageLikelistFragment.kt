package com.example.fit_i

import android.graphics.Insets.add
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fit_i.databinding.FragmentMypageLikelistBinding

class MypageLikelistFragment : Fragment() {
    private lateinit var binding: FragmentMypageLikelistBinding
    private val dataList = ArrayList<LikelistData>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMypageLikelistBinding.inflate(inflater,container, false)


        //임의로 데이터 넣어보기, 나중에 사진 글라이드 기능 추가
        dataList.apply {
            add(LikelistData("김동현","4.3","숭실대학교","어제"))
            add(LikelistData("김준기","4.3","중앙대학교","월요일"))
            add(LikelistData("홍준혁","4.3","건국대학교","2023.1.4"))
        }
        val likelistAdapter = LikelistAdapter(dataList)
        binding.rcLikelist.adapter = likelistAdapter
        var linearLayoutManager = LinearLayoutManager(context)
        binding.rcLikelist.layoutManager = linearLayoutManager



        return binding.root

    }
}