package com.example.fit_i

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.fit_i.databinding.FragmentHomeBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    //private val trainerAdapter = TrainerAdapter()


    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout

    private val tabTitleArray = arrayOf(
        "개인PT",
        "다이어트",
        "식단관리",
        "재활치료",
        "운동친구"
    )
    private val tabIconArray = arrayOf(
        R.drawable.ic_pt,
        R.drawable.ic_diet,
        R.drawable.ic_eating,
        R.drawable.ic_medical,
        R.drawable.ic_friend
    )


//val trainer_DataArray : ArrayList<TrainerData> = ArrayList()
    //lateinit var recyclerView : RecyclerView
//    lateinit var trainerAdapter: TrainerAdapter
//    val datas = mutableListOf<TrainerData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view:View = inflater.inflate(R.layout.fragment_home, container, false)
        binding = FragmentHomeBinding.inflate(layoutInflater)

        viewPager = view.findViewById(R.id.viewPager2)
        tabLayout = view.findViewById(R.id.tab_layout)

        val trainerList : ArrayList<TrainerData> = arrayListOf()

        trainerList.apply {
            add(TrainerData("김동현","개인PT",4.3, 5, "숭실대학교","Pt 센터 경력 3년. 스포애니 상도점에서 대표 트레이너로 근무한 경험이 있습니다. 가르치는 것은 자신있습니다.",20000))
            add(TrainerData("김준기","다이어트", 4.5, 2, "중앙대학교", "중앙대학교 체육대학 지난학기 수석 학생입니다. 배운 내용을 토대로 안전하게 지도해드립니다.",12000))
            add(TrainerData("홍준혁","식단관리",3.3,7,"숭실대학교","생활체육지도사 2급 자격증 이외의 다양한 자격증을 보유하고있습니다. 믿어주시면 됩니다.",12000))
            add(TrainerData("노규리","재활치료",5.0,2,"동국대학교","재활관련 센터에서 근무해본 경험이 있습니다.",20000))
        }
//
//        val trainerAdapter = TrainerAdapter(trainerList)
//        binding.rvTrainer.adapter=trainerAdapter
//
//        var linearLayoutManager = LinearLayoutManager(context)
//        binding.rvTrainer.layoutManager=linearLayoutManager



        binding.llSort.setOnClickListener {
            if (binding.tvSort.text == "실시간 순") {
                binding.tvSort.text = "별점 순"
            }

            else{
                binding.tvSort.text = "실시간 순"
            }

            //일단은 텍스트 변경만. 실제 sorting 코드도 짜야함
        }
//
//        binding.rvTrainer.layoutManager=LinearLayoutManager(context)
//        binding.rvTrainer.adapter=trainerAdapter

        val pagerAdapter = PagerAdapter(requireActivity())
        pagerAdapter.addFragment(HomePtFragment())
        pagerAdapter.addFragment(HomeDietFragment())
        pagerAdapter.addFragment(HomeEatingFragment())
        pagerAdapter.addFragment(HomeMedicalFragment())
        pagerAdapter.addFragment(HomeFriendFragment())
        // adapter 연결
        viewPager.adapter = pagerAdapter
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int){
                super.onPageSelected(position)
                Log.e("ViewPagerFragment", "Page ${position+1}")
            }
        })

        // tablayout attach
        TabLayoutMediator(tabLayout, viewPager){ tab, position ->
            tab.text = tabTitleArray[position]
            tab.setIcon(tabIconArray[position])
        }.attach()

        return view
    }
}