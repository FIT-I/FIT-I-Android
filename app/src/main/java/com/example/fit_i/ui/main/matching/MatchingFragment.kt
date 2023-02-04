package com.example.fit_i.ui.main.matching

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fit_i.RetrofitImpl
import com.example.fit_i.data.model.response.GetMatchingResponse
import com.example.fit_i.data.service.MatchingService
import com.example.fit_i.databinding.FragmentMatchingBinding
import kotlinx.coroutines.flow.callbackFlow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response




class MatchingFragment : Fragment() {
    private lateinit var binding: FragmentMatchingBinding
    var data: GetMatchingResponse? = null
    private val dataList = ArrayList<GetMatchingResponse.Result>() // 변수 선언해줌

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMatchingBinding.inflate(inflater, container, false)
        loadData()

        val matchingAdapter = MatchingAdapter(dataList,context)
        binding.rcMatch.adapter = matchingAdapter
        var linearLayoutManager = LinearLayoutManager(context)
        binding.rcMatch.layoutManager = linearLayoutManager

        return binding.root
    }

    private fun loadData() {
        //기본
        val service = RetrofitImpl.getApiClient().create(MatchingService::class.java)
        service.getCustomerMatching().enqueue(object : Callback<GetMatchingResponse>{
            override fun onResponse(
                call: Call<GetMatchingResponse>,
                response: Response<GetMatchingResponse>
            ) {
                if (response.isSuccessful){
                    Log.d("onResponse Success",response.body().toString())
            }

        }

            override fun onFailure(call: Call<GetMatchingResponse>, t: Throwable) {
                Log.d("this is error", t.message.toString())
            }
        })

    }



}








