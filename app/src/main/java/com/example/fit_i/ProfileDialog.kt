package com.example.fit_i

import android.app.Dialog
import android.content.ComponentCallbacks
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import com.example.fit_i.data.model.request.LogoutRequest
import com.example.fit_i.data.model.response.BaseResponse
import com.example.fit_i.data.service.AccountsService
import com.example.fit_i.databinding.DialogProfileBinding
import com.example.fit_i.ui.login.LoginActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileDialog(context: Context, private val okCallbacks: (String)-> Unit,): Dialog(context) {
    //뷰를 띄워야하므로 Dialog 클래스는 context를 인자로 받는다
    private lateinit var binding: DialogProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //만들어놓은 dialog_profile.xml 뷰를 띄우기
        binding = DialogProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() = with(binding) {
        //뒤로가기 버튼, 빈 화면 터치를 통해 사라지지 않도록
        setCancelable(false)
        //background를 투명하게 만들기 (중요)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        //button 클릭에 대한 Callback 처리.
        //취소하면 다시 백, 로그아웃하면 로그아웃 처리후 첫화면 돌아가기
        btnCancel.setOnClickListener {
            dismiss()
        }
        btnOut.setOnClickListener {
            //로그아웃에 대한 코드 짜기
            dismiss()
        }
    }
}