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
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import java.util.logging.Logger


class BottomSheetFragment(val itemClick: (Int) -> Unit) :
    BottomSheetDialogFragment() {

    private var _binding: FragmentBottomsheetBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?{
        _binding = FragmentBottomsheetBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.tvSortTime.setOnClickListener {
            Toast.makeText(activity, "최신 순", Toast.LENGTH_SHORT).show()
            itemClick(0)
            dismiss()
        }

        binding.tvSortLevel.setOnClickListener {
            Toast.makeText(activity, "등급 순", Toast.LENGTH_SHORT).show()
            itemClick(1)
            dismiss()
        }

        binding.tvSortDistance.setOnClickListener {
            Toast.makeText(activity, "거리 순", Toast.LENGTH_SHORT).show()
            itemClick(2)
            dismiss()
        }

        binding.tvSortLike.setOnClickListener {
            Toast.makeText(activity, "찜 많은 순", Toast.LENGTH_SHORT).show()
            itemClick(3)
            dismiss()
        }

        binding.tvSortReview.setOnClickListener{
            Toast.makeText(activity, "찜 많은 순", Toast.LENGTH_SHORT).show()
            itemClick(4)
            dismiss()

        }

    }
}