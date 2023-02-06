package com.example.fit_i.ui.match

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.fit_i.R
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.MaterialCalendarView
import java.text.SimpleDateFormat
import androidx.core.util.Pair
import com.example.fit_i.databinding.ActivityMatchDateChooseBinding
import com.google.android.material.datepicker.CalendarConstraints
import com.google.android.material.datepicker.DateValidatorPointForward
import java.util.*
import java.util.Calendar.getInstance

class MatchDateChooseActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMatchDateChooseBinding


    var startDate =""
    var endDate =""

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding = ActivityMatchDateChooseBinding.inflate(layoutInflater)


        //날짜 선택
//
//        binding.cvCalendar.setOnClickListener() {
//            //calendar Constraint Builder 선택할수있는 날짜 구간설정
//            val calendarConstraintBuilder = CalendarConstraints.Builder()
//            //오늘 이후만 선택가능하게 하는 코드
//            calendarConstraintBuilder.setValidator(DateValidatorPointForward.now())
//            //오늘 이전만 선택가능하게 하는 코드
//            //calendarConstraintBuilder.setValidator(DateValidatorPointBackward.now())
//
//
//            val builder = MaterialDatePicker.Builder.datePicker()
//                .setTitleText("Set Dieday")
//                .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
//
//                //위에서 만든 calendarConstraint을 builder에 설정해줍니다.
//                .setCalendarConstraints(calendarConstraintBuilder.build());
//
////아래부터는 목표1 코드방식과 동일합니다.
//
//            val datePicker = builder.build()
//
//            datePicker.addOnPositiveButtonClickListener {
//                val calendar = Calendar.getInstance()
//                calendar.time = Date(it)
//                val calendarMilli = calendar.timeInMillis
//                calanderButton_create2.text = "${calendar.get(Calendar.MONTH) + 1}/${calendar.get(Calendar.DAY_OF_MONTH)}/${calendar.get(Calendar.YEAR)}"
//
//                //sharedPreference
//                editor.putLong("Die_Millis", calendarMilli)
//                editor.apply()
//                Log.d("Die_Millis", "$calendarMilli")
//            }
//            datePicker.show(supportFragmentManager,datePicker.toString())
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