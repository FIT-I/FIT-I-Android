package com.example.fit_i

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ProfileReviewActivity:AppCompatActivity() {
    //private lateinit var binding: ActivityReviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_review)
//        binding = ActivityReviewBinding.inflate(layoutInflater)

        val rvReview : RecyclerView = findViewById(R.id.rv_review)


        val reviewList : ArrayList<ReviewData> = arrayListOf()

        reviewList.apply {
            add(ReviewData("박윤빈 ","2022.01.11",4.5,"친절한 지도 감사합니다:)"))
            add(ReviewData("노규리 ","2022.01.11",4.5,"좋았어요. 친절하고 잘 가르쳐줬습니다~~~"))
            add(ReviewData("김소연 ","2022.01.11",4.5,"Pt가 처음이라 두려웠지만, 쉽게 접할 수 있어서 좋았습니다."))
            add(ReviewData("박윤빈 ","2022.01.11",4.5,"친절한 지도 감사합니다:)"))
            add(ReviewData("노규리 ","2022.01.11",4.5,"좋았어요. 친절하고 잘 가르쳐줬습니다~~~"))
            add(ReviewData("김소연 ","2022.01.11",4.5,"Pt가 처음이라 두려웠지만, 쉽게 접할 수 있어서 좋았습니다."))
            add(ReviewData("박윤빈 ","2022.01.11",4.5,"친절한 지도 감사합니다:)"))
            add(ReviewData("노규리 ","2022.01.11",4.5,"좋았어요. 친절하고 잘 가르쳐줬습니다~~~"))
            add(ReviewData("김소연 ","2022.01.11",4.5,"Pt가 처음이라 두려웠지만, 쉽게 접할 수 있어서 좋았습니다."))
            add(ReviewData("박윤빈 ","2022.01.11",4.5,"친절한 지도 감사합니다:)"))
            add(ReviewData("노규리 ","2022.01.11",4.5,"좋았어요. 친절하고 잘 가르쳐줬습니다~~~"))
            add(ReviewData("김소연 ","2022.01.11",4.5,"Pt가 처음이라 두려웠지만, 쉽게 접할 수 있어서 좋았습니다."))
        }

        val reviewAdapter = ReviewAdapter(reviewList)
        rvReview.adapter=reviewAdapter

        val linearLayoutManager = LinearLayoutManager(this)
        rvReview.layoutManager=linearLayoutManager
        rvReview.setHasFixedSize(true)

    }

}