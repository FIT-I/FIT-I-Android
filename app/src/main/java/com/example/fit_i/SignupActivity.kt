package com.example.fit_i

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fit_i.databinding.ActivitySignupBinding


class SignupActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding
    //메시지 담을 변수
    var name: String = ""
    var email : String=""
    var pw: String=""
    var pw2: String=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        //객체 생성
        val etName :EditText = findViewById(R.id.et_name)
        val etEmail : EditText = findViewById(R.id.et_email)
        val etPW : EditText = findViewById(R.id.et_pw)
        val etPW2: EditText = findViewById(R.id.et_pw2)
        val btnFinSignUp : Button = findViewById(R.id.btn_fin_signUp)

        //버튼 비활성화
        btnFinSignUp.isEnabled = false

        //EditText 값 있을때만 버튼 활성화
        etName.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            //값 변경 시 실행되는 함수
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //입력값 담기
                name = etName.text.toString()

                //값 유무에 따른 활성화 여부
                btnFinSignUp.isEnabled = isTrue() //있다면 true 없으면 false
            }
            override fun afterTextChanged(p0: Editable?) {}
        })

        etEmail.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            //값 변경 시 실행되는 함수
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //입력값 담기
                email = etEmail.text.toString()

                //값 유무에 따른 활성화 여부
                btnFinSignUp.isEnabled = isTrue() //있다면 true 없으면 false
           }
            override fun afterTextChanged(p0: Editable?) {}
        })

        etPW.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            //값 변경 시 실행되는 함수
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //입력값 담기
                pw = etPW.text.toString()

                //값 유무에 따른 활성화 여부
                btnFinSignUp.isEnabled = isTrue() //있다면 true 없으면 false
            }
            override fun afterTextChanged(p0: Editable?) {}
        })

        etPW2.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            //값 변경 시 실행되는 함수
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //입력값 담기
                pw2 = etPW2.text.toString()

                //값 유무에 따른 활성화 여부
                btnFinSignUp.isEnabled = isTrue() //있다면 true 없으면 false
            }
            override fun afterTextChanged(p0: Editable?) {}
        })


        //비밀번호 눈 아이콘

        val ivEye1 : ImageView = findViewById(R.id.iv_eye1)
        val ivEye2 : ImageView =findViewById(R.id.iv_eye2)

        ivEye1.setOnClickListener(){
            if(ivEye1.tag.equals("0")){//비밀번호 안 보이고 있던 상황
                ivEye1.tag = "1"
                ivEye1.setImageResource(R.drawable.ic_eye)
                etPW.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
            }else{//비밀번호 보이고 있던 상황
                ivEye1.tag = "0"
                ivEye1.setImageResource(R.drawable.ic_eye_slash)
                etPW.inputType = InputType.TYPE_TEXT_VARIATION_PASSWORD
            }
            etPW.setSelection(etPW.text.length)
            //etPW2.setSelection(etPW.text.length)
        }

        ivEye2.setOnClickListener(){
            if(ivEye2.tag.equals("0")){//비밀번호 안 보이고 있던 상황
                ivEye2.tag = "1"
                ivEye2.setImageResource(R.drawable.ic_eye)
                etPW.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
            }else{//비밀번호 보이고 있던 상황
                ivEye2.tag = "0"
                ivEye2.setImageResource(R.drawable.ic_eye_slash)
                etPW2.inputType = InputType.TYPE_TEXT_VARIATION_PASSWORD
            }
            //etPW.setSelection(etPW.text.length)
            etPW2.setSelection(etPW.text.length)
        }


        //회원가입하기
        //버튼 이벤트
        btnFinSignUp.setOnClickListener {
            val intent = Intent(this, SignupIconActivity::class.java)
            startActivity(intent)  // 화면 전환을 시켜줌
            finish()
        Toast.makeText(this, name+"signUp", Toast.LENGTH_SHORT).show()
        }
    }

    private fun isTrue(): Boolean {
        return name.isNotEmpty()&&email.isNotEmpty()&&pw.isNotEmpty()&&pw2.isNotEmpty()
    }
}
