package com.busanit.ch17_todo

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.busanit.ch17_todo.databinding.ItemRecyclerviewBinding

class MyViewHolder(val binding:ItemRecyclerviewBinding):RecyclerView.ViewHolder(binding.root)

class MyAdapter(val datas : MutableList<String>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

  lateinit var db : DBHelper
  lateinit var context : Context

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
    context = parent.context
    db = DBHelper(context)
    return MyViewHolder(ItemRecyclerviewBinding.inflate(LayoutInflater.from(context), parent, false))
  }

  override fun getItemCount(): Int {
    return datas.size
  }

  override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    val binding = (holder as MyViewHolder).binding
    binding.itemData.text = datas[position]

    // delete

    binding.btnDelete.setOnClickListener {
      val data = binding.itemData.text.toString()
      val delDb = db.writableDatabase
      delDb.execSQL("delete from TODO_TB where todo = ?", arrayOf(data))
      delDb.close()
      // 삭제 후 화면 갱신
      datas.remove(datas[position])

      // context : mainActivity에 보여질 토스트기 때문에 this가 아닌 부모 context가 입력된 변수로 넣어줬다.
      Toast.makeText(context, "삭제되었습니다.", Toast.LENGTH_SHORT).show()

      notifyDataSetChanged()

    }

    // update - UpdateActivity 에서 구현
    binding.btnUpdate.setOnClickListener {
      val intent = Intent(context, UpdateActivity::class.java)
      intent.putExtra("todo", binding.itemData.text.toString())
      context.startActivity(intent)
    }

  }

}