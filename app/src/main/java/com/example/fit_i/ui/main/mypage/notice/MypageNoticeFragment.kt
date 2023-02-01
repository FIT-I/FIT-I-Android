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
import com.example.fit_i.TrainerAdapter
import com.example.fit_i.TrainerData
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

        val noticeList : ArrayList<NoticeData> = arrayListOf()

        noticeList.apply {
            add(NoticeData("앱 업데이트 안내2",",","2023-02-01"))
        }


        val noticeAdapter = NoticeAdapter(noticeList)
        binding.rvNotice.adapter=noticeAdapter

        val linearLayoutManager = LinearLayoutManager(context)
        binding.rvNotice.layoutManager=linearLayoutManager

        binding.rvNotice.setHasFixedSize(true)
        //구분선
        binding.rvNotice.addItemDecoration(DividerItemDecoration(context, LinearLayout.VERTICAL))


        val ibpre = view.findViewById<View>(R.id.ib_pre) as ImageButton

        ibpre.setOnClickListener{
            val mypageFragment = MypageFragment()
            val transaction : FragmentTransaction = requireFragmentManager().beginTransaction()

            //이전 화면으로 이동
            transaction.replace(R.id.fl_container,mypageFragment)
            transaction.commit()

        }

//        val btnper = view.findViewById<View>(R.id.btn_per)
//        val btnok = view.findViewById<View>(R.id.btn_okok)
    //        btnper.setOnClickListener{
//            val mypageNoticeIngeFragment = MypageNoticeIngeFragment()
//            val transaction : FragmentTransaction = requireFragmentManager().beginTransaction()
//
//            transaction.replace(R.id.fl_container,mypageNoticeIngeFragment)
//            transaction.commit()
//        }
    }

}