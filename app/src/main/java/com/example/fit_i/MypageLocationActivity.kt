package com.example.fit_i

import android.R
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.webkit.JavascriptInterface
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MypageLocationActivity : AppCompatActivity() {
//
//    private var webView: WebView? = null
//    private var txt_address: TextView? = null
//    private lateinit var handler: Handler
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_mypage_location)
//        txt_address = findViewById(R.id.txt_address)
//
//        // WebView 초기화
//        init_webView()
//
//        // 핸들러를 통한 JavaScript 이벤트 반응
//        handler = Handler()
//    }
//
//    fun init_webView() {
//        // WebView 설정
//
//        webView = findViewById<View>(R.id.daum_webview) as WebView
//
//        // JavaScript 허용
//        webView!!.settings.javaScriptEnabled = true
//
//        // JavaScript의 window.open 허용
//        webView!!.settings.javaScriptCanOpenWindowsAutomatically = true
//
//
//        // JavaScript이벤트에 대응할 함수를 정의 한 클래스를 붙여줌
//        webView!!.addJavascriptInterface(AndroidBridge(), "TestApp")
//
//        // web client 를 chrome 으로 설정
//        webView!!.webChromeClient = WebChromeClient()
//
//        // webview url load. php 파일 주소
//        webView!!.loadUrl("내 php주소 입력")
//    }
//
//
//    private class AndroidBridge {
//        @JavascriptInterface
//        fun setAddress(arg1: String?, arg2: String?, arg3: String?) {
//            handler.post(Runnable {
//                txt_address.setText(String.format("(%s) %s %s", arg1, arg2, arg3))
//
//                // WebView를 초기화 하지않으면 재사용할 수 없음
//                init_webView()
//            })
//        }
//    }
}