package com.codingwithpuneet.espressotestswithkotlin

import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.commit
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.codingwithpuneet.espressotestswithkotlin.adapter.FlowerAdapter
import com.codingwithpuneet.espressotestswithkotlin.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var timePickerDialog: TimePickerDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setSupportActionBar(activityMainBinding.toolbar)
        setUpClickListeners()
        setUpFlowersRvFromStringArray()
    }

    private fun setUpClickListeners() {
        activityMainBinding.btnLaunchNewActivity.setOnClickListener {
            val intent = Intent(this, WordActivity::class.java)
            startActivity(intent)
        }

        activityMainBinding.btnAlarm.setOnClickListener {
            openTimePickerDialog()
        }

        activityMainBinding.fab.setOnClickListener {
            val intent = Intent(this, WordActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setUpFlowersRvFromStringArray() {
        activityMainBinding.rvFlowers.layoutManager = GridLayoutManager(this, 2)
        val flowersList = DataSource(this).getFlowerList()
        val adapter = FlowerAdapter(flowersList, onItemClick)
        activityMainBinding.rvFlowers.adapter = adapter
    }

    private fun openTimePickerDialog() {
        val calender: Calendar = Calendar.getInstance()


        val onTimeSetListener = TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
            val calNow = Calendar.getInstance()
            val calSet = calNow.clone() as Calendar
            calSet[Calendar.HOUR_OF_DAY] = hourOfDay
            calSet[Calendar.MINUTE] = minute
            calSet[Calendar.SECOND] = 0
            calSet[Calendar.MILLISECOND] = 0
            if (calSet.compareTo(calNow) <= 0) {
                calSet.add(Calendar.DATE, 1)
            }
            //setAlarm(calSet)
        }


        timePickerDialog = TimePickerDialog(
            this,
            onTimeSetListener,
            calender.get(Calendar.HOUR_OF_DAY),
            calender.get(Calendar.MINUTE),
            false)

        //timePickerDialog.setTitle("Set Alarm Time")
        timePickerDialog.show()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId == R.id.search) {
            Toast.makeText(this, "Search Clicked!", Toast.LENGTH_LONG).show()
            true
        } else {
            return super.onOptionsItemSelected(item)
        }
    }

    private val onItemClick: (word: String) -> Unit = { word: String ->
        Toast.makeText(this, "Selected Word: $word", Toast.LENGTH_LONG).show()
    }

}