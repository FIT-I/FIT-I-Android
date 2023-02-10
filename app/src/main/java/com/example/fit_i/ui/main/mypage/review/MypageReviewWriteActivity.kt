package com.example.fit_i.ui.main.mypage.review

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.*
import com.example.fit_i.R
import com.example.fit_i.RetrofitImpl
import com.example.fit_i.data.model.request.ReviewRequest
import com.example.fit_i.data.model.response.BaseResponse
import com.example.fit_i.data.service.CustomerService
import com.example.fit_i.databinding.ActivityMypageReviewWriteBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MypageReviewWriteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMypageReviewWriteBinding

    var grade: Int = 0
    var contents : String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMypageReviewWriteBinding.inflate(layoutInflater)

        setContentView(binding.root)
        val id = intent.getLongExtra("reviewIdx",-1)


        val etreview = findViewById<View>(R.id.et_review) as EditText
        val btnreviewing = findViewById<View>(R.id.btn_review_ing) as Button
        val ibpre = findViewById<View>(R.id.ib_pre6) as ImageButton
        val rating = findViewById<View>(R.id.bar_grade) as RatingBar
        contents = etreview.text.toString()
        grade = rating.numStars
        btnreviewing.isEnabled = false

        etreview.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            //값 변경시 실행되는 함수
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                if (contents.isNotEmpty())
                    btnreviewing.setBackgroundResource(R.drawable.edittext_border)
                else
                    btnreviewing.setBackgroundResource(R.drawable.edittext_border_not)

                btnreviewing.isEnabled = true

            }
            override fun afterTextChanged(p0: Editable?) {}
        })

        val customerService = RetrofitImpl.getApiClient().create(CustomerService::class.java)
        btnreviewing.setOnClickListener {
            customerService.writeReview(req = ReviewRequest(id,grade,contents)).enqueue(object :
                Callback<BaseResponse> {
                override fun onResponse(
                    call: Call<BaseResponse>,
                    response: Response<BaseResponse>
                ) {
                    if (response.isSuccessful) {
                        // 정상적으로 통신이 성공된 경우
                        //val result: User? = response.body()
                        Log.d("post", "onResponse 성공: " + response.body().toString());
                        Toast.makeText(this@MypageReviewWriteActivity, "리뷰작성", Toast.LENGTH_SHORT).show()
                    } else {
                        // 통신이 실패한 경우(응답코드 3xx, 4xx 등)
                        Log.d("post", "onResponse 실패")
                    }
                }

                override fun onFailure(call: Call<BaseResponse>, t: Throwable) {
                    // 통신 실패 (인터넷 끊킴, 예외 발생 등 시스템적인 이유)
                    Log.d("post", "onFailure 에러: " + t.message.toString());
                }
            })
        }
    }
}