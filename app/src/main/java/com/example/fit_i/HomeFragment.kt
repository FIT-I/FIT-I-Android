package com.example.fit_i

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fit_i.databinding.FragmentHomeBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    //lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //binding = FragmentHomeBinding.inflate(layoutInflater)
        val binding = FragmentHomeBinding.inflate(inflater, container, false)

        //태그 클릭 구현
        binding.btnPt.setOnClickListener(object : View.OnClickListener {
            var isBtnPtSelected = false
            override fun onClick(v: View) {
                binding.btnPt.isSelected = !binding.btnPt.isSelected
                isBtnPtSelected = !isBtnPtSelected
            }
        })

        binding.btnDiet.setOnClickListener(object : View.OnClickListener {
            var isBtnDietSelected = false
            override fun onClick(v: View) {
                binding.btnDiet.isSelected = !binding.btnDiet.isSelected
                isBtnDietSelected = !isBtnDietSelected
            }
        })

        binding.btnEating.setOnClickListener(object : View.OnClickListener {
            var isBtnEatingSelected = false
            override fun onClick(v: View) {
                binding.btnEating.isSelected = !binding.btnEating.isSelected
                isBtnEatingSelected = !isBtnEatingSelected
            }
        })

        binding.btnMedical.setOnClickListener(object : View.OnClickListener {
            var isBtnMedicalSelected = false
            override fun onClick(v: View) {
                binding.btnMedical.isSelected = !binding.btnMedical.isSelected
                isBtnMedicalSelected = !isBtnMedicalSelected
            }
        })

        binding.btnFriend.setOnClickListener(object : View.OnClickListener {
            var isBtnFriendSelected = false
            override fun onClick(v: View) {
                binding.btnFriend.isSelected = !binding.btnFriend.isSelected
                isBtnFriendSelected = !isBtnFriendSelected
            }
        })

        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_home, container, false)

        return binding.root
    }
}