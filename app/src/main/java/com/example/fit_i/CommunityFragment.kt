package com.example.fit_i

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentTransaction
import com.example.fit_i.databinding.FragmentChatBinding
import com.example.fit_i.databinding.FragmentCommunityBinding



class CommunityFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)


        //나중에 버튼 연결할때 사용할 코드

//        val view = inflater.inflate(R.layout.fragment_community, container, false)
//        val btsent = view.findViewById<View>(R.id.bt_sent) as Button
//
//        btsent.setOnClickListener {
//            val homeFragment = HomeFragment()
//            val transaction:FragmentTransaction = requireFragmentManager().beginTransaction()
//
//            transaction.replace(R.id.fl_container,homeFragment)
//            transaction.commit()
//
//
//        }
//        return view


    }
}












