package com.example.fit_i

import android.R
import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fit_i.databinding.FragmentHomePtBinding
import com.google.android.material.bottomsheet.BottomSheetDialog


class HomePtFragment : Fragment() {
    private lateinit var binding: FragmentHomePtBinding


    //private lateinit var tvSort: TextView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreate(savedInstanceState)

        binding = FragmentHomePtBinding.inflate(layoutInflater)

        val trainerList : ArrayList<TrainerData> = arrayListOf()

        trainerList.apply {
            add(TrainerData("김동현","개인PT",4.3, 5, "숭실대학교","Pt 센터 경력 3년. 스포애니 상도점에서 대표 트레이너로 근무한 경험이 있습니다. 가르치는 것은 자신있습니다.",20000))
            add(TrainerData("김준기","다이어트", 4.5, 2, "중앙대학교", "중앙대학교 체육대학 지난학기 수석 학생입니다. 배운 내용을 토대로 안전하게 지도해드립니다.",12000))
            add(TrainerData("홍준혁","식단관리",3.3,7,"숭실대학교","생활체육지도사 2급 자격증 이외의 다양한 자격증을 보유하고있습니다. 믿어주시면 됩니다.",12000))
            add(TrainerData("노규리","재활치료",5.0,2,"동국대학교","재활관련 센터에서 근무해본 경험이 있습니다.",20000))
        }

        val trainerAdapter = TrainerAdapter(trainerList)
        binding.rvTrainer.adapter=trainerAdapter

        val linearLayoutManager = LinearLayoutManager(context)
        binding.rvTrainer.layoutManager=linearLayoutManager

        //tvSort = findViewById(R.id.resultText)

        binding.tvSort.text = "실시간 순"

        /*
        val dialog: BottomSheetDialog = BottomSheetDialog(this)
        dialog.setContentView(R.layout.bottom_sheet)

        val tv = dialog.findViewById<TextView>(R.id.content)
        tv?.setOnClickListener {
            Toast.makeText("내용을 클릭하였습니다", Toast.LENGTH_LONG).show()
            dialog.dismiss()
        }
        dialog.show()
*/


        binding.llSort.setOnClickListener { content ->
            val bottomSheet = BottomSheetFragment()
            activity?.supportFragmentManager?.let { it1 -> bottomSheet.show(it1, BottomSheetFragment.TAG) }
            //선택한 값 불러와야함
            //위에 택스트가 바뀌어야함
            //binding.tvSort.text= select

            binding.tvSort.text = content.toString()


        } //일단은 텍스트 변경만. 실제 sorting 코드도 짜야함

        return binding.root
    }
}