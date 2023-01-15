package com.example.fit_i

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MypageFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_mypage, container, false)

        val vv = inflater.inflate(R.layout.fragment_mypage, container, false)
        val ibsetting = vv.findViewById<View>(R.id.ib_setting) as ImageButton
        val ivnextlike = vv.findViewById<View>(R.id.iv_next_like) as ImageView

        ibsetting.setOnClickListener {
            val mypageSettingFragment = MypageSettingFragment()
            val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()

            transaction.replace(R.id.fl_container, mypageSettingFragment)
            transaction.commit()
        }

        ivnextlike.setOnClickListener {
            val mypageLikelistFragment = MypageLikelistFragment()
            val transaction : FragmentTransaction = requireFragmentManager().beginTransaction()

            transaction.replace(R.id.fl_container, mypageLikelistFragment)
            transaction.commit()
        }


        return vv


    }
}