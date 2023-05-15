package com.busanit.ch06_view

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.busanit.ch06_view.databinding.ActivityMainBinding
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val binding = ActivityMainBinding.inflate(layoutInflater) // 뷰바인딩
    setContentView(binding.root) // 뷰바인딩

    // setContentView(R.layout.activity_main)
    // 2. activity_main.xml 에서 화면 구성
    // 4. 뷰 바인딩 기법 사용(bulid.gradle Module:app)

    val btn1 = binding.btn1
    val btn2 = binding.btn2
    val imgView = binding.imgView


    // 3. 버튼 기능 구현
    /*val btn1 : Button = findViewById(R.id.btn1)
    val btn2 = findViewById<Button>(R.id.btn2)
    val imgView : ImageView = findViewById(R.id.imgView)*/

    btn1.setOnClickListener {
      imgView.visibility = View.VISIBLE
    }

    btn2.setOnClickListener {
      imgView.visibility = View.INVISIBLE // 이미지가 들어갈 공간은 남겨둠
      // imgView.visibility = View.GONE // 공간까지 사라짐
    }

    // TextView에 marquee 효과 설정 (흘러가는 텍스트)
    var marqueeText = binding.marqueeText
    marqueeText.isSelected = true


    // 1. 소스코드에서 화면 구성
    /*val name = TextView(this).apply {
      typeface = Typeface.DEFAULT_BOLD
      text = "Lake Louise"
    }
    // apply : 해당 객체의 속성을 바로 설정
    // name.typeface = ... name.text = ... // 원래 이렇게 써야하는데

    // 사진 보여줄 이미지 뷰 생성
    val image = ImageView(this).also {
      it.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.lake_1))
      it.adjustViewBounds = true // 축소할 때 비율에 맞게 가로, 세로 축소
    }
    // 주소 보여줄 텍스트뷰 생성
    val address = TextView(this).apply {
      typeface = Typeface.DEFAULT_BOLD
      text = "Lake Louise, AB, Canada"
    }
    // 뷰를 배치할 리니어 레이아웃 생성
    val layout = LinearLayout(this).apply {
      orientation = LinearLayout.VERTICAL // 방향
      gravity = Gravity.CENTER
      addView(name, WRAP_CONTENT, WRAP_CONTENT)
      addView(image, WRAP_CONTENT, WRAP_CONTENT)
      addView(address, WRAP_CONTENT, WRAP_CONTENT)
    }

    setContentView(layout) // 리니어 레이아웃을 화면에 출력*/
  }
}