package com.example.fit_i

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fit_i.databinding.FragmentHomePtBinding

class HomePtFragment : Fragment() {
    private lateinit var binding: FragmentHomePtBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomePtBinding.inflate(layoutInflater)

        val trainerList : ArrayList<TrainerData> = arrayListOf()

        trainerList.apply {
            add(TrainerData("김동현","개인PT",4.3, 5, "숭실대학교","Pt 센터 경력 3년. 스포애니 상도점에서 대표 트레이너로 근무한 경험이 있습니다. 가르치는 것은 자신있습니다.",20000))
            add(TrainerData("김준기","다이어트", 4.5, 2, "중앙대학교", "중앙대학교 체육대학 지난학기 수석 학생입니다. 배운 내용을 토대로 안전하게 지도해드립니다.",12000))
            add(TrainerData("홍준혁","식단관리",3.3,7,"숭실대학교","생활체육지도사 2급 자격증 이외의 다양한 자격증을 보유하고있습니다. 믿어주시면 됩니다.",12000))
            add(TrainerData("노규리","재활치료",5.0,2,"동국대학교","재활관련 센터에서 근무해본 경험이 있습니다.",20000))
        }

        val trainerAdapter = TrainerAdapter(trainerList)
        binding.rvTrainer.adapter=trainerAdapter

        val linearLayoutManager = LinearLayoutManager(context)
        binding.rvTrainer.layoutManager=linearLayoutManager

        binding.llSort.setOnClickListener {
            if (binding.tvSort.text == "실시간 순") {
                binding.tvSort.text = "별점 순"
            } else binding.tvSort.text = "실시간 순"
        } //일단은 텍스트 변경만. 실제 sorting 코드도 짜야함

        return binding.root
    }
}