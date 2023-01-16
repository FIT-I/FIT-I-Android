package com.example.fit_i

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.widget.Button
import androidx.fragment.app.DialogFragment
import com.example.fit_i.databinding.DialogLayoutBinding

//const val EXTRA_NOTICE_SAVE = "EXTRA_NOTICE_SAVE"
//const val TAG_DIALOG_EVENT = "TAG_DIALOG_EVENT"


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class Dialog : DialogFragment() {
    private var _binding: DialogLayoutBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DialogLayoutBinding.inflate(inflater,container,false)

        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val view = inflater.inflate(R.layout.dialog_layout,container, false)
//        val btncancel = view.findViewById<View>(R.id.btn_cancel) as Button
//        val btnout = view.findViewById<View>(R.id.btn_out) as Button

        binding.btnOut.setOnClickListener {
            dismiss() // dialog 닫는 함수
        }

        binding.btnCancel.setOnClickListener {
            dismiss()
        }
        return view



    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}


