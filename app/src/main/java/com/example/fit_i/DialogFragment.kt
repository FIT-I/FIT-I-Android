package com.example.fit_i

import android.app.AlertDialog
import android.widget.Button

const val EXTRA_NOTICE_SAVE = "EXTRA_NOTICE_SAVE"
const val TAG_DIALOG_EVENT = "TAG_DIALOG_EVENT"


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import com.example.fit_i.databinding.FragmentChatBinding.inflate


class DialogFragment : androidx.fragment.app.DialogFragment() {



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_dialog,container, false)
        val btncancel = view.findViewById<View>(R.id.btn_cancel) as Button
        val btnout = view.findViewById<View>(R.id.btn_out) as Button

        btncancel.setOnClickListener {
            dismiss()
        }
        btnout.setOnClickListener {

        }





    }



}


