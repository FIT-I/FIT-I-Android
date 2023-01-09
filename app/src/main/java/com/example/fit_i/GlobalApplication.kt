package com.example.fit_i

import android.app.Application
import com.kakao.sdk.common.KakaoSdk

class GlobalApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        KakaoSdk.init(this, "78fa9b34400ac36c567656199e53f636" )
    }
}