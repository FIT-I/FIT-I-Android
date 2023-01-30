package com.example.fit_i.ui.mypage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.FragmentTransaction
import com.example.fit_i.R

class MypageFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_mypage, container, false)

        val vv = inflater.inflate(R.layout.fragment_mypage, container, false)
        val ibsetting = vv.findViewById<View>(R.id.ib_setting) as ImageButton

        ibsetting.setOnClickListener{
            val mypageSettingFragment = MypageSettingFragment()
            val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()

            transaction.replace(R.id.fl_container,mypageSettingFragment)
            transaction.commit()
        }

        return vv


    }
}