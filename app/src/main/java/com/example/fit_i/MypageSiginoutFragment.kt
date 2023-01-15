package com.example.fit_i

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import androidx.fragment.app.FragmentTransaction

class MypageSiginoutFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


    val bb = inflater.inflate(R.layout.fragment_mypage_siginout, container, false)
    val btnstay = bb.findViewById<View>(R.id.btn_stay) as ImageButton
    val btnwithdraw = bb.findViewById<View>(R.id.btn_withdrow) as ImageView

        btnstay.setOnClickListener{
            val mypageFragment = MypageFragment()
            val transaction : FragmentTransaction = requireFragmentManager().beginTransaction()

            transaction.replace(R.id.fl_container,mypageFragment)
            transaction.commit()

        }



//    btnwithdraw.setOnClickListener {
//        val mypageLikelistFragment = MypageLikelistFragment()
//        val transaction : FragmentTransaction = requireFragmentManager().beginTransaction()
//
//        transaction.replace(R.id.fl_container, mypageLikelistFragment)
//        transaction.commit()
//    }


    return bb


}
}