package com.example.fit_i.ui.main.mypage.notice

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fit_i.R
import com.example.fit_i.RetrofitImpl
import com.example.fit_i.data.model.response.GetAnnouncementResponse
import com.example.fit_i.data.service.CommunalService
import com.example.fit_i.databinding.FragmentMypageNoticeBinding
import com.example.fit_i.ui.main.mypage.MypageFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MypageNoticeFragment : Fragment() {
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

        lodeData()

        val ibpre = view.findViewById<View>(R.id.ib_pre) as ImageButton

        ibpre.setOnClickListener{
            val mypageFragment = MypageFragment()
            val transaction : FragmentTransaction = requireFragmentManager().beginTransaction()

            //이전 화면으로 이동
            transaction.replace(R.id.fl_container,mypageFragment)
            transaction.commit()

        }
    }


    private fun setAdapter(noticeList: List<GetAnnouncementResponse.Result>){

        val noticeAdapter = NoticeAdapter(noticeList)
        binding.rvNotice.adapter=noticeAdapter

        val linearLayoutManager = LinearLayoutManager(context)
        binding.rvNotice.layoutManager=linearLayoutManager

        binding.rvNotice.setHasFixedSize(true)  //true?
        binding.rvNotice.addItemDecoration(DividerItemDecoration(context, LinearLayout.VERTICAL))
    }

    private fun lodeData() {
        val commmunalService = RetrofitImpl.getApiClient().create(CommunalService::class.java)
        commmunalService.getAnnouncement().enqueue(object :
            Callback<GetAnnouncementResponse> {
            override fun onResponse(call: Call<GetAnnouncementResponse>, response: Response<GetAnnouncementResponse>) {
                if(response.isSuccessful){
                    // 정상적으로 통신이 성공된 경우
                    //onBind(response.body()!!.result)
                    Log.d("post", "onResponse 성공: " + response.body().toString());
                    //Toast.makeText(this@ProfileActivity, "비밀번호 찾기 성공!", Toast.LENGTH_SHORT).show()

                    val body = response.body()
                    body?.let {
                        setAdapter(it.result)
                    }
                }else{
                    // 통신이 실패한 경우(응답코드 3xx, 4xx 등)
                    Log.d("post", "onResponse 실패")
                }
            }

            override fun onFailure(call: Call<GetAnnouncementResponse>, t: Throwable) {
                // 통신 실패 (인터넷 끊킴, 예외 발생 등 시스템적인 이유)
                Log.d("post", "onFailure 에러: " + t.message.toString());
            }
        })
    }

}