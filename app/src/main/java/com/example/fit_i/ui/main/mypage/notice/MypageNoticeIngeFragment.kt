package com.example.fit_i.ui.main.mypage.notice

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.FragmentTransaction
import com.example.fit_i.R
import com.example.fit_i.RetrofitImpl
import com.example.fit_i.data.model.response.GetMypageResponse
import com.example.fit_i.data.model.response.GetTrainerListResponse
import com.example.fit_i.data.service.CommunalService
import com.example.fit_i.databinding.FragmentMypageBinding
import com.example.fit_i.databinding.FragmentMypageNoticeBinding
import com.example.fit_i.ui.main.mypage.MypageFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MypageNoticeIngeFragment : Fragment() {
    private var _binding: FragmentMypageNoticeBinding? = null
    private val binding: FragmentMypageNoticeBinding
        get() = requireNotNull(_binding) { "FragmentMypageNoticeBinding" }





    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMypageNoticeBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val ibpre = view.findViewById<View>(R.id.ib_pre7) as ImageButton

        fun onBind(data: List<GetTrainerListResponse.Result.Dto>){

        }
//
//
//        val commmunalService = RetrofitImpl.getApiClient().create(CommunalService::class.java)
//        commmunalService.getAnnouncement().enqueue(object :
//            Callback<GetMypageResponse> {
//            override fun onResponse(call: Call<GetMypageResponse>, response: Response<GetMypageResponse>) {
//                if(response.isSuccessful){
//                    // 정상적으로 통신이 성공된 경우
//                    onBind(response.body()!!.result)
//                    Log.d("post", "onResponse 성공: " + response.body().toString());
//                    //Toast.makeText(this@ProfileActivity, "비밀번호 찾기 성공!", Toast.LENGTH_SHORT).show()
//
//                }else{
//                    // 통신이 실패한 경우(응답코드 3xx, 4xx 등)
//                    Log.d("post", "onResponse 실패")
//                }
//            }
//
//            override fun onFailure(call: Call<GetMypageResponse>, t: Throwable) {
//                // 통신 실패 (인터넷 끊킴, 예외 발생 등 시스템적인 이유)
//                Log.d("post", "onFailure 에러: " + t.message.toString());
//            }
//        })
//

//
//
//        ibpre.setOnClickListener{
//            val mypageFragment = MypageFragment()
//            val transaction : FragmentTransaction = requireFragmentManager().beginTransaction()
//
//            //이전 화면으로 이동
//            transaction.replace(R.id.fl_container,mypageFragment)
//            transaction.commit()
//
//        }


    }

}
