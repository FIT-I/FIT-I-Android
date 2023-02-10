package com.example.fit_i.ui.main.home

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log.w
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.fit_i.R
import com.example.fit_i.databinding.FragmentBottomsheetBinding
import com.example.fit_i.databinding.FragmentHomePtBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import java.util.logging.Logger


class BottomSheetFragment(val itemClick: (Int) -> Unit) : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_bottomsheet, container, false)
        val time : TextView = view.findViewById(R.id.tv_sort_time)
        val level : TextView = view.findViewById(R.id.tv_sort_level)
        val high : TextView = view.findViewById(R.id.tv_sort_high)
        val low : TextView = view.findViewById(R.id.tv_sort_low)

        time.setOnClickListener {
            Toast.makeText(activity, "실시간 순", Toast.LENGTH_SHORT).show()
            itemClick(0)
            dismiss()
        }

        level.setOnClickListener {
            Toast.makeText(activity, "레벨 순", Toast.LENGTH_SHORT).show()
            itemClick(1)
            dismiss()
        }

        low.setOnClickListener {
            Toast.makeText(activity, "가격 낮은 순", Toast.LENGTH_SHORT).show()
            itemClick(2)
            dismiss()
        }

        high.setOnClickListener {
            Toast.makeText(activity, "가격 높은 순", Toast.LENGTH_SHORT).show()
            itemClick(3)
            dismiss()
        }

        return view
    }
}