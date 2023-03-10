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
                    // ??????????????? ????????? ????????? ??????
                    //onBind(response.body()!!.result)
                    Log.d("post", "onResponse ??????: " + response.body().toString());
                    //Toast.makeText(this@ProfileActivity, "???????????? ?????? ??????!", Toast.LENGTH_SHORT).show()

                    val body = response.body()
                    body?.let {
                        setAdapter(it.result)
                    }
                }else{
                    // ????????? ????????? ??????(???????????? 3xx, 4xx ???)
                    Log.d("post", "onResponse ??????")
                }
            }

            override fun onFailure(call: Call<GetAnnouncementResponse>, t: Throwable) {
                // ?????? ?????? (????????? ??????, ?????? ?????? ??? ??????????????? ??????)
                Log.d("post", "onFailure ??????: " + t.message.toString());
            }
        })
    }

}