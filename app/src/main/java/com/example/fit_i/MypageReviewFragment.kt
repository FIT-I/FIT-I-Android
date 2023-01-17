package com.example.fit_i

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fit_i.databinding.FragmentMypageLikelistBinding
import com.example.fit_i.databinding.FragmentMypageReviewBinding

class MypageReviewFragment : Fragment() {
    private lateinit var binding: FragmentMypageReviewBinding
    private val dataList = ArrayList<ReviewData>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMypageReviewBinding.inflate(inflater,container, false)


        //임의로 데이터 넣어보기, 나중에 사진 글라이드 기능 추가
        dataList.apply {
            add(ReviewData("김동현","4.3","숭실대학교"))
            add(ReviewData("김준기","4.3","중앙대학교"))
            add(ReviewData("홍준혁","4.3","건국대학교"))
        }
        val reviewAdapter = ReviewAdapter(dataList)
        binding.rcReview.adapter = reviewAdapter
        var linearLayoutManager = LinearLayoutManager(context)
        binding.rcReview.layoutManager = linearLayoutManager

        return binding.root

    }
}