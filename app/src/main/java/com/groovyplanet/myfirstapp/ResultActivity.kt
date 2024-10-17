package com.groovyplanet.myfirstapp

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.groovyplanet.myfirstapp.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding : ActivityResultBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var name = intent.getStringExtra("name")
        var collectCnt = intent.getIntExtra("collectCnt",0)


        if(collectCnt == 10){
            binding.top.visibility = View.VISIBLE // 10점 일 때 top 이미지 보이기
            binding.fuck.visibility = View.GONE       // fuck 이미지 숨기기
            binding.middle.visibility = View.GONE    // 다른 이미지 숨기기
            binding.resultTv.text = "이름: ${name} \n 총 ${collectCnt} 문제 정답입니다 \n 100점 입니다."
        }

        else if (collectCnt <= 6) {
            binding.fuck.visibility = View.VISIBLE  // 6점 이하일 때 fuck 이미지 보이기
            binding.middle.visibility = View.GONE    // 다른 이미지 숨기기
            binding.resultTv.text = "이름: ${name} \n 총 ${collectCnt} 문제 정답입니다 \n 불합격입니다."

        } else  {
            binding.middle.visibility = View.VISIBLE  // 6점 초과일 때 중간 이미지 보이기
            binding.fuck.visibility = View.GONE       // fuck 이미지 숨기기
            binding.resultTv.text = "이름: ${name} \n 총 ${collectCnt} 문제 정답입니다"
        }

        binding.resertBtn.setOnClickListener{
            finish()
        }



    }
}