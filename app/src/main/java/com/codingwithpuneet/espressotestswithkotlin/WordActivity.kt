package com.codingwithpuneet.espressotestswithkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.codingwithpuneet.espressotestswithkotlin.databinding.ActivityWordBinding

class WordActivity : AppCompatActivity() {
    lateinit var activityWordBinding: ActivityWordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityWordBinding = DataBindingUtil.setContentView(this, R.layout.activity_word)
        activityWordBinding.buttonSave.setOnClickListener {
            Toast.makeText(this, "Word Saved!", Toast.LENGTH_LONG).show()
        }
    }
}