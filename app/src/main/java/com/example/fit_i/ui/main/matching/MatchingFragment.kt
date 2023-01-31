package com.example.fit_i.ui.main.matching

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fit_i.databinding.FragmentMatchingBinding


class MatchingFragment : Fragment() {
    private lateinit var binding: FragmentMatchingBinding
    private val dataList = ArrayList<MatchingData>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMatchingBinding.inflate(inflater, container, false)


        //임의의 데이터들
        dataList.apply {
            add(MatchingData("김동현","4.3","5","숭실대학교"))
            add(MatchingData("김준기","4.3","3","중앙대학교"))
            add(MatchingData("홍준혁","4.3","1","건국대학교"))

        }
        val matchingAdapter = MatchingAdapter(dataList)
        binding.rcMatch.adapter = matchingAdapter
        var linearLayoutManager = LinearLayoutManager(context)
        binding.rcMatch.layoutManager = linearLayoutManager

        return binding.root
    }


}
