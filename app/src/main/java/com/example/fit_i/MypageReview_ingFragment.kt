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
import com.example.fit_i.databinding.FragmentMypageReviewBinding
import com.example.fit_i.databinding.FragmentMypageReviewIngBinding


class MypageReview : Fragment() {
    private lateinit var binding: FragmentMypageReviewIngBinding
    var review : String = ""


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding = FragmentMypageReviewIngBinding.inflate(inflater,container,false)
        val view = inflater.inflate(R.layout.fragment_mypage_review_ing,container,false)
        val etreview = view.findViewById<View>(R.id.et_review) as EditText
        val btnreviewing = view.findViewById<View>(R.id.btn_review_ing) as Button

        btnreviewing.isEnabled = false



        etreview.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

//값 변경시 실행되는 함수
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                 review = etreview.text.toString()

                if (review.isNotEmpty())
                    etreview.setBackgroundResource(R.drawable.edittext_true)
                else
                    etreview.setBackgroundResource(R.drawable.edittext_false)

                btnreviewing.isEnabled = true


            }
            override fun afterTextChanged(p0: Editable?) {}



        })

        return view


    }

}

