package com.example.fit_i.ui.main.mypage

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.FragmentTransaction
import com.example.fit_i.App
import com.example.fit_i.R
import com.example.fit_i.RetrofitImpl
import com.example.fit_i.data.model.request.LogoutRequest
import com.example.fit_i.data.model.response.BaseResponse
import com.example.fit_i.data.service.AccountsService
import com.example.fit_i.ui.login.LoginActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MypageSiginoutFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_mypage_siginout, container, false)
        val btnstay = view.findViewById<View>(R.id.btn_stay) as AppCompatButton
        val btnclose = view.findViewById<View>(R.id.btn_withdraw2) as AppCompatButton

        //계속 있기
        btnstay.setOnClickListener {
            val mypageFragment = MypageFragment()
            val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()

            transaction.replace(R.id.fl_container, mypageFragment)
            transaction.commit()
        }

        //탈퇴하기
        btnclose.setOnClickListener {
            val dialog = AlertDialog.Builder(context)
            dialog.setTitle("계정 탈퇴")
            dialog.setMessage("정말 계정 탈퇴 하시겠습니까?")
            //dialog.setIcon(R.drawable.icon5)

            fun makeToast() {
                Toast.makeText(context, "탈퇴 되었습니다.", Toast.LENGTH_SHORT).show()
                val intent = Intent(activity, LoginActivity::class.java)
                startActivity(intent)
            }
            fun close(){ //작동 하는지 아직 확인 x
                val accountService = RetrofitImpl.getApiClient().create(AccountsService::class.java)
                val token = LogoutRequest(App.token_prefs.accessToken.toString(), App.token_prefs.refreshToken.toString())
                accountService.logOut(token).enqueue(object : Callback<BaseResponse> {
                    override fun onResponse(
                        call: Call<BaseResponse>,
                        response: Response<BaseResponse>
                    ) {
                        if (response.isSuccessful) {
                            // 정상적으로 통신이 성공된 경우
                            Log.d("post", "onResponse 성공: " + response.body().toString());
                          } else {
                            // 통신이 실패한 경우(응답코드 3xx, 4xx 등)
                            Log.d("post", "onResponse 실패 "+ response.body().toString())
                        }
                    }

                    override fun onFailure(call: Call<BaseResponse>, t: Throwable) {
                        // 통신 실패 (인터넷 끊킴, 예외 발생 등 시스템적인 이유)
                        Log.d("post", "onFailure 에러: " + t.message.toString());
                    }
                })
            }

            val dialog_listener = DialogInterface.OnClickListener { dialog, which ->
                when(which){
                    DialogInterface.BUTTON_POSITIVE ->{
                        close() //탈퇴처리
                        makeToast() //토스트 띄우고 로그인화면으로 이동
                    }
                }
            }
            dialog.setPositiveButton("계정 탈퇴",dialog_listener)
            dialog.setNegativeButton("취소",null)
            dialog.show()
        }
//        btnwithdraw2.setOnClickListener {
//            //showAccountDialog()
//
//        }
        return view
    }
//
//    private fun showAccountDialog() {
//        AccountDialog(requireContext()) {
//        }.show()
//    }
}