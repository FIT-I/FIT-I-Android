package com.example.fit_i.ui.main.mypage

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.ImageButton
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import com.example.fit_i.R
import com.example.fit_i.RetrofitImpl
import com.example.fit_i.data.model.response.BaseResponse
import com.example.fit_i.data.model.response.GetMypageResponse
import com.example.fit_i.data.service.CommunalService
import com.example.fit_i.data.service.CustomerService
import com.example.fit_i.databinding.FragmentMypageModifyProfileBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MypageModifyProfileFragment : Fragment() {
    private var _binding: FragmentMypageModifyProfileBinding? = null
    private val binding: FragmentMypageModifyProfileBinding
        get() = requireNotNull(_binding) { "FragmentMypageModifyProfileBinding" }

    private lateinit var icon1: CheckBox
    private lateinit var icon2: CheckBox
    private lateinit var icon3: CheckBox
    private lateinit var icon4: CheckBox
    private lateinit var icon5: CheckBox
    private lateinit var icon6: CheckBox

    private var choiceIcon: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMypageModifyProfileBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fun onBind(data: GetMypageResponse.Result) {
            binding.tvName.text = data.userName
            binding.tvEmail.text = data.email
            binding.tvAddress.text = data.location

            when (data.profile) {
                "customerProfile1" -> icon1.isChecked = true
                "customerProfile2" -> icon2.isChecked = true
                "customerProfile3" -> icon3.isChecked = true
                "customerProfile4" -> icon4.isChecked = true
                "customerProfile5" -> icon5.isChecked = true
                "customerProfile6" -> icon6.isChecked = true
            }
        }

        val commmunalService = RetrofitImpl.getApiClient().create(CommunalService::class.java)
        commmunalService.getMypage().enqueue(object :
            Callback<GetMypageResponse> {
            override fun onResponse(
                call: Call<GetMypageResponse>,
                response: Response<GetMypageResponse>
            ) {
                if (response.isSuccessful) {
                    // ??????????????? ????????? ????????? ??????
                    onBind(response.body()!!.result)
                    Log.d("post", "onResponse ??????: " + response.body().toString());
                    //Toast.makeText(this@ProfileActivity, "???????????? ?????? ??????!", Toast.LENGTH_SHORT).show()

                } else {
                    // ????????? ????????? ??????(???????????? 3xx, 4xx ???)
                    Log.d("post", "onResponse ??????")
                }
            }

            override fun onFailure(call: Call<GetMypageResponse>, t: Throwable) {
                // ?????? ?????? (????????? ??????, ?????? ?????? ??? ??????????????? ??????)
                Log.d("post", "onFailure ??????: " + t.message.toString());
            }
        })

        icon1 = view.findViewById(R.id.btn_pf1)
        icon2 = view.findViewById(R.id.btn_pf2)
        icon3 = view.findViewById(R.id.btn_pf3)
        icon4 = view.findViewById(R.id.btn_pf4)
        icon5 = view.findViewById(R.id.btn_pf5)
        icon6 = view.findViewById(R.id.btn_pf6)

        icon1.setOnClickListener { onCheckChanged(icon1) }
        icon2.setOnClickListener { onCheckChanged(icon2) }
        icon3.setOnClickListener { onCheckChanged(icon3) }
        icon4.setOnClickListener { onCheckChanged(icon4) }
        icon5.setOnClickListener { onCheckChanged(icon5) }
        icon6.setOnClickListener { onCheckChanged(icon6) }
    }


    private fun onCheckChanged(compoundButton: CompoundButton) {
        when (compoundButton.id) {
            R.id.btn_pf1 ->
                if (icon1.isChecked) {
                    icon2.isChecked = false
                    icon3.isChecked = false
                    icon4.isChecked = false
                    icon5.isChecked = false
                    icon6.isChecked = false
                    choiceIcon = 1
                    changeIcon(1)

                }

            R.id.btn_pf2 ->
                if (icon2.isChecked) {
                    icon1.isChecked = false
                    icon3.isChecked = false
                    icon4.isChecked = false
                    icon5.isChecked = false
                    icon6.isChecked = false
                    choiceIcon = 2
                    changeIcon(2)

                }
            R.id.btn_pf3 ->
                if (icon3.isChecked) {
                    icon1.isChecked = false
                    icon2.isChecked = false
                    icon4.isChecked = false
                    icon5.isChecked = false
                    icon6.isChecked = false
                    choiceIcon = 3
                    changeIcon(3)

                }
            R.id.btn_pf4 ->
                if (icon4.isChecked) {
                    icon1.isChecked = false
                    icon2.isChecked = false
                    icon3.isChecked = false
                    icon5.isChecked = false
                    icon6.isChecked = false
                    choiceIcon = 4
                    changeIcon(4)

                }
            R.id.btn_pf5 ->
                if (icon5.isChecked) {
                    icon1.isChecked = false
                    icon2.isChecked = false
                    icon3.isChecked = false
                    icon4.isChecked = false
                    icon6.isChecked = false
                    choiceIcon = 5
                    changeIcon(5)

                }
            R.id.btn_pf6 ->
                if (icon6.isChecked) {
                    icon1.isChecked = false
                    icon2.isChecked = false
                    icon3.isChecked = false
                    icon4.isChecked = false
                    icon5.isChecked = false
                    choiceIcon = 6
                    changeIcon(6)
                }
        }

        if (!icon1.isChecked && !icon2.isChecked && !icon3.isChecked && !icon4.isChecked && !icon5.isChecked && !icon6.isChecked) {
            choiceIcon = 0

            Toast.makeText(context, "????????? ????????? ?????? ?????????.", Toast.LENGTH_SHORT).show()
        }
//
//        if(choiceIcon!=0)
//            btnIconChoice.isEnabled = true
        //?????? ???????????? ??? ?????? ????????? ?????? ????????? ??????
    }

    fun changeIcon(num : Int) {
        val customerService = RetrofitImpl.getApiClient().create(CustomerService::class.java)
        customerService.modifyProfile(profile = "customerProfile${num}").enqueue(object :
            Callback<BaseResponse> {
            override fun onResponse(call: Call<BaseResponse>, response: Response<BaseResponse>) {
                if (response.isSuccessful) {
                    // ??????????????? ????????? ????????? ??????
                    Log.d("post", "onResponse ??????: " + response.body().toString());
                    //Toast.makeText(this@ProfileActivity, "???????????? ?????? ??????!", Toast.LENGTH_SHORT).show()

                } else {
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
}
