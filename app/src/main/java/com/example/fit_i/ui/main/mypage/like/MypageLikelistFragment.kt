package com.example.fit_i.ui.main.mypage

import android.os.Bundle

import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fit_i.LikelistAdapter
import com.example.fit_i.LikelistData
import com.example.fit_i.R
import com.example.fit_i.RetrofitImpl
import com.example.fit_i.data.model.response.WishResponse
import com.example.fit_i.data.service.CustomerService
import com.example.fit_i.databinding.FragmentMypageLikelistBinding
import com.example.fit_i.ui.main.home.HomeFragment
import com.example.fit_i.ui.main.mypage.MypageFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MypageLikelistFragment : Fragment() {
    private lateinit var binding: FragmentMypageLikelistBinding
    lateinit var listAdapter: LikelistAdapter
    //private val dataList = ArrayList<LikelistData>()
    var dataList = ArrayList<LikelistData>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMypageLikelistBinding.inflate(inflater,container, false)
        val view = inflater.inflate(R.layout.fragment_mypage_likelist,container,false)
        val ibpre = view.findViewById<View>(R.id.ib_pre4) as ImageButton

        ibpre.setOnClickListener{
            val mypageFragment = MypageFragment()
            val transaction : FragmentTransaction = requireFragmentManager().beginTransaction()
            transaction.replace(R.id.fl_container,mypageFragment)
            transaction.commit()
        }





        //임의로 데이터 넣어보기, 나중에 사진 글라이드 기능 추가
        dataList.apply {
            add(LikelistData("김동현","4.3","숭실대학교","어제"))
            add(LikelistData("김준기","4.3","중앙대학교","월요일"))
            add(LikelistData("홍준혁","4.3","건국대학교","2023.1.4"))
        }
        val likelistAdapter = LikelistAdapter(dataList)
        binding.rcLikelist.adapter = likelistAdapter
        var linearLayoutManager = LinearLayoutManager(context)
        binding.rcLikelist.layoutManager = linearLayoutManager

        likelistAdapter.setItemClickListener(object :LikelistAdapter.OnItemClickListener{
            override fun onClick(v: View, position: Int) {
                val homeFragment = HomeFragment()
                val transaction : FragmentTransaction = requireFragmentManager().beginTransaction()
                transaction.replace(R.id.fl_container,homeFragment)
                transaction.commit()
            }
        })


        getWishList()


        return binding.root

    }
    //API 연결부분
    val service = RetrofitImpl.getApiClient().create(CustomerService::class.java)
    private fun getWishList() {
        service.getWishlist().enqueue(object: Callback<WishResponse>{
            override fun onResponse(
                call : Call<WishResponse>,
                response: Response<WishResponse>
            ){
                if(response.isSuccessful){
                    //정상적으로 통신이 성공된 경우
                    Log.d("get","onResponse 성공"+response.body().toString());
                   // Toast.makeText(this@MypageLikelistFragment,"찜목록조회",Toast.LENGTH_SHORT).show()

                   // dataList = response.body() ?: ArrayList()
                    listAdapter.setList(dataList)


                }else{
                    //통신 실패
                    Log.d("get","onResponse 실패"+response.body().toString())
                }
            }
            override fun onFailure(call: Call<WishResponse>,t: Throwable){
                //통신 실패
                Log.d("get","onFailure 에러"+t.message.toString());
            }
        })
    }
}