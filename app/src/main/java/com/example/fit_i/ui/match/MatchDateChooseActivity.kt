package com.example.fit_i.ui.match

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.fit_i.R
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.MaterialCalendarView

class MatchDateChooseActivity : AppCompatActivity() {
    var startDate =""
    var endDate =""
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_match_date_choose)

        //날짜 선택

        val cal = findViewById<MaterialCalendarView>(R.id.cv_date_pick)
        val calList = ArrayList<CalendarDay>()
//        cal.setOnRangeSelectedListener { widget:MaterialCalendarView, dates:List<CalendarDay> ->
//
//            calList.add(dates[0])
//            calList.add(dates[1])
//            startDate= calList[0].toString()
//            endDate = calList[1].toString()
//            Log.d("태그", "내용 : "+startDate)
//        }

        //뒤로가기
        val goBack = findViewById<ImageButton>(R.id.ib_back_arrow)
        goBack.setOnClickListener{
            val intent = Intent(this, MatchServiceActivity::class.java)
            startActivity(intent)
            finish()
        }
        //날짜선택 다음 단계로 이동
        val nextStep = findViewById<TextView>(R.id.btn_next)
        nextStep.setOnClickListener{
            val intent = Intent(this, MatchPickUpActivity::class.java)
            startActivity(intent)
            finish()
        }


    }

}