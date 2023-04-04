package com.example.fit_i.ui.main.home


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.viewpager2.widget.ViewPager2
import com.example.fit_i.R
import com.example.fit_i.databinding.FragmentHomeBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout
    private lateinit var bottomesheet : BottomSheetFragment

    private val tabTitleArray = arrayOf(
        "개인PT",
        "다이어트",
        "식단관리",
        "재활치료"
    )

//    private val tabIconArray = arrayOf(
//        R.drawable.ic_pt,
//        R.drawable.ic_diet,
//        R.drawable.ic_eating,
//        R.drawable.ic_medical,
//        R.drawable.ic_friend
//    )


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Inflate the layout for this fragment
        val view:View = inflater.inflate(R.layout.fragment_home, container, false)
        binding = FragmentHomeBinding.inflate(layoutInflater)

        viewPager = view.findViewById(R.id.viewPager2)
        tabLayout = view.findViewById(R.id.tab_layout)



        val pagerAdapter = PagerAdapter(requireActivity())
        pagerAdapter.addFragment(HomePtFragment())
        pagerAdapter.addFragment(HomeDietFragment())
        pagerAdapter.addFragment(HomeEatingFragment())
        pagerAdapter.addFragment(HomeMedicalFragment())
//        pagerAdapter.addFragment(HomeFriendFragment())

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
            //tab.setIcon(tabIconArray[position])
        }.attach()

        //bottomesheet
        binding.btnCategory.setOnClickListener{
            val bottomSheet = BottomSheetDialogFragment()
            //이게 맞나ㅏ?
            val manager : FragmentManager = childFragmentManager
            bottomSheet.show(manager, "tag")
            }

        return view
    }
}