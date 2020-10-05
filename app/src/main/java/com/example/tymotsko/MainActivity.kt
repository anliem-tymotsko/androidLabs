package com.example.tymotsko

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    val formate = SimpleDateFormat("dd MMM, YYYY", Locale.US)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_date.setOnClickListener {
            val now = Calendar.getInstance()
            val datePicker = DatePickerDialog(
                this, DatePickerDialog.OnDateSetListener { datePicker, i, i2, i3 ->
                    val selectedDate = Calendar.getInstance()
                    selectedDate.set(Calendar.YEAR, i)
                    selectedDate.set(Calendar.MONTH, i2)
                    selectedDate.set(Calendar.DAY_OF_MONTH, i3)
                    val date = formate.format(selectedDate.time)
                    Toast.makeText(
                        this,
                        "Year : " + i + "\nMonth: " + i2 + "\nDate: " + i3,
                        Toast.LENGTH_SHORT
                    ).show()
                },
                now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH)
            )
            datePicker.show()
        }

        btn_time.setOnClickListener {
            val now = Calendar.getInstance()
            val timePicker =
                TimePickerDialog(this, TimePickerDialog.OnTimeSetListener { timePicker, i, i2 ->
                    Toast.makeText(this, "time :" + i + " : " + i2, Toast.LENGTH_SHORT).show()
                }, now.get(Calendar.HOUR_OF_DAY), now.get(Calendar.MINUTE), false)
            timePicker.show()

        }

        btn_activity2.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

    }

    val NAME = "NAME"

    fun onButtonClick(view: View) {

        startActivity(intent)
    }
}