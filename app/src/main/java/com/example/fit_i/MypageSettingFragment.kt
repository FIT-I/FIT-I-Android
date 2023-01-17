package com.example.fit_i

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Dialog
import android.os.Bundle
import android.os.ProxyFileDescriptorCallback
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MypageSettingFragment :Fragment() {
    private lateinit var binding: MypageSettingFragment


    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val ee = inflater.inflate(R.layout.fragment_mypage_setting, container, false)
        val btnlogout = ee.findViewById<View>(R.id.btn_logout) as AppCompatButton
        val btnwithdraw = ee.findViewById<View>(R.id.btn_withdraw) as AppCompatButton

        btnlogout.setOnClickListener {
            showProfileDialog()
        }
        btnwithdraw.setOnClickListener {
            val mypageSiginoutFragment = MypageSiginoutFragment()
            val transaction : FragmentTransaction = requireFragmentManager().beginTransaction()

            transaction.replace(R.id.fl_container,mypageSiginoutFragment)
            transaction.commit()
        }

        return ee


}

    private fun showProfileDialog() {
        ProfileDialog(requireContext()){

        }.show()
    }

}

