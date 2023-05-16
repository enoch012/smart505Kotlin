package com.busanit.ch08_stopwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.KeyEvent
import android.widget.Toast
import com.busanit.ch08_stopwatch.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
  // 앱 종료 관련, 뒤로가기 버튼이 눌려진 시간 계산용 변수
  var initTime = 0L // 값이 계속 바뀔거라 var

  // 크로노미터의 시간 계산용 변수, 멈춘 시간 저장
  var pauseTime = 0L

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    val binding = ActivityMainBinding.inflate(layoutInflater)

    setContentView(binding.root)

    val startBtn = binding.startBtn
    val stopBtn = binding.stopBtn
    val resetBtn = binding.resetBtn
    val chronometer = binding.chronometer

    startBtn.setOnClickListener {

      // 기준 시간 설정 elapsedRealtime() 그때의 시간을 입력해줌
      chronometer.base = SystemClock.elapsedRealtime() + pauseTime
      chronometer.start()

      // 버튼 표시 여부 조정
      stopBtn.isEnabled = true
      resetBtn.isEnabled = true
      startBtn.isEnabled = false
    }

    stopBtn.setOnClickListener {
      // 멈춘 시간 설정 (기준시간 - 현재의 realTime)
      pauseTime = chronometer.base - SystemClock.elapsedRealtime()
      chronometer.stop()

      stopBtn.isEnabled = false
      resetBtn.isEnabled = true
      startBtn.isEnabled = true

    }

    resetBtn.setOnClickListener {
      pauseTime = 0L
      // 기준시간 재설정
      chronometer.base = SystemClock.elapsedRealtime()
      chronometer.stop()

      stopBtn.isEnabled = false
      resetBtn.isEnabled = false
      startBtn.isEnabled = true
    }
  }

  override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
    // back 버튼을 눌렀을 때 처리
    if (keyCode == KeyEvent.KEYCODE_BACK) {
      // 처음 눌렀거나 누른지 3초가 지났을 때 처리
      if(System.currentTimeMillis() - initTime > 3000){
        Toast.makeText(this, "종료하려면 한번 더 누르세요.",
          Toast.LENGTH_SHORT).show()
        initTime = System.currentTimeMillis()
        return true

      }
    }
    return super.onKeyDown(keyCode, event)
  }

}