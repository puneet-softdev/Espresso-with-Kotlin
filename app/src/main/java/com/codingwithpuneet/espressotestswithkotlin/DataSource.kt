package com.codingwithpuneet.espressotestswithkotlin

import android.content.Context

class DataSource(private val context: Context) {
    fun getFlowerList(): Array<String> {
        return context.resources.getStringArray(R.array.flower_array)
    }

    fun getFruitsList(): Array<String> {
        return context.resources.getStringArray(R.array.fruits_array)
    }
}