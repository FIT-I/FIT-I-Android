package com.example.fit_i.ui.profile.review

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fit_i.*
import com.example.fit_i.data.model.response.GetReviewListResponse
import com.example.fit_i.data.service.CommunalService
import com.example.fit_i.databinding.ActivityReviewBinding
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.charts.Chart
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.ValueFormatter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import kotlin.collections.ArrayList


class ProfileReviewActivity:AppCompatActivity() {
    /*
    private lateinit var binding: ActivityReviewBinding
    //private val trainerIdx =intent.getLongExtra("reviewIdx",-1)

    //private val trainerIdx : Long = 2
    val MAX_X_VALUE = 100
    val MAX_Y_VALUE = 1
    val MIN_Y_VALUE = 0
    val SET_LABEL= "revuew"
    private var chart: BarChart = findViewById(R.id.chart)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReviewBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val rvReview : RecyclerView = findViewById(R.id.rv_review)

        val reviewList : ArrayList<Review> = arrayListOf()

        //lodeData()

        chart = findViewById(R.id.chart2)


        val entries = listOf(
            BarEntry(0f, 10f),
            BarEntry(1f, 20f),
            BarEntry(2f, 30f),
            BarEntry(3f, 40f),
            BarEntry(4f, 50f),
            BarEntry(5f, 60f),
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
/*
        reviewList.apply {
            add(Review("박윤빈 ","2022.01.11",4.5,"좋았어요. 친절하고 잘 가르쳐줬습니다~~~"))
            add(Review("노규리 ","2022.01.11",4.5,"좋았어요. 친절하고 잘 가르쳐줬습니다~~~"))
            add(Review("김소연 ","2022.01.11",4.5,"Pt가 처음이라 두려웠지만, 쉽게 접할 수 있어서 좋았습니다."))
            add(Review("박윤빈 ","2022.01.11",4.5,"친절한 지도 감사합니다:)"))
            add(Review("노규리 ","2022.01.11",4.5,"좋았어요. 친절하고 잘 가르쳐줬습니다~~~"))
            add(Review("김소연 ","2022.01.11",4.5,"Pt가 처음이라 두려웠지만, 쉽게 접할 수 있어서 좋았습니다."))
            add(Review("박윤빈 ","2022.01.11",4.5,"친절한 지도 감사합니다:)"))
            add(Review("노규리 ","2022.01.11",4.5,"좋았어요. 친절하고 잘 가르쳐줬습니다~~~"))
            add(Review("김소연 ","2022.01.11",4.5,"Pt가 처음이라 두려웠지만, 쉽게 접할 수 있어서 좋았습니다."))
            add(Review("박윤빈 ","2022.01.11",4.5,"친절한 지도 감사합니다:)"))
            add(Review("노규리 ","2022.01.11",4.5,"좋았어요. 친절하고 잘 가르쳐줬습니다~~~"))
            add(Review("김소연 ","2022.01.11",4.5,"Pt가 처음이라 두려웠지만, 쉽게 접할 수 있어서 좋았습니다."))
        }*/

    }
    private fun setAdapter(result: List<GetReviewListResponse.Result>) {
        val previewAdapter = PReviewAdapter(result)
        binding.rvReview.adapter=previewAdapter

        val linearLayoutManager = LinearLayoutManager(this)
        binding.rvReview.layoutManager=linearLayoutManager
        binding.rvReview.setHasFixedSize(true)

    }

    private fun lodeData() {
        val commmunalService = RetrofitImpl.getApiClient().create(CommunalService::class.java)
        commmunalService.getReviewList(intent.getLongExtra("reviewIdx",-1)).enqueue(object :
            Callback<GetReviewListResponse> {
            override fun onResponse(call: Call<GetReviewListResponse>, response: Response<GetReviewListResponse>) {
                if(response.isSuccessful){
                    // 정상적으로 통신이 성공된 경우
                    //onBind(response.body()!!.result)
                    Log.d("post", "onResponse 성공: " + response.body().toString());
                    //Toast.makeText(this@ProfileActivity, "비밀번호 찾기 성공!", Toast.LENGTH_SHORT).show()

                    val body = response.body()
                    body?.let {
                        setAdapter(it.result)
                    }
                }else{
                    // 통신이 실패한 경우(응답코드 3xx, 4xx 등)
                    Log.d("post", "onResponse 실패")
                }
            }

            override fun onFailure(call: Call<GetReviewListResponse>, t: Throwable) {
                // 통신 실패 (인터넷 끊킴, 예외 발생 등 시스템적인 이유)
                Log.d("post", "onFailure 에러: " + t.message.toString());
            }
        })
    }*/

}

