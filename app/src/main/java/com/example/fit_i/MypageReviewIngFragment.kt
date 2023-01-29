package com.example.fit_i

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.fragment.app.FragmentTransaction


class MypageReviewIngFragment : Fragment() {
    var review : String = ""


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        val view = inflater.inflate(R.layout.fragment_mypage_review_ing,container,false)
        val etreview = view.findViewById<View>(R.id.et_review) as EditText
        val btnreviewing = view.findViewById<View>(R.id.btn_review_ing) as Button
        val ibpre = view.findViewById<View>(R.id.ib_pre6) as ImageButton

        ibpre.setOnClickListener{
            val mypageFragment = MypageFragment()
            val transaction : FragmentTransaction = requireFragmentManager().beginTransaction()

            transaction.replace(R.id.fl_container,mypageFragment)
            transaction.commit()
        }

        btnreviewing.isEnabled = false

            etreview.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

//값 변경시 실행되는 함수
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                 review = etreview.text.toString()

                if (review.isNotEmpty())
                    btnreviewing.setBackgroundResource(R.drawable.edittext_false)
                else
                    btnreviewing.setBackgroundResource(R.drawable.edittext_true)

                btnreviewing.isEnabled = true


            }
            override fun afterTextChanged(p0: Editable?) {}



        })

        return view


    }

}

