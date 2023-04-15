package com.example.fit_i.ui.profile.review

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fit_i.R
import com.example.fit_i.databinding.FragmentProfileReviewBoxBinding

class ProfileReviewBoxFragment : Fragment() {
    private var _binding: FragmentProfileReviewBoxBinding? = null
    private val binding: FragmentProfileReviewBoxBinding
        get() = requireNotNull(_binding) { "FragmentProfileReviewBoxBinding" }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileReviewBoxBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // 나중에 데이터 불러와서 값 넣기
        binding.pbProfileReviewScore5.max = 100
        binding.pbProfileReviewScore5.progress = 90
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}