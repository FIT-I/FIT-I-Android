package com.example.fit_i.ui.main.mypage

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageButton
import androidx.fragment.app.FragmentTransaction
import com.example.fit_i.R
import com.example.fit_i.RetrofitImpl
import com.example.fit_i.data.model.response.GetMypageResponse
import com.example.fit_i.data.service.CommunalService
import com.example.fit_i.databinding.FragmentMypageBinding
import com.example.fit_i.databinding.FragmentMypageModifyProfileBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MypageModifyProfileFragment : Fragment() {
    private var _binding: FragmentMypageModifyProfileBinding? = null
    private val binding: FragmentMypageModifyProfileBinding
        get() = requireNotNull(_binding) { "FragmentMypageModifyProfileBinding" }

    lateinit var  btnpf1 : CheckBox
    lateinit var btnpf2 : CheckBox
    lateinit var btnpf3 : CheckBox
    lateinit var btnpf4 :CheckBox
    lateinit var btnpf5 : CheckBox
    lateinit var btnpf6 :CheckBox

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
            binding.tvName.text=data.userName
            binding.tvEmail.text=data.email
            binding.tvAddress.text=data.location
        }

        val commmunalService = RetrofitImpl.getApiClient().create(CommunalService::class.java)
        commmunalService.getMypage().enqueue(object :
            Callback<GetMypageResponse> {
            override fun onResponse(call: Call<GetMypageResponse>, response: Response<GetMypageResponse>) {
                if(response.isSuccessful){
                    // 정상적으로 통신이 성공된 경우
                    onBind(response.body()!!.result)
                    Log.d("post", "onResponse 성공: " + response.body().toString());
                    //Toast.makeText(this@ProfileActivity, "비밀번호 찾기 성공!", Toast.LENGTH_SHORT).show()

                }else{
                    // 통신이 실패한 경우(응답코드 3xx, 4xx 등)
                    Log.d("post", "onResponse 실패")
                }
            }

            override fun onFailure(call: Call<GetMypageResponse>, t: Throwable) {
                // 통신 실패 (인터넷 끊킴, 예외 발생 등 시스템적인 이유)
                Log.d("post", "onFailure 에러: " + t.message.toString());
            }
        })

        val ibpre = view.findViewById<View>(R.id.ib_pre) as ImageButton
        btnpf1 = view.findViewById(R.id.btn_pf1)
        btnpf2 = view.findViewById(R.id.btn_pf2)
        btnpf3 = view.findViewById(R.id.btn_pf3)
        btnpf4 = view.findViewById(R.id.btn_pf4)
        btnpf5 = view.findViewById(R.id.btn_pf5)
        btnpf6 = view.findViewById(R.id.btn_pf6)

        //이전
        ibpre.setOnClickListener {
            val mypageFragment = MypageFragment()
            val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()

            //이전 화면으로 이동
            transaction.replace(R.id.fl_container, mypageFragment)
            transaction.commit()
        }
    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        changeOnClickListener()
//    }
//
//    private fun changeOnClickListener() {
//        val btnSequence = binding.container.children
//        btnSequence.forEach { btn ->
//            btn.setOnClickListener(this)
//        }
//
//    }
//
//    override fun onClick(v: View) {
//        when (v.id) {
//            R.id.btn_pf1 ->
//                if (btnpf1.isChecked) {
//                    btnpf2!!.isChecked = false
//                    btnpf3!!.isChecked = false
//                    btnpf4!!.isChecked = false
//                    btnpf5!!.isChecked = false
//                    btnpf6!!.isChecked = false
//                }
//            R.id.btn_pf2 ->
//                if (btnpf2!!.isChecked) {
//                    btnpf1!!.isChecked = false
//                    btnpf3!!.isChecked = false
//                    btnpf4!!.isChecked = false
//                    btnpf5!!.isChecked = false
//                    btnpf6!!.isChecked = false
//                }
//            R.id.btn_pf3 ->
//                if (btnpf3!!.isChecked) {
//                    btnpf1!!.isChecked = false
//                    btnpf2!!.isChecked = false
//                    btnpf4!!.isChecked = false
//                    btnpf5!!.isChecked = false
//                    btnpf6!!.isChecked = false
//                }
//            R.id.btn_pf4 ->
//                if (btnpf4!!.isChecked) {
//                    btnpf1!!.isChecked = false
//                    btnpf2!!.isChecked = false
//                    btnpf3!!.isChecked = false
//                    btnpf5!!.isChecked = false
//                    btnpf6!!.isChecked = false
//
//                }
//            R.id.btn_pf5 ->
//                if (btnpf5!!.isChecked) {
//                    btnpf1!!.isChecked = false
//                    btnpf2!!.isChecked = false
//                    btnpf3!!.isChecked = false
//                    btnpf4!!.isChecked = false
//                    btnpf6!!.isChecked = false
//
//                }
//
//            R.id.btn_pf6 ->
//                if (btnpf6!!.isChecked) {
//                    btnpf1!!.isChecked = false
//                    btnpf2!!.isChecked = false
//                    btnpf3!!.isChecked = false
//                    btnpf4!!.isChecked = false
//                    btnpf5!!.isChecked = false
//                }
//        }
//    }


}
