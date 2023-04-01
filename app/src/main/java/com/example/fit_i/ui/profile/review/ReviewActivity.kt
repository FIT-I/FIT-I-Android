package com.example.fit_i.ui.profile.review

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fit_i.R
import com.github.mikephil.charting.charts.HorizontalBarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry

class ReviewActivity : AppCompatActivity() {
    private lateinit var chart: HorizontalBarChart
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review)

        chart = findViewById(R.id.chart)


        val entries = listOf(
            BarEntry(4f, 50f),
            BarEntry(3f, 40f),
            BarEntry(2f, 30f),
            BarEntry(1f, 20f),
            BarEntry(0f, 10f),
        )

        val dataSet = BarDataSet(entries, "Values")
        dataSet.color = Color.BLUE

        val data = BarData(dataSet)
        data.setValueTextSize(16f)

        chart.data = data
        chart.setFitBars(true)
        chart.animateY(1000)
        chart.description.isEnabled = false
        chart.legend.isEnabled = false
        chart.setDrawGridBackground(false)
        chart.setDrawBarShadow(false)
        chart.isDoubleTapToZoomEnabled = false

        chart.description.isEnabled = false
        chart.legend.isEnabled = false

        // x 축 설정
        chart.xAxis.apply {
            setDrawGridLines(false) // 그리드 라인 표시 여부
            setDrawAxisLine(false) // 축 라인 표시 여부
            setDrawLabels(false) // 라벨 표시 여부
        }

        // y 축 설정
        chart.axisLeft.apply {
            setDrawGridLines(false) // 그리드 라인 표시 여부
            setDrawAxisLine(false) // 축 라인 표시 여부
            setDrawLabels(false) // 라벨 표시 여부
            valueFormatter = YAxisFormatter() // Y 축 라벨 포맷터 설정

        }

        chart.axisRight.isEnabled = false // 오른쪽 y 축 비활성화
    }
}