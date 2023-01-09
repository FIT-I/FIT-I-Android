package com.example.fit_i

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fit_i.databinding.ActivityReviewBinding

class ReviewActivity:AppCompatActivity() {
    private lateinit var binding : ActivityReviewBinding
    private val data:MutableList<ReviewData> = mutableListOf()
    var i = 5
    override fun onCreate(savedInstanceState:Bundle?){
        super.onCreate(savedInstanceState)
        binding=ActivityReviewBinding.inflate(layoutInflater)
        val view = R.layout.activity_review
        setContentView(view)

//        initialize()
        refreshRecyclerView()



    }
}
//private fun initialize(){
//    with(data){
//        add(ReviewData(""))
//    }


private fun refreshRecyclerView(){
    val adapter = ReviewAdapter()
//    adapter.listData = ReviewData

}