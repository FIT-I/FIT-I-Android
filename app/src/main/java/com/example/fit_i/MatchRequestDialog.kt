package com.example.fit_i

import android.view.Window
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import com.example.fit_i.databinding.DialogMatchRequestBinding

class MatchRequestDialog(private val context: AppCompatActivity) {
    private lateinit var binding : DialogMatchRequestBinding
    private val dlg = Dialog(context)

    fun matchDialog(){
       binding = DialogMatchRequestBinding.inflate(context.layoutInflater)
        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dlg.setContentView(R.layout.dialog_match_request)
        dlg.setCancelable(false)

        //요청버튼 동작
        binding.btnRequest.setOnClickListener{
            //TODO: 부모 액티비티로 내용을 돌려주기 위해 작성할 코드
            dlg.dismiss()
        }
        //취소버튼 동작
        binding.btnCancel.setOnClickListener{
            dlg.dismiss()
        }
        dlg.show()
    }
}