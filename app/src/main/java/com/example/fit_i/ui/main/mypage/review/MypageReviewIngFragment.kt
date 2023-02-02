package com.example.fit_i.ui.main.mypage

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import android.widget.ImageButton
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import com.example.fit_i.R
import com.example.fit_i.RetrofitImpl
import com.example.fit_i.data.model.request.ReviewRequest
import com.example.fit_i.data.model.response.BaseResponse
import com.example.fit_i.data.service.CustomerService
import retrofit2.Callback
import retrofit2.Retrofit
import com.example.fit_i.ui.main.mypage.MypageFragment
import com.willy.ratingbar.BaseRatingBar
import retrofit2.Call
import retrofit2.Response

//import com.example.fit_i.RetrofitImpl.service


class MypageReviewIngFragment : Fragment() {

    //var trainerIdx : String = ""
    private var trainerIdx : Int =2
    var grade: Int = 0
    var contents : String = ""


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        val view = inflater.inflate(R.layout.fragment_mypage_review_ing,container,false)
        val etreview = view.findViewById<View>(R.id.et_review) as EditText
        val btnreviewing = view.findViewById<View>(R.id.btn_review_ing) as Button
        val ibpre = view.findViewById<View>(R.id.ib_pre6) as ImageButton
        val rating = view.findViewById<View>(R.id.bar_grade) as RatingBar
        contents = etreview.text.toString()
        grade = rating.getNumStars()
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

        val customerService = RetrofitImpl.getApiClient().create(CustomerService::class.java)
        btnreviewing.setOnClickListener {
            customerService.writeReview(req = ReviewRequest(trainerIdx,grade,contents)).enqueue(object : Callback<BaseResponse> {
                override fun onResponse(
                    call: Call<BaseResponse>,
                    response: Response<BaseResponse>
                ) {
                    if (response.isSuccessful) {
                        // 정상적으로 통신이 성공된 경우
                        //val result: User? = response.body()
                        Log.d("post", "onResponse 성공: " + response.body().toString());
                        Toast.makeText(context, "리뷰작성", Toast.LENGTH_SHORT)
                            .show()
                        //Log.d("post","result: "+response.)
                        //Log.d("post", "onResponse 성공: " + result.toString());
                    } else {
                        // 통신이 실패한 경우(응답코드 3xx, 4xx 등)
                        Log.d("post", "onResponse 실패")
                    }
                }

                override fun onFailure(call: Call<BaseResponse>, t: Throwable) {
                    // 통신 실패 (인터넷 끊킴, 예외 발생 등 시스템적인 이유)
                    Log.d("post", "onFailure 에러: " + t.message.toString());
                }
            }       )

        }
//     btnreviewing.setOnClickListener{
//         ReviewService.UserReview(review = etreview.toString() )
//     }
//        btnreviewing.setOnClickListener{
//            service.writeReview(ReviewRequest).enqueue(object : Callback<BaseResponse>{
//
//            })
//        }
         return view
     }


    }




