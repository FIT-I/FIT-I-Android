package com.example.fit_i.ui.main.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fit_i.ui.main.home.BottomSheetFragment
import com.example.fit_i.RetrofitImpl
import com.example.fit_i.data.model.response.GetTrainerListResponse
import com.example.fit_i.data.service.CustomerService
import com.example.fit_i.databinding.FragmentHomePtBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomePtFragment : Fragment() {
    private var _binding: FragmentHomePtBinding? = null
    private val binding: FragmentHomePtBinding
        get() = requireNotNull(_binding) { "FragmentHomePtBinding" }

    var sort = arrayOf("recent")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomePtBinding.inflate(inflater, container, false)
        return binding.root
    }
    //서버 연결 전 버전
//    전   val trainerList : ArrayList<TrainerData> = arrayListOf()
//
//        trainerList.apply {
//            add(TrainerData("김동현","서울대학교","Pt 센터 경력 3년. 스포애니 상도점에서 대표 트레이너로 근무한 경험이 있습니다."
//                ,"20,000","128","1"))
//            add(TrainerData("김동현","서울대학교","Pt 센터 경력 3년. 스포애니 상도점에서 대표 트레이너로 근무한 경험이 있습니다."
//                ,"20,000","128","1"))
//            add(TrainerData("김동현","서울대학교","Pt 센터 경력 3년. 스포애니 상도점에서 대표 트레이너로 근무한 경험이 있습니다."
//                ,"20,000","128","1"))
//            add(TrainerData("김동현","서울대학교","Pt 센터 경력 3년. 스포애니 상도점에서 대표 트레이너로 근무한 경험이 있습니다."
//                ,"20,000","128","1"))
//            add(TrainerData("김동현","서울대학교","Pt 센터 경력 3년. 스포애니 상도점에서 대표 트레이너로 근무한 경험이 있습니다."
//                ,"20,000","128","1"))
//        }
//        return binding.root
//    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lodeData(sort)


/*
        binding.tvSort.text = "실시간 순"
        binding.llSort.setOnClickListener(){
            val bottomSheet = BottomSheetFragment {
                when (it){
                    0 -> {
                        binding.tvSort.text = "실시간 순"
                        //sort = arrayOf("recent")
                        lodeData(arrayOf("recent"))
                    }
                    1 -> {
                        binding.tvSort.text = "트레이너 레벨 순"
                        //sort = arrayOf("level")
                        lodeData(arrayOf("level"))
                    }
                    2 -> {
                        binding.tvSort.text = "가격 낮은 순"
                        //sort = arrayOf("recent","DESC")
                        lodeData(arrayOf("recent","DESC"))
                    }
                    3 -> {
                        binding.tvSort.text = "가격 높은 순"
                        //sort = arrayOf("recent","ASC")
                        lodeData(arrayOf("recent","ASC"))
                    }
                }
            }
            activity?.let { it1 -> bottomSheet.show(it1.supportFragmentManager,bottomSheet.tag) }
        } //일단은 텍스트 변경만. 실제 sorting 코드도 짜야함*/
    }

    private fun setAdapter(trainerList: List<GetTrainerListResponse.Result.Dto>){
        val trainerAdapter = TrainerAdapter(trainerList)
        binding.rvTrainer.adapter=trainerAdapter

        val linearLayoutManager = LinearLayoutManager(context)
        binding.rvTrainer.layoutManager=linearLayoutManager

        binding.rvTrainer.setHasFixedSize(true)
        binding.rvTrainer.addItemDecoration(DividerItemDecoration(context, LinearLayout.VERTICAL))
    }


    private fun lodeData(sort: Array<String>) {

        val customerService = RetrofitImpl.getApiClient().create(CustomerService::class.java)
        customerService.getTrainerlist("pt",0,500,sort).enqueue(object :
            Callback<GetTrainerListResponse> {
            override fun onResponse(call: Call<GetTrainerListResponse>, response: Response<GetTrainerListResponse>) {
                if(response.isSuccessful){
                    // 정상적으로 통신이 성공된 경우
                    Log.d("post", "onResponse 성공: " + response.body().toString());
                    //Toast.makeText(this@ProfileActivity, "비밀번호 찾기 성공!", Toast.LENGTH_SHORT).show()

                    val body = response.body()
                    body?.let {
                        setAdapter(it.result.dto)
                    }
                }else{
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