package com.example.fit_i

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageButton
import androidx.core.view.children
import androidx.fragment.app.FragmentTransaction
import com.example.fit_i.databinding.FragmentMypageModifyProfileBinding


class MypageModifyProfileFragment : Fragment(), View.OnClickListener {
    private lateinit var binding: FragmentMypageModifyProfileBinding
    val btnpf1 = view?.findViewById<View>(R.id.btn_pf1) as CheckBox
    val btnpf2 = view?.findViewById<View>(R.id.btn_pf2) as CheckBox
    val btnpf3 = view?.findViewById<View>(R.id.btn_pf3) as CheckBox
    val btnpf4 = view?.findViewById<View>(R.id.btn_pf4) as CheckBox
    val btnpf5 = view?.findViewById<View>(R.id.btn_pf5) as CheckBox
    val btnpf6 = view?.findViewById<View>(R.id.btn_pf6) as CheckBox
    var bCheck = true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_mypage_modify_profile, container, false)
        val ibpre = view.findViewById<View>(R.id.ib_pre) as ImageButton

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnClickListener()
    }

    private fun setOnClickListener() {
        val btnSequence = binding.container.children
        btnSequence.forEach { btn ->
            btn.setOnClickListener(this)
        }

    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_pf1 ->
                if (btnpf1.isChecked) {
                    btnpf2.isChecked = false
                    btnpf3.isChecked = false
                    btnpf4.isChecked = false
                    btnpf5.isChecked = false
                    btnpf6.isChecked = false
                }
            R.id.btn_pf2 ->
                if (btnpf2.isChecked) {
                    btnpf1.isChecked = false
                    btnpf3.isChecked = false
                    btnpf4.isChecked = false
                    btnpf5.isChecked = false
                    btnpf6.isChecked = false
                }
            R.id.btn_pf3 ->
                if (btnpf3.isChecked) {
                    btnpf1.isChecked = false
                    btnpf2.isChecked = false
                    btnpf4.isChecked = false
                    btnpf5.isChecked = false
                    btnpf6.isChecked = false
                }
            R.id.btn_pf4 ->
                if (btnpf4.isChecked) {
                    btnpf1.isChecked = false
                    btnpf2.isChecked = false
                    btnpf3.isChecked = false
                    btnpf5.isChecked = false
                    btnpf6.isChecked = false

                }
            R.id.btn_pf5 ->
                if (btnpf5.isChecked) {
                    btnpf1.isChecked = false
                    btnpf2.isChecked = false
                    btnpf3.isChecked = false
                    btnpf4.isChecked = false
                    btnpf6.isChecked = false

                }

            R.id.btn_pf6 ->
                if (btnpf6.isChecked) {
                    btnpf1.isChecked = false
                    btnpf2.isChecked = false
                    btnpf3.isChecked = false
                    btnpf4.isChecked = false
                    btnpf5.isChecked = false
                }
        }
    }


}
