package com.example.fit_i.ui.main.mypage.review

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fit_i.R
import com.example.fit_i.RetrofitImpl
import com.example.fit_i.data.model.response.GetMCResponse
import com.example.fit_i.data.service.MatchingService
import com.example.fit_i.databinding.FragmentMypageReviewBinding
import com.example.fit_i.ui.main.mypage.MypageFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MypageReviewFragment : Fragment() {
    private var _binding: FragmentMypageReviewBinding? = null
    private val binding: FragmentMypageReviewBinding
        get() = requireNotNull(_binding) { "FragmentMypageReviewBinding" }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMypageReviewBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lodeData()
    }

    private fun setAdapter(reviewList: List<GetMCResponse.Result>) {

        val reviewAdapter = ReviewAdapter(reviewList)
        binding.rvReview.adapter = reviewAdapter

        val linearLayoutManager = LinearLayoutManager(context)
        binding.rvReview.layoutManager = linearLayoutManager

        binding.rvReview.setHasFixedSize(true)  //true?
        binding.rvReview.addItemDecoration(
            DividerItemDecoration(
                context,
                LinearLayout.VERTICAL
            )
        )
    }

    private fun lodeData() {
        val matchingService = RetrofitImpl.getApiClient().create(MatchingService::class.java)
        matchingService.matchingCustomer().enqueue(object :
            Callback<GetMCResponse> {
            override fun onResponse(
                call: Call<GetMCResponse>,
                response: Response<GetMCResponse>
            ) {
                if (response.isSuccessful) {
                    // 정상적으로 통신이 성공된 경우
                    //onBind(response.body()!!.result)
                    Log.d("post", "onResponse 성공: " + response.body().toString());
                    //Toast.makeText(this@ProfileActivity, "비밀번호 찾기 성공!", Toast.LENGTH_SHORT).show()
                    if(response.body()?.result?.size==0){
                        binding.clMatchingNo.visibility=View.VISIBLE
                    }
                    else
                        binding.clMatchingNo.visibility=View.INVISIBLE

                    val body = response.body()
                    body?.let {
                        setAdapter(it.result)
                    }
                } else {
                    // 통신이 실패한 경우(응답코드 3xx, 4xx 등)
                    Log.d("post", "onResponse 실패")
                }
            }

            override fun onFailure(call: Call<GetMCResponse>, t: Throwable) {
                // 통신 실패 (인터넷 끊킴, 예외 발생 등 시스템적인 이유)
                Log.d("post", "onFailure 에러: " + t.message.toString());
            }
        })
    }
}
