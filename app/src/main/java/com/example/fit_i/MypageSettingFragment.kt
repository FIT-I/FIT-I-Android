package com.example.fit_i

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentTransaction

class MypageSettingFragment : Fragment() {





    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val ee = inflater.inflate(R.layout.fragment_mypage_setting,container,false)
        val btnlogout = ee.findViewById<View>(R.id.btn_logout) as Button

        btnlogout.setOnClickListener {
            val dialogFragment = DialogFragment()
            val transaction:FragmentTransaction = requireFragmentManager().beginTransaction()

            transaction.replace(R.id.fl_container,dialogFragment)
            transaction.commit()
        }
        return ee
    }

}