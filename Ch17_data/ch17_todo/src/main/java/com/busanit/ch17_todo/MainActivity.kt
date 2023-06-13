package com.busanit.ch17_todo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.busanit.ch17_todo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

  /* 전역 변수 모음 */

  lateinit var binding : ActivityMainBinding
  lateinit var adapter : MyAdapter
  var datas : MutableList<String>? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    // xml 파일을 연결
    binding = ActivityMainBinding.inflate(layoutInflater)
    // 뷰를 연결한 xml 파일로 채우겠다.
    setContentView(binding.root)

    setSupportActionBar(binding.toolbar)



    // 입력 - AddActivity에서 구현

    val requestLauncher = registerForActivityResult(
      ActivityResultContracts.StartActivityForResult()
    ){
      it.data?.getStringExtra("result")?.let {
        datas?.add(it)
        adapter.notifyDataSetChanged()
      }
    }

    val mainFab = binding.mainFab
    mainFab.setOnClickListener {
      val intent = Intent(this, AddActivity::class.java)
      requestLauncher.launch(intent)
    }

    // 삭제, 수정 - MyAdapter 에서 구현

  }

  /* 다시 앱으로 돌아올 때 무조건 호출 되는 메소드 */
  override fun onResume() {
    super.onResume()

    // select, DB에서 데이터 가져오기
    datas = mutableListOf()
    val db = DBHelper(this).readableDatabase
    val cursor = db.rawQuery("select * from TODO_TB", null)
    cursor.run {
      while (moveToNext()){
        datas?.add(cursor.getString(1))
      }
    }

    db.close()
    // 받아온 데이터로 리사이클러뷰  화면 구성

    val mainRecyclerView = binding.mainRecyclerView
    mainRecyclerView.layoutManager = LinearLayoutManager(this)
    adapter = MyAdapter(datas!!)
    mainRecyclerView.adapter = adapter
    mainRecyclerView.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL)) // 구분 선 넣는 것
  }
}