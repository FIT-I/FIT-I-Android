package com.example.fit_i

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fit_i.databinding.ActivityReviewBinding

class ReviewActivity:AppCompatActivity() {
    val binding by lazy{ActivityReviewBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState:Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review)

    }
}