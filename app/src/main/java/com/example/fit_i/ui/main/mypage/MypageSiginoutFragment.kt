package com.example.fit_i.ui.main.mypage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.FragmentTransaction
import com.example.fit_i.AccountDialog
import com.example.fit_i.R

class MypageSiginoutFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val view = inflater.inflate(R.layout.fragment_mypage_siginout, container, false)
        val btnstay = view.findViewById<View>(R.id.btn_stay) as AppCompatButton
        val btnwithdraw2 = view.findViewById<View>(R.id.btn_withdraw2) as AppCompatButton

        //계속 있기
        btnstay.setOnClickListener {
            val mypageFragment = MypageFragment()
            val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()

            transaction.replace(R.id.fl_container, mypageFragment)
            transaction.commit()

        }



        btnwithdraw2.setOnClickListener {
            showAccountDialog()
        }


        return view


    }

    private fun showAccountDialog() {
        AccountDialog(requireContext()) {
        }.show()
    }
}