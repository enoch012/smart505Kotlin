package com.busanit.ch28_event

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import android.widget.CompoundButton
import androidx.activity.OnBackPressedCallback
import com.busanit.ch28_event.databinding.ActivityMainBinding
import kotlin.math.log

// 4-3. 이벤트 핸들러를 별도 클래스 만들기
class MyEventHandler : CompoundButton.OnCheckedChangeListener{
  override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
   Log.d("mylog", "체크박스를 클릭했습니다.")
  }
}

// 4-2. setOnChecked~ 두번째 방법, 액티비티에서 인터페이스를 구현(224p)

/*class MainActivity : AppCompatActivity(), CompoundButton.OnCheckedChangeListener {*/
class MainActivity : AppCompatActivity(){


  // 3. onBackPressed 백버튼 전용 이벤트 함수
  /*override fun onBackPressed() {
    Log.d("myLog", "BacK Button을 눌렀네요!")
    // super.onBackPressed() // 조건이 되면 동작하도록 함
  }*/

  // 3-1. 뒤로가기 구현 최신(onBackPressedCallback)

  val callback = object : OnBackPressedCallback(true) {
    override fun handleOnBackPressed() {
      Log.d("myLog", "Back 버튼을 눌렀네요.")
      finish() // 뒤로가기 버튼을 활성화 시키는 명령어가 간단해졌당
    }
  }


  // 4-2.
  /*override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
    Log.d("my Log", "체크박스 클릭햇어여")
  }*/

  override fun onCreate(savedInstanceState: Bundle?){
    super.onCreate(savedInstanceState)
    /* 코드와 메인 바인딩을 연결시켜줌 */
    val binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    val checkBox = binding.checkbox
    // 4-1. OnCheckedChangeListener (자바 방식), 체크박스가 여러 개일 때 쓰는 방법
    // 이벤트 소스 : 이벤트가 발생한 객체
    // 이벤트 핸들러 : 이벤트 발생 시 실행할 로직이 구현된 객체(익명 객체 object)
    // 리스너 : 이벤트 소스와 핸들러를 연결 (setOnCheckedChangeListener)

    /*checkBox.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener{
      override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        Log.d("myLog", "체크박스 클릭")
      }
    })*/

    // 4-4. SAM 기법 : override 메서드가 하나일 때, 일반적인 사용방법\
    // 함수명 뒤에 () 없이 바로 {}
    binding.checkbox.setOnCheckedChangeListener{
      // compoundButton 눌러진 체크박스 정보
      compoundButton, b -> Log.d("myLog", "체크박스 클릭 : $b")
    }

    // 4-2
    //binding.checkbox.setOnCheckedChangeListener(this)

    // 4-3. 이벤트 핸들러를 별도 클래스로 만드는 법
    // checkBox.setOnCheckedChangeListener(MyEventHandler()) // 클래스 생성자로 넣어줘야함

    // 3-1. onBackPressedCallback 관련
    this.onBackPressedDispatcher.addCallback(this, callback)

    // 5-1. Button 클릭 이벤트 자바 방식

    val button = binding.button

    /*
    button.setOnClickListener(object : View.OnClickListener{
      override fun onClick(v: View?) {
        Log.d("myLog", "버튼 클릭1")
      }
    })*/

    // 5-2. 클릭 이벤트 SAM기법 사용
    button.setOnClickListener {
      Log.d("myLog", "버튼 클릭2")
    }

    // 5-3. 롱클릭 이벤트
    button.setOnLongClickListener{
      Log.d("myLog", "버튼 롱클릭1")
      true// true일 경우 버튼 클릭과 롱 클릭을 구분한다. false일 경우 클릭 후 뗄 때 onClick 이벤트 발생
    }

  }


  // 2. Key 이벤트
  override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
    when(keyCode){
      KeyEvent.KEYCODE_BACK -> Log.d("myLog", "Back Button을 눌렀습니다!")
      KeyEvent.KEYCODE_VOLUME_UP -> Log.d("myLog", "Volume Up 키를 눌렀습니다.")
    }
    return super.onKeyDown(keyCode, event)
  }

  override fun onKeyUp(keyCode: Int, event: KeyEvent?): Boolean {
    when(keyCode){
      KeyEvent.KEYCODE_BACK -> Log.d("myLog", "Back Button, Key Up event.")
      KeyEvent.KEYCODE_VOLUME_UP -> Log.d("myLog", "Volume Up, Key Up event.")
    }
    return super.onKeyUp(keyCode, event)
  }

  // 1. touch 이벤트가 발생했을 때
  override fun onTouchEvent(event: MotionEvent?): Boolean {
    when(event?.action){
      MotionEvent.ACTION_DOWN -> {
        // 누르는 터치라면 아래의 행동을 하시오
        // x, rawX : 터치 이벤트가 걸린 뷰에서의 좌표, rawX는 전체화면에서의 좌표
        Log.d("my Logdown", "touch down event : ${event.x},rawX : ${event.rawX}")
      }
      MotionEvent.ACTION_UP -> {
        Log.d("my Logup", "Touch Up event")
      }
      MotionEvent.ACTION_MOVE -> {
        // 누르고 움직였을 때 계속 변화는 좌표 값을 Logcat에서 출력해준다
        Log.d("myLog", "Touch move event : ${event.x}")
      }
    }
    return super.onTouchEvent(event)
  }


}