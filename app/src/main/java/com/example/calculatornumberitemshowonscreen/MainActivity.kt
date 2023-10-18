package com.example.calculatornumberitemshowonscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var mAdapter: MainAdapter
    private lateinit var rv: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showItem()
    }

    private fun showItem() {
        mAdapter = MainAdapter()
        for (i in 0 until 5) {
            mAdapter.listItem.add(Item("name name name name name name $i"))
        }

        rv = findViewById(R.id.rv)
        rv.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            adapter = mAdapter
        }

    }
}