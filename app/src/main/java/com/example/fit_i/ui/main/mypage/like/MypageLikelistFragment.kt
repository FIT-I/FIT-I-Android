package com.example.fit_i.ui.main.mypage

import android.os.Bundle

import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fit_i.ui.main.mypage.like.LikelistAdapter
import com.example.fit_i.ui.main.mypage.like.LikelistData
import com.example.fit_i.R
import com.example.fit_i.RetrofitImpl
import com.example.fit_i.data.model.response.WishResponse
import com.example.fit_i.data.service.CustomerService
import com.example.fit_i.databinding.FragmentMypageLikelistBinding
import com.example.fit_i.databinding.FragmentMypageNoticeBinding
import com.example.fit_i.ui.main.home.HomeFragment
import com.example.fit_i.ui.main.mypage.notice.NoticeAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MypageLikelistFragment : Fragment() {
    private var _binding: FragmentMypageLikelistBinding? = null
    private val binding: FragmentMypageLikelistBinding
        get() = requireNotNull(_binding) { "FragmentMypageLikelistBinding" }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMypageLikelistBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lodeData()

        val ibpre = view.findViewById<View>(R.id.ib_pre4) as ImageButton

        ibpre.setOnClickListener{
            val mypageFragment = MypageFragment()
            val transaction : FragmentTransaction = requireFragmentManager().beginTransaction()

            transaction.replace(R.id.fl_container,mypageFragment)
            transaction.commit()
        }
    }
    //API 연결부분
    private fun setAdapter(likeList : List<WishResponse.Result>){

        val likelistAdapter = LikelistAdapter(likeList)
        binding.rvLikelist.adapter=likelistAdapter

        val linearLayoutManager = LinearLayoutManager(context)
        binding.rvLikelist.layoutManager=linearLayoutManager

        binding.rvLikelist.setHasFixedSize(true)  //true?
        binding.rvLikelist.addItemDecoration(DividerItemDecoration(context, LinearLayout.VERTICAL))
    }

    private fun lodeData() {
        val customerService = RetrofitImpl.getApiClient().create(CustomerService::class.java)
        customerService.getWishlist().enqueue(object: Callback<WishResponse>{
            override fun onResponse(
                call : Call<WishResponse>,
                response: Response<WishResponse>
            ){
                if(response.isSuccessful){
                    //정상적으로 통신이 성공된 경우
                    Log.d("post","onResponse 성공"+response.body().toString());

                    val body = response.body()
                    body?.let { setAdapter(it.result) }

                }else{
                    //통신 실패
                    Log.d("post","onResponse 실패")
                }
            }
            override fun onFailure(call: Call<WishResponse>,t: Throwable){
                //통신 실패
                Log.d("get","onFailure 에러"+t.message.toString());
            }
        })
    }
}
