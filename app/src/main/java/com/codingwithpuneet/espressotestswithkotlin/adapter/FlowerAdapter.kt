package com.codingwithpuneet.espressotestswithkotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.codingwithpuneet.espressotestswithkotlin.R

class FlowerAdapter(private var flowerList: Array<String>, private val onItemClick: (word:String)-> Unit):
    RecyclerView.Adapter<FlowerAdapter.ViewHolder>() {

    fun setData(flowerListData: Array<String>){
        val diff = calculateDiff(flowerList, flowerListData)
        flowerList = flowerListData
        diff.dispatchUpdatesTo(this)
        //notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.tvFlower)
    }


    override fun getItemCount(): Int = flowerList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.flower_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = flowerList[position]
        holder.textView.text = item

        holder.itemView.setOnClickListener{
            onItemClick((flowerList[position]))
        }
    }

    private fun calculateDiff(before: Array<String>, after: Array<String>): DiffUtil.DiffResult{
        return DiffUtil.calculateDiff(object : DiffUtil.Callback() {
            override fun getOldListSize() = before.size

            override fun getNewListSize() = after.size

            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return before[oldItemPosition] == after[newItemPosition]
            }

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return false
            }
        })
    }
}