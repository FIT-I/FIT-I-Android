package com.example.fit_i.ui.main.mypage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fit_i.R
import com.example.fit_i.ReviewAdapter
import com.example.fit_i.ReviewData
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
        val ff = inflater.inflate(R.layout.fragment_mypage_review,container,false)
        val ibpre = ff.findViewById<View>(R.id.ib_pre5)

            ibpre.setOnClickListener{
                val mypageFragment = MypageFragment()
                val transaction : FragmentTransaction = requireFragmentManager().beginTransaction()

                //이전 화면으로 이동
                transaction.replace(R.id.fl_container,mypageFragment)
                transaction.commit()

            }

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

        reviewAdapter.setItemClickListener(object : ReviewAdapter.OnItemClickListener {
            override fun onClick(v: View, position: Int) {
                //클릭 시 이벤트 작성하기
                //임의로 홈이랑 연결함
                val mypageReviewIngFragment = MypageReviewIngFragment()
                val transaction : FragmentTransaction = requireFragmentManager().beginTransaction()

                transaction.replace(R.id.fl_container, mypageReviewIngFragment)
                transaction.commit()
            }
        })


        return binding.root

    }
}