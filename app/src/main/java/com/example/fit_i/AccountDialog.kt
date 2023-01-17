package com.example.fit_i

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import com.example.fit_i.databinding.DialogAccountBinding
import com.example.fit_i.databinding.DialogProfileBinding

class AccountDialog(context: Context, private val okCallbacks: (String) -> Unit):Dialog(context) {
    //뷰를 띄우기 위해 클래스를 context 인자로 받기
    private lateinit var binding: DialogAccountBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DialogAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() = with(binding) {
        //뒤로 가기나 빈 화면 터치로 사라지지 않도록
        setCancelable(false)
        //background 투명하게
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        //버튼 클릭에 대한 콜백 처리
        //취소하면 다시 백, 탈퇴하면 탙퇴 처리 후 첫화면 돌아가기
        btnAccountCancel.setOnClickListener {
            dismiss()
        }
        btnAccountOut.setOnClickListener {
            //탈퇴에 대한 코드 필요
            dismiss()
        }

    }
}