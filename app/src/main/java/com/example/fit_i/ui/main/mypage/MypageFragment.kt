package com.example.fit_i.ui.main.mypage

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.lifecycleScope
import com.example.fit_i.*
import com.example.fit_i.data.model.response.BaseResponse
import com.example.fit_i.data.model.response.GetMypageResponse
import com.example.fit_i.data.service.CommunalService
import com.example.fit_i.data.service.CustomerService
import com.example.fit_i.databinding.FragmentMypageBinding
import com.example.fit_i.ui.main.MainActivity
import com.example.fit_i.ui.main.mypage.notice.MypageNoticeFragment
import com.example.fit_i.ui.main.mypage.review.MypageReviewFragment
import com.example.fit_i.ui.main.mypage.setting.MypageLogoutFragment
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MypageFragment : Fragment() {
    private var _binding: FragmentMypageBinding? = null
    private val binding: FragmentMypageBinding
        get() = requireNotNull(_binding) { "FragmentMypageBinding" }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMypageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //val swtmy : Switch= view.findViewById(R.id.swt_my)

        fun onBind(data: GetMypageResponse.Result) {
            binding.tvNameM.text=data.userName
            binding.tvEmailM.text=data.email
        }

        val commmunalService = RetrofitImpl.getApiClient().create(CommunalService::class.java)
        commmunalService.getMypage().enqueue(object :
            Callback<GetMypageResponse> {
            override fun onResponse(call: Call<GetMypageResponse>, response: Response<GetMypageResponse>) {
                if(response.isSuccessful){
                    // ??????????????? ????????? ????????? ??????
                    onBind(response.body()!!.result)
                    Log.d("post", "onResponse ??????: " + response.body().toString());
                    //Toast.makeText(this@ProfileActivity, "???????????? ?????? ??????!", Toast.LENGTH_SHORT).show()

                }else{
                    // ????????? ????????? ??????(???????????? 3xx, 4xx ???)
                    Log.d("post", "onResponse ??????")
                }
            }

            override fun onFailure(call: Call<GetMypageResponse>, t: Throwable) {
                // ?????? ?????? (????????? ??????, ?????? ?????? ??? ??????????????? ??????)
                Log.d("post", "onFailure ??????: " + t.message.toString());
            }
        })

        //??????  -????????????,????????????
        binding.ibSetting.setOnClickListener {
            val mypageSettingFragment = MypageLogoutFragment()
            val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()

            transaction.replace(R.id.fl_container, mypageSettingFragment)
            transaction.commit()
        }

        //???????????????
        binding.tvGoModifyProfile.setOnClickListener {
            val mypageModifyProfileFragment = MypageModifyProfileFragment()
            val transaction : FragmentTransaction = requireFragmentManager().beginTransaction()

            transaction.replace(R.id.fl_container, mypageModifyProfileFragment)
            transaction.commit()
        }


        /*
        //????????? ???????????? ?????? ????????????
        swtmy.setOnCheckedChangeListener { buttonView, isChecked ->
            val customerService = RetrofitImpl.getApiClient().create(CustomerService::class.java)
            if (isChecked) {
                //????????? ?????? ????????? ?????? ??????
                customerService.ringOn().enqueue(object :
                    Callback<BaseResponse> {
                    override fun onResponse(call: Call<BaseResponse>, response: Response<BaseResponse>) {
                        if(response.isSuccessful){
                            // ??????????????? ????????? ????????? ??????
                            Log.d("post", "onResponse ??????: " + response.body().toString());
                            Toast.makeText(context, response.body()?.result.toString(), Toast.LENGTH_SHORT).show()

                        }else{
                            // ????????? ????????? ??????(???????????? 3xx, 4xx ???)
                            Log.d("post", "onResponse ??????")
                        }
                    }

                    override fun onFailure(call: Call<BaseResponse>, t: Throwable) {
                        // ?????? ?????? (????????? ??????, ?????? ?????? ??? ??????????????? ??????)
                        Log.d("post", "onFailure ??????: " + t.message.toString());
                    }
                })
            } else {
                //????????? ?????? ?????? ??? ??????
                customerService.ringOff().enqueue(object :
                    Callback<BaseResponse> {
                    override fun onResponse(call: Call<BaseResponse>, response: Response<BaseResponse>) {
                        if(response.isSuccessful){
                            // ??????????????? ????????? ????????? ??????
                            Log.d("post", "onResponse ??????: " + response.body().toString());
                            Toast.makeText(context, response.body()?.result.toString(), Toast.LENGTH_SHORT).show()

                        }else{
                            // ????????? ????????? ??????(???????????? 3xx, 4xx ???)
                            Log.d("post", "onResponse ??????")
                        }
                    }

                    override fun onFailure(call: Call<BaseResponse>, t: Throwable) {
                        // ?????? ?????? (????????? ??????, ?????? ?????? ??? ??????????????? ??????)
                        Log.d("post", "onFailure ??????: " + t.message.toString());
                    }
                })
            }
        }*/

        //??? ??????
        binding.clWish.setOnClickListener {
            val mypageLikelistFragment = MypageLikelistFragment()
            val transaction : FragmentTransaction = requireFragmentManager().beginTransaction()


            transaction.replace(R.id.fl_container, mypageLikelistFragment)
            transaction.commit()
        }

        //?????? ?????? ????????????
        binding.clMatching.setOnClickListener {
            val mypageReviewBinding = MypageReviewFragment()
            val transaction : FragmentTransaction = requireFragmentManager().beginTransaction()

            transaction.replace(R.id.fl_container, mypageReviewBinding)
            transaction.commit()
        }

        //?????? ??????
        binding.clLocation.setOnClickListener {
            val intent = Intent(context, MypageLocationActivity::class.java)  // ???????????? ????????????,
            startActivity(intent)  // ?????? ????????? ?????????
            //finish()
        }

        //???????????? ?????????
        binding.clPwChange.setOnClickListener {
            val intent = Intent(context, MypageChangePwActivity::class.java)  // ???????????? ????????????,
            startActivity(intent)  // ?????? ????????? ?????????
            //finish()
        }

        // ????????????
        binding.clNotice.setOnClickListener {
            val mypageNoticeFragment = MypageNoticeFragment()
            val transaction : FragmentTransaction = requireFragmentManager().beginTransaction()

            transaction.replace(R.id.fl_container, mypageNoticeFragment)
            transaction.commit()
        }

        //????????????
        binding.clPermission.setOnClickListener {
            val mypagepermissonFragment = MypagePermissonFragment()
            val transaction : FragmentTransaction = requireFragmentManager().beginTransaction()

            transaction.replace(R.id.fl_container, mypagepermissonFragment)
            transaction.commit()
        }
    }
}