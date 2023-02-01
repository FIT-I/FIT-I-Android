package com.example.fit_i.ui.main.mypage

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
import com.example.fit_i.R
import com.example.fit_i.RetrofitImpl
import com.example.fit_i.data.model.request.ReviewRequest
import com.example.fit_i.data.model.response.BaseResponse
import com.example.fit_i.data.service.CustomerService
import retrofit2.Callback
import retrofit2.Retrofit

//import com.example.fit_i.RetrofitImpl.service


class MypageReviewIngFragment : Fragment() {
    var trainerIdx : String = ""
    var grade : String = ""
    var contents : String = ""


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        val view = inflater.inflate(R.layout.fragment_mypage_review_ing,container,false)
        val etreview = view.findViewById<View>(R.id.et_review) as EditText
        val btnreviewing = view.findViewById<View>(R.id.btn_review_ing) as Button
        val ibpre = view.findViewById<View>(R.id.ib_pre6) as ImageButton
        contents = etreview.text.toString()

        btnreviewing.isEnabled = false

        ibpre.setOnClickListener{
            val mypageFragment = MypageFragment()
            val transaction : FragmentTransaction = requireFragmentManager().beginTransaction()

            transaction.replace(R.id.fl_container,mypageFragment)
            transaction.commit()
        }


            etreview.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

//값 변경시 실행되는 함수
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {


                if (contents.isNotEmpty())
                    btnreviewing.setBackgroundResource(R.drawable.edittext_false)
                else
                    btnreviewing.setBackgroundResource(R.drawable.edittext_true)

                btnreviewing.isEnabled = true


            }
            override fun afterTextChanged(p0: Editable?) {}



        })
        val service = RetrofitImpl.getApiClient().create(CustomerService::class.java)
//       btnreviewing.setOnClickListener{
//           service.UserReview(review = etreview.toString() )
//        }
//        btnreviewing.setOnClickListener{
//            service.writeReview(ReviewRequest).enqueue(object : Callback<BaseResponse>{
//
//            })
//        }
        return view


    }


}

