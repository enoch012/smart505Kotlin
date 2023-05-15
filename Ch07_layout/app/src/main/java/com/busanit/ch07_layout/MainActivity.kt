package com.busanit.ch07_layout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.busanit.ch07_layout.databinding.FrameTest3Binding

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    val binding = FrameTest3Binding.inflate(layoutInflater)
    setContentView(binding.root)

    val button = binding.button
    val imgView = binding.imgView

    button.setOnClickListener {
      // 버튼은 숨기고 이미지는 보이도록 설정
      button.visibility = View.INVISIBLE
      imgView.visibility = View.VISIBLE
    }

    imgView.setOnClickListener {
      // 버튼은 보이고 이미지는 숨기도록 설정
      imgView.visibility = View.INVISIBLE
      button.visibility = View.VISIBLE
    }
  }
}