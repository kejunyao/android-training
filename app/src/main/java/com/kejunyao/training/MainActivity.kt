package com.kejunyao.training

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kejunyao.arch.recycler.AdapterData
import com.kejunyao.arch.recycler.OnItemClickListener

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        val itemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        val colorDrawable = ColorDrawable(Color.BLACK)
        itemDecoration.setDrawable(colorDrawable)
        recyclerView.addItemDecoration(itemDecoration)
        val adapter = ActionAdapter()
        adapter.setOnItemClickListener(object : OnItemClickListener<AdapterData<String>> {
            override fun onClick(id: Int, position: Int, data: AdapterData<String>?) {
                ActionBuilder.handleAction(this@MainActivity, data?.type ?: -1, data?.data)
            }

            override fun bindClickIds(): IntArray {
                return intArrayOf(-1)
            }

        })
        adapter.data = ActionBuilder.buildActionData()
        recyclerView.adapter = adapter
    }
}