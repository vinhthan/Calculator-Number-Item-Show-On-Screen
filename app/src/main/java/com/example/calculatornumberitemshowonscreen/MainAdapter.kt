package com.example.calculatornumberitemshowonscreen

import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class MainAdapter: RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
    var listItem = mutableListOf<Item>()

    private var screenWidth = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)

        val displayMetrics = DisplayMetrics()
        (parent.context as MainActivity).windowManager.defaultDisplay.getMetrics(displayMetrics)
        screenWidth = displayMetrics.widthPixels - 20 - 20 - 20

        return MainViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listItem.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(listItem[position])

        //calculator number item
        val itemWidth = when(listItem.size) {
            1 -> screenWidth / 1
            2 -> screenWidth / 2
            3 -> screenWidth / 3
            4 -> screenWidth / 4
            else -> screenWidth / 5
        }
        val lp = holder.layoutItem.layoutParams
        lp.height = lp.height
        lp.width = itemWidth
        holder.itemView.layoutParams = lp
    }

    class MainViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val layoutItem = itemView.findViewById<ConstraintLayout>(R.id.layout_item)
        val tv = itemView.findViewById<TextView>(R.id.tv)
        fun bind(item: Item) {
            tv.text = item.name
        }
    }
}