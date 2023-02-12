package com.example.fit_i.ui.main.mypage.setting

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.fit_i.App
import com.example.fit_i.MySharedPreferences
import com.example.fit_i.R
import com.example.fit_i.RetrofitImpl
import com.example.fit_i.data.model.request.LogoutRequest
import com.example.fit_i.data.model.response.BaseResponse
import com.example.fit_i.data.service.AccountsService
import com.example.fit_i.databinding.FragmentMypageLogoutBinding
import com.example.fit_i.ui.login.LoginActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MypageLogoutFragment :Fragment() {
    private lateinit var binding: FragmentMypageLogoutBinding

    @SuppressLint("MissingInflatedId")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMypageLogoutBinding.inflate(layoutInflater)

        val view = inflater.inflate(R.layout.fragment_mypage_logout, container, false)

        val btnlogout = view.findViewById<View>(R.id.btn_logout) as AppCompatButton
        val btnwithdraw = view.findViewById<View>(R.id.btn_withdraw) as AppCompatButton

        btnlogout.setOnClickListener {
            val dialog = AlertDialog.Builder(context)
            dialog.setTitle("로그아웃")
            dialog.setMessage("정말 로그아웃 하시겠습니까?")
            //dialog.setIcon(R.drawable.icon5)

            fun makeToast() {
                Toast.makeText(context, "로그아웃 되었습니다.", Toast.LENGTH_SHORT).show()
                val intent = Intent(activity, LoginActivity::class.java)
                startActivity(intent)
            }

            fun logout() {
                val accountService = RetrofitImpl.getApiClient().create(AccountsService::class.java)
                val token = LogoutRequest(
                    accessToken = App.token_prefs.accessToken.toString(),
                    refreshToken = App.token_prefs.refreshToken.toString()
                )
                accountService.logOut(token).enqueue(object : Callback<BaseResponse> {
                    override fun onResponse(
                        call: Call<BaseResponse>,
                        response: Response<BaseResponse>
                    ) {
                        if (response.isSuccessful) {
                            // 정상적으로 통신이 성공된 경우
                            Log.d("post", "onResponse 성공: " + response.body().toString());
                            MySharedPreferences.clearUser(context!!)
                            makeToast()
                        } else {
                            // 통신이 실패한 경우(응답코드 3xx, 4xx 등)
                            //Log.d("post", response.code().toString()+"onResponse 실패 "+ response.body().toString()+token)
                            Log.d("post", "onResponse 실패 " + response.body().toString() + token)

                        }
                    }

                    override fun onFailure(call: Call<BaseResponse>, t: Throwable) {
                        // 통신 실패 (인터넷 끊킴, 예외 발생 등 시스템적인 이유)
                        Log.d("post", "onFailure 에러: " + t.message.toString());
                    }
                })
            }

            val dialog_listener = DialogInterface.OnClickListener { dialog, which ->
                when (which) {
                    DialogInterface.BUTTON_POSITIVE -> {
                        logout()
                    }
                }
            }
            dialog.setPositiveButton("로그아웃", dialog_listener)
            dialog.setNegativeButton("취소", null)
            dialog.show()
        }
        btnwithdraw.setOnClickListener {
            val mypageSiginoutFragment = MypageSiginoutFragment()
            val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()

            transaction.replace(R.id.fl_container, mypageSiginoutFragment)
            transaction.commit()
        }
        return view
    }
}
