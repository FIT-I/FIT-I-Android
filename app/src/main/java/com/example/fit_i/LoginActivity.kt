package com.example.fit_i

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import com.example.fit_i.databinding.ActivityLoginBinding
import com.kakao.sdk.auth.LoginClient
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.KakaoSdk

import com.kakao.sdk.common.model.AuthErrorCause.*
import com.kakao.sdk.common.model.ClientError
import com.kakao.sdk.common.model.ClientErrorCause
import com.kakao.sdk.user.UserApiClient
import com.navercorp.nid.NaverIdLoginSDK
import com.navercorp.nid.oauth.NidOAuthLogin
import com.navercorp.nid.oauth.OAuthLoginCallback
import com.navercorp.nid.profile.NidProfileCallback
import com.navercorp.nid.profile.api.NidProfileApi
import com.navercorp.nid.profile.data.NidProfileResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response


class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

//    private val TAG = this.javaClass.simpleName
//
//    private var email: String = ""
//    private var gender: String = ""
//    private var name: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        binding = ActivityLoginBinding.inflate(layoutInflater)

        //val keyHash = Utility.getKeyHash(this)
        //Log.e("해시키", keyHash)

        // 로그인 정보 확인
        UserApiClient.instance.accessTokenInfo { tokenInfo, error ->
            if (error != null) {
                Toast.makeText(this, "토큰 정보 보기 실패", Toast.LENGTH_SHORT).show()
            } else if (tokenInfo != null) {
                Toast.makeText(this, "토큰 정보 보기 성공", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
                finish()
            }
        }

        val callback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
            if (error != null) {
                when {
                    error.toString() == AccessDenied.toString() -> {
                        Toast.makeText(this, "접근이 거부 됨(동의 취소)", Toast.LENGTH_SHORT).show()
                    }
                    error.toString() == InvalidClient.toString() -> {
                        Toast.makeText(this, "유효하지 않은 앱", Toast.LENGTH_SHORT).show()
                    }
                    error.toString() == InvalidGrant.toString() -> {
                        Toast.makeText(this, "인증 수단이 유효하지 않아 인증할 수 없는 상태", Toast.LENGTH_SHORT)
                            .show()
                    }
                    error.toString() == InvalidRequest.toString() -> {
                        Toast.makeText(this, "요청 파라미터 오류", Toast.LENGTH_SHORT).show()
                    }
                    error.toString() == InvalidScope.toString() -> {
                        Toast.makeText(this, "유효하지 않은 scope ID", Toast.LENGTH_SHORT).show()
                    }
                    error.toString() == Misconfigured.toString() -> {
                        Toast.makeText(this, "설정이 올바르지 않음(android key hash)", Toast.LENGTH_SHORT)
                            .show()
                    }
                    error.toString() == ServerError.toString() -> {
                        Toast.makeText(this, "서버 내부 에러", Toast.LENGTH_SHORT).show()
                    }
                    error.toString() == Unauthorized.toString() -> {
                        Toast.makeText(this, "앱이 요청 권한이 없음", Toast.LENGTH_SHORT).show()
                    }
                    else -> { // Unknown
                        Toast.makeText(this, "기타 에러", Toast.LENGTH_SHORT).show()
                    }
                }
            } else if (token != null) {
                Toast.makeText(this, "로그인에 성공하였습니다.", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
                finish()
            }
        }

        val kakao_login_button = findViewById<ImageButton>(R.id.kakao_login_button) // 로그인 버튼

        kakao_login_button.setOnClickListener {
            if (LoginClient.instance.isKakaoTalkLoginAvailable(this)) {
                LoginClient.instance.loginWithKakaoTalk(this, callback = callback)
            } else {
                LoginClient.instance.loginWithKakaoAccount(this, callback = callback)
            }
        }
    }

//        //네이버 로그인
//        binding.run {
//            naverLoginButton.setOnClickListener {
//                val oAuthLoginCallback = object : OAuthLoginCallback {
//                    override fun onSuccess() {
//                        // 네이버 로그인 API 호출 성공 시 유저 정보를 가져온다
//                        NidOAuthLogin().callProfileApi(object :
//                            NidProfileCallback<NidProfileResponse> {
//                            override fun onSuccess(result: NidProfileResponse) {
//                                name = result.profile?.name.toString()
//                                email = result.profile?.email.toString()
//                                gender = result.profile?.gender.toString()
//                                Log.e(TAG, "네이버 로그인한 유저 정보 - 이름 : $name")
//                                Log.e(TAG, "네이버 로그인한 유저 정보 - 이메일 : $email")
//                                Log.e(TAG, "네이버 로그인한 유저 정보 - 성별 : $gender")
//                            }
//
//                            override fun onError(errorCode: Int, message: String) {
//                                //
//                            }
//
//                            override fun onFailure(httpStatus: Int, message: String) {
//                                //
//                            }
//                        })
//                    }
//
//                    override fun onError(errorCode: Int, message: String) {
//                        val naverAccessToken = NaverIdLoginSDK.getAccessToken()
//                        Log.e(TAG, "naverAccessToken : $naverAccessToken")
//                    }
//
//                    override fun onFailure(httpStatus: Int, message: String) {
//                        //
//                    }
//                }
//
//                NaverIdLoginSDK.initialize(
//                    this@LoginActivity,
//                    getString(R.string.naver_client_id),
//                    getString(R.string.naver_client_secret),
//                    "FIT-I"
//                )
//                NaverIdLoginSDK.authenticate(this@LoginActivity, oAuthLoginCallback)
//            }
//        }
//    }
}