package com.example.fit_i

import android.app.Activity
import android.app.Dialog
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log.w
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.example.fit_i.databinding.FragmentBottomsheetBinding
import com.example.fit_i.databinding.FragmentHomePtBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import java.util.logging.Logger

class BottomSheetFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentBottomsheetBinding
//
//
//    private lateinit var time: TextView
//    private lateinit var level: TextView
//    private lateinit var time: TextView
    lateinit var sortText : TextView
    lateinit var select: String



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentBottomsheetBinding.inflate(layoutInflater)
//        sortText = view?.findViewById<TextView>(R.id.tv_sort)!!

//        sortText.text="실시간 순"

        binding.tvSortTime.setOnClickListener(){
            Toast.makeText(activity,"실시간 순 정렬",Toast.LENGTH_SHORT).show();
            select = "실시간 순"
        }

        binding.tvSortLevel.setOnClickListener(){
            Toast.makeText(activity,"트레이너 레벨 순 정렬",Toast.LENGTH_SHORT).show();
            select="트레이너 레벨 순"
        }
        binding.tvSortLow.setOnClickListener(){
            Toast.makeText(activity,"낮은 가격 순 정렬",Toast.LENGTH_SHORT).show();
            select="낮은 가격 순"
        }
        binding.tvSortHigh.setOnClickListener(){
            Toast.makeText(activity,"높은 가격 순 정렬",Toast.LENGTH_SHORT).show();
            select="높은 가격 순"
        }

        // 텍스트뷰 세팅
        //tvDone.setOnClickListener(this)
        //sortText.text = select
        return inflater.inflate(R.layout.fragment_bottomsheet, container, false)
    }

    companion object {
        const val TAG = "BottomSheetFragment"
    }
}