package com.example.tymotsko

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main3.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        val formate = SimpleDateFormat("dd MMM, YYYY", Locale.US)
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
                        "SALE is active to\nYear : " + i + "\nMonth: " + i2 + "\nDate: " + i3,
                        Toast.LENGTH_SHORT
                    ).show()
                },
                now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH)
            )
            datePicker.show()
        }

    }
}