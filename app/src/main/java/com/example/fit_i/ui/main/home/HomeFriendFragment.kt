package com.example.fit_i.ui.main.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fit_i.BottomSheetFragment
import com.example.fit_i.R
import com.example.fit_i.RetrofitImpl
import com.example.fit_i.data.model.response.GetTrainerListResponse
import com.example.fit_i.data.service.CustomerService
import com.example.fit_i.databinding.FragmentHomeEatingBinding
import com.example.fit_i.databinding.FragmentHomeFriendBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFriendFragment : Fragment() {
    private var _binding: FragmentHomeFriendBinding? = null
    private val binding: FragmentHomeFriendBinding
        get() = requireNotNull(_binding) { "FragmentHomeFriendBinding" }

    var sort = arrayOf("recent")


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeFriendBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lodeData()

        val trainerList : ArrayList<TrainerData> = arrayListOf()


        binding.tvSort.text = "실시간 순"
        binding.llSort.setOnClickListener(){
            val bottomSheet = BottomSheetFragment{
                when (it){
                    0 -> {
                        binding.tvSort.text = "실시간 순"
                        sort = arrayOf("recent")
                        lodeData()
                    }
                    1 -> {
                        binding.tvSort.text = "트레이너 레벨 순"
                        sort = arrayOf("level")
                        lodeData()
                    }
                    2 -> {
                        binding.tvSort.text = "가격 낮은 순"
                        sort = arrayOf("recent","DESC")
                        lodeData()
                    }
                    3 -> {
                        binding.tvSort.text = "가격 높은 순"
                        sort = arrayOf("recent","ASC")
                        lodeData()
                    }
                }
            }
            activity?.let { it1 -> bottomSheet.show(it1.supportFragmentManager,bottomSheet.tag) }
        } //일단은 텍스트 변경만. 실제 sorting 코드도 짜야함
    }

    private fun setAdapter(trainerList: List<GetTrainerListResponse.Result.Dto>){

        val trainerAdapter = TrainerAdapter(trainerList)
        binding.rvTrainer.adapter=trainerAdapter

        val linearLayoutManager = LinearLayoutManager(context)
        binding.rvTrainer.layoutManager=linearLayoutManager

        binding.rvTrainer.setHasFixedSize(true)
        // 1. 정의되어 있는 구분선
        binding.rvTrainer.addItemDecoration(DividerItemDecoration(context, LinearLayout.VERTICAL))
    }


    private fun lodeData() {

        val customerService = RetrofitImpl.getApiClient().create(CustomerService::class.java)
        customerService.getTrainerlist("friend", 0, 20, sort).enqueue(object :
            Callback<GetTrainerListResponse> {
            override fun onResponse(
                call: Call<GetTrainerListResponse>,
                response: Response<GetTrainerListResponse>
            ) {
                if (response.isSuccessful) {
                    // 정상적으로 통신이 성공된 경우
                    Log.d("post", "onResponse 성공: " + response.body().toString());
                    //Toast.makeText(this@ProfileActivity, "비밀번호 찾기 성공!", Toast.LENGTH_SHORT).show()

                    val body = response.body()
                    body?.let {
                        setAdapter(it.result.dto)
                    }
                } else {
                    // 통신이 실패한 경우(응답코드 3xx, 4xx 등)
                    Log.d("post", "onResponse 실패")
                }
            }

            override fun onFailure(call: Call<GetTrainerListResponse>, t: Throwable) {
                // 통신 실패 (인터넷 끊킴, 예외 발생 등 시스템적인 이유)
                Log.d("post", "onFailure 에러: " + t.message.toString());
            }
        })
    }
}