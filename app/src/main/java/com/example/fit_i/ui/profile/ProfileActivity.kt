package com.example.fit_i.ui.profile

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fit_i.R
import com.example.fit_i.databinding.ActivityProfileBinding
import org.w3c.dom.Text


class ProfileActivity : AppCompatActivity() {
    lateinit var binding: ActivityProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvProfileReviewDetail.layoutManager =
            LinearLayoutManager(this).also { it.orientation = LinearLayoutManager.HORIZONTAL }

        this.setListener()
    }

    // 버튼 클릭 이벤트
    private fun setListener(){
        // 자기소개 자세히 보기 버튼 이벤트
        binding.ibProfileIntroductionDetail.setOnClickListener {
            if(binding.tvProfileUserIntroduction.maxLines == 4) {
                binding.tvProfileUserIntroduction.maxLines = Int.MAX_VALUE
                binding.tvProfileUserIntroduction.ellipsize = null
                binding.ibProfileIntroductionDetail.setRotation(180.0f)
            } else{
                binding.tvProfileUserIntroduction.maxLines = 4
                binding.tvProfileUserIntroduction.ellipsize = TextUtils.TruncateAt.END
                binding.ibProfileIntroductionDetail.setRotation(360.0f)
            }
        }

        // 서비스 상세 설명 자세히 보기 버튼 이벤트
        binding.ibProfileServiceDetail.setOnClickListener {
            if(binding.tvProfileServiceDetail.maxLines == 4){
                binding.tvProfileServiceDetail.maxLines = Int.MAX_VALUE
                binding.tvProfileServiceDetail.ellipsize = null
                binding.ibProfileServiceDetail.setRotation(180.0f)
            } else{
                binding.tvProfileServiceDetail.maxLines = 4
                binding.tvProfileServiceDetail.ellipsize = TextUtils.TruncateAt.END
                binding.ibProfileServiceDetail.setRotation(360.0f)
            }
        }

        // 좋아요 버튼 이벤트
        var isLike: Boolean = false
        binding.ibProfileLike.setOnClickListener {
            if(isLike){
                binding.ibProfileLike.setImageResource(R.drawable.ic_like_not_fill)
                isLike = false
            } else{
                binding.ibProfileLike.setImageResource(R.drawable.ic_like_fill)
                isLike = true
            }
        }
    }
}