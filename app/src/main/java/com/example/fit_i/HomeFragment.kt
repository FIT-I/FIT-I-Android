package com.example.fit_i

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fit_i.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    //private val trainerAdapter = TrainerAdapter()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


//val trainer_DataArray : ArrayList<TrainerData> = ArrayList()
    //lateinit var recyclerView : RecyclerView
//    lateinit var trainerAdapter: TrainerAdapter
//    val datas = mutableListOf<TrainerData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        //val fragmentHomeBidning = FragmentHomeBinding.bind(view)
        //binding = fragmentHomeBidning
        binding = FragmentHomeBinding.inflate(layoutInflater)
        //val binding = FragmentHomeBinding.inflate(inflater, container, false)

        val trainerList : ArrayList<TrainerData> = arrayListOf()

        trainerList.apply {
            add(TrainerData("김동현","개인PT",4.3, 5, "숭실대학교","Pt 센터 경력 3년. 스포애니 상도점에서 대표 트레이너로 근무한 경험이 있습니다. 가르치는 것은 자신있습니다.",2.0))
            add(TrainerData("김준기","다이어트", 4.5, 2, "중앙대학교", "중앙대학교 체육대학 지난학기 수석 학생입니다. 배운 내용을 토대로 안전하게 지도해드립니다.",1.2))
            add(TrainerData("홍준혁","식단관리",3.3,7,"숭실대학교","생활체육지도사 2급 자격증 이외의 다양한 자격증을 보유하고있습니다. 믿어주시면 됩니다.",1.2))
            add(TrainerData("노규리","재활치료",5.0,2,"동국대학교","재활관련 센터에서 근무해본 경험이 있습니다.",2.0))
        }

        val trainerAdapter = TrainerAdapter(trainerList)
        binding.rvTrainer.adapter=trainerAdapter

        var linearLayoutManager = LinearLayoutManager(context)
        binding.rvTrainer.layoutManager=linearLayoutManager

//
//        //태그 클릭 구현
//        binding.btnPt.setOnClickListener(object : View.OnClickListener {
//            var isBtnPtSelected = false
//            override fun onClick(v: View) {
//                binding.btnPt.isSelected = !binding.btnPt.isSelected
//                isBtnPtSelected = !isBtnPtSelected
//            }
//        })
//
//        binding.btnDiet.setOnClickListener(object : View.OnClickListener {
//            var isBtnDietSelected = false
//            override fun onClick(v: View) {
//                binding.btnDiet.isSelected = !binding.btnDiet.isSelected
//                isBtnDietSelected = !isBtnDietSelected
//            }
//        })
//
//        binding.btnEating.setOnClickListener(object : View.OnClickListener {
//            var isBtnEatingSelected = false
//            override fun onClick(v: View) {
//                binding.btnEating.isSelected = !binding.btnEating.isSelected
//                isBtnEatingSelected = !isBtnEatingSelected
//            }
//        })
//
//        binding.btnMedical.setOnClickListener(object : View.OnClickListener {
//            var isBtnMedicalSelected = false
//            override fun onClick(v: View) {
//                binding.btnMedical.isSelected = !binding.btnMedical.isSelected
//                isBtnMedicalSelected = !isBtnMedicalSelected
//            }
//        })
//
//        binding.btnFriend.setOnClickListener(object : View.OnClickListener {
//            var isBtnFriendSelected = false
//            override fun onClick(v: View) {
//                binding.btnFriend.isSelected = !binding.btnFriend.isSelected
//                isBtnFriendSelected = !isBtnFriendSelected
//            }
//        })

        binding.llSort.setOnClickListener {
            if (binding.tvSort.text == "실시간 순") {
                binding.tvSort.text = "별점 순"
            }

            else{
                binding.tvSort.text = "실시간 순"
            }

            //일단은 텍스트 변경만. 실제 sorting 코드도 짜야함
        }

        binding.rvTrainer.layoutManager=LinearLayoutManager(context)
        binding.rvTrainer.adapter=trainerAdapter

        //임시 데이터로 확인해보기
        /*
        TrainerAdapter.summitList(mutableListOf<TrainerData>().apply {
            add(ArticleModel("1","맥북 프로16인치",100000,"1,000,000",""))
            add(ArticleModel("1","갤럭시S22",101010,"800,000",""))
        })*/
//
//        val rootView = inflater.inflate(R.layout.fragment_home, container, false)
//        trainer_DataArray.add(TrainerData("이름","카테고리"))
//
//        recyclerView = rootView.findViewById(R.id.rv_trainer)as RecyclerView
//        recyclerView.layoutManager = LinearLayoutManager(requireContext())
//        recyclerView.adapter = TrainerAdapter(requireContext(),trainer_DataArray)
//
//        return rootView
//    }

//        initRecycler()
//        // Inflate the layout for this fragment
//        //return inflater.inflate(R.layout.fragment_home, container, false)
        return binding.root

    }
}