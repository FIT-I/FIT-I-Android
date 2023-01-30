package com.example.fit_i.ui.mypage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageButton
import androidx.core.view.children
import androidx.fragment.app.FragmentTransaction
import com.example.fit_i.R
import com.example.fit_i.databinding.FragmentMypageModifyProfileBinding


class MypageModifyProfileFragment : Fragment() {
    private lateinit var binding: FragmentMypageModifyProfileBinding
    lateinit var  btnpf1 : CheckBox
    lateinit var btnpf2 : CheckBox
    lateinit var btnpf3 : CheckBox
    lateinit var btnpf4 :CheckBox
    lateinit var btnpf5 : CheckBox
    lateinit var btnpf6 :CheckBox



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_mypage_modify_profile, container, false)
        val ibpre = view.findViewById<View>(R.id.ib_pre) as ImageButton
        btnpf1 = view.findViewById(R.id.btn_pf1)
        btnpf2 = view.findViewById(R.id.btn_pf2)
        btnpf3 = view.findViewById(R.id.btn_pf3)
        btnpf4 = view.findViewById(R.id.btn_pf4)
        btnpf5 = view.findViewById(R.id.btn_pf5)
        btnpf6 = view.findViewById(R.id.btn_pf6)

        //이전
        ibpre.setOnClickListener {
            val mypageFragment = MypageFragment()
            val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()

            //이전 화면으로 이동
            transaction.replace(R.id.fl_container, mypageFragment)
            transaction.commit()
        }
        return view
    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        changeOnClickListener()
//    }
//
//    private fun changeOnClickListener() {
//        val btnSequence = binding.container.children
//        btnSequence.forEach { btn ->
//            btn.setOnClickListener(this)
//        }
//
//    }
//
//    override fun onClick(v: View) {
//        when (v.id) {
//            R.id.btn_pf1 ->
//                if (btnpf1.isChecked) {
//                    btnpf2!!.isChecked = false
//                    btnpf3!!.isChecked = false
//                    btnpf4!!.isChecked = false
//                    btnpf5!!.isChecked = false
//                    btnpf6!!.isChecked = false
//                }
//            R.id.btn_pf2 ->
//                if (btnpf2!!.isChecked) {
//                    btnpf1!!.isChecked = false
//                    btnpf3!!.isChecked = false
//                    btnpf4!!.isChecked = false
//                    btnpf5!!.isChecked = false
//                    btnpf6!!.isChecked = false
//                }
//            R.id.btn_pf3 ->
//                if (btnpf3!!.isChecked) {
//                    btnpf1!!.isChecked = false
//                    btnpf2!!.isChecked = false
//                    btnpf4!!.isChecked = false
//                    btnpf5!!.isChecked = false
//                    btnpf6!!.isChecked = false
//                }
//            R.id.btn_pf4 ->
//                if (btnpf4!!.isChecked) {
//                    btnpf1!!.isChecked = false
//                    btnpf2!!.isChecked = false
//                    btnpf3!!.isChecked = false
//                    btnpf5!!.isChecked = false
//                    btnpf6!!.isChecked = false
//
//                }
//            R.id.btn_pf5 ->
//                if (btnpf5!!.isChecked) {
//                    btnpf1!!.isChecked = false
//                    btnpf2!!.isChecked = false
//                    btnpf3!!.isChecked = false
//                    btnpf4!!.isChecked = false
//                    btnpf6!!.isChecked = false
//
//                }
//
//            R.id.btn_pf6 ->
//                if (btnpf6!!.isChecked) {
//                    btnpf1!!.isChecked = false
//                    btnpf2!!.isChecked = false
//                    btnpf3!!.isChecked = false
//                    btnpf4!!.isChecked = false
//                    btnpf5!!.isChecked = false
//                }
//        }
//    }


}
