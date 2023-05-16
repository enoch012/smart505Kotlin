package com.busanit.ch10_notification

import android.Manifest
import android.app.Instrumentation.ActivityResult
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import com.busanit.ch10_notification.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    // 1. 매니페스트 파일에 uses-permission 설정

    // 2. 퍼미션 확인
    val status = ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION")

    if (status == PackageManager.PERMISSION_GRANTED){
      Log.d("myLog", "permission granted")
    } else {
      Log.d("myLog", "permission denied")
    }

    /*// 3. 퍼미션 요청하기 ActivityResultLauncher 객체 이용 (registerForActivityResult 메서드 호출해서)
    var requestPermissionLauncher = registerForActivityResult(
      ActivityResultContracts.RequestPermission()
    ){ isGranted ->
      if (isGranted){
        Log.d("myLog", "callback, granted ..")
      } else{
        Log.d("myLog", "callback, denied ..")
      }
    }
    // 요청
    requestPermissionLauncher.launch("android.permission.ACCESS_FINE_LOCATION")*/

    // 4. 복수의 퍼미션 요청하기
    val requestPermissionLauncher = registerForActivityResult( // registerForActivityResult 함수로 ActivityResultLauncher 객체 생성
      ActivityResultContracts.RequestMultiplePermissions() // 변수로 ActivityResultContract 타입 객체와 콜백 함수를 가진다
    ){
      Log.d("myLog", it[android.Manifest.permission.ACCESS_FINE_LOCATION].toString())
      if (it[android.Manifest.permission.ACCESS_FINE_LOCATION] != true ||
        it[android.Manifest.permission.ACCESS_COARSE_LOCATION] != true){
        Log.d("myLod", "callback, denied ...")
      } else {
        Log.d("myLog", "callback, granted ...")
      }
    }
    // 요청, 배열 이용을 이용해 복수의 퍼미션 요청 가능
    requestPermissionLauncher.launch(arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION))

    // 5. 토스트 띄우기
    val btnToast = binding.btnToast
    btnToast.setOnClickListener {
      // Toast.makeText(this, "종료하려면 한번 더 누르세요.", Toast.LENGTH_SHORT).show()
      // 메시지가 보이거나 사라지는 순간 감지해서 특정 로직 수행
      showToast()
    }
  }

  private fun showToast() {
    val toast = Toast.makeText(this, "종료하려면 한번 더 누르세요.", Toast.LENGTH_SHORT)

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R){
      // Toast.Callback 타입의 객치를 익명 객체인 object를 통해 저장, addCallback() 함수에 등록함
      // Toast가 뜨는 순간 자동으로 콜백 객체의 ToastShown 함수가 호출되며, 토스트가 사라지는 순간 onToastHidden 함수가 자동 호출됨
      toast.addCallback(
        object : Toast.Callback(){
          override fun onToastHidden() {
            super.onToastHidden()
            Log.d("myLog", "Toast is gone ...")
          }

          override fun onToastShown() {
            super.onToastShown()
            Log.d("myLog", "Toast shown")
          }
        }
      )
    }
    toast.show()
  }
}