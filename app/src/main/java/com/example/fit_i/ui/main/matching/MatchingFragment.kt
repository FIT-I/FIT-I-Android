package com.example.fit_i.ui.main.matching

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fit_i.RetrofitImpl
import com.example.fit_i.data.model.response.GetMCResponse
import com.example.fit_i.data.service.MatchingService
import com.example.fit_i.databinding.FragmentMatchingBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MatchingFragment : Fragment() {
    private var _binding: FragmentMatchingBinding? = null
    private val binding: FragmentMatchingBinding
        get() = requireNotNull(_binding) {"FragmentMatchingBinding"}


//    private val dataList = ArrayList<MatchingData>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMatchingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()
    }

    private fun setAdapter(matchingList: List<GetMCResponse.Result>){
        val matchingAdapter = MatchingAdapter(matchingList)
        binding.rcMatch.adapter = matchingAdapter
        val linearLayoutManager = LinearLayoutManager(context)
        binding.rcMatch.layoutManager=linearLayoutManager
        binding.rcMatch.setHasFixedSize(true)

        // 구분선 ?? binding.rcMatch.addItemDecoration(DividerItemDecoration(context,LinearLayoutManager.VERTICAL))

    }
    private fun loadData(){
        val matchingService = RetrofitImpl.getApiClient().create(MatchingService::class.java)
        matchingService.matchingCustomer().enqueue(object :
            Callback<GetMCResponse> {
            override fun onResponse(call: Call<GetMCResponse>, response: Response<GetMCResponse>) {
                if (response.isSuccessful) {
                    //통신 성공!!
                    Log.d("post", "매칭 onResponse 성공" + response.body().toString())
                    val body = response.body()
                    body?.let {
                        setAdapter(it.result)
                    }
                }else{
                    //통신 실패...
                    Log.d("post","매칭 onResponse 실패")
                }
            }

            override fun onFailure(call: Call<GetMCResponse>, t: Throwable) {
                //통신 실패... (인터넷 끊김, 시스템적인 이유)
                Log.d("post","매칭 onFailure 에러"+t.message.toString())
            }
        })
    }


}
