package com.axinpz.proyectosegundoparcial

import android.app.DatePickerDialog
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import java.text.SimpleDateFormat
import java.util.*
import kotlin.random.Random

class colorGeneratorActivity : AppCompatActivity(), View.OnClickListener {

    var layout: ConstraintLayout? = null

    private var txtVBD: TextView? = null
    private var btnBD: Button? = null
    private var btnBDColor: Button? = null

    private var txtVRGBVals: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color_generator)

        txtVBD = findViewById(R.id.txtV_BD)
        btnBD = findViewById(R.id.btn_setBD)
        btnBDColor = findViewById(R.id.btn_BDColor)
        txtVRGBVals = findViewById(R.id.txtV_rgb_vals)

        val myCalendar = Calendar.getInstance()
        val datePicker = DatePickerDialog.OnDateSetListener{view, year, month, dayOfMonth ->
            myCalendar.set(Calendar.YEAR, year)
            myCalendar.set(Calendar.MONTH, month)
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateLabel(myCalendar)
        }

        val btnRandomColor = findViewById<Button>(R.id.btn_random_color)
        layout = findViewById<ConstraintLayout>(R.id.color_layout)

        btnRandomColor.setOnClickListener(this)

        btnBD?.setOnClickListener{
            DatePickerDialog(this, datePicker, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show()
        }

        btnBDColor?.setOnClickListener{
            val redCom = myCalendar.get((Calendar.DAY_OF_MONTH)) * 8
            val greenCom = myCalendar.get((Calendar.MONTH)) * 19
            val blueCom = (((myCalendar.get((Calendar.YEAR))) - 1000) / 8) + 25

            val bdColor = Color.rgb(redCom, greenCom, blueCom)
            layout?.setBackgroundColor(bdColor)
            txtVRGBVals?.setText(redCom.toString() + ", " + greenCom.toString() + ", " + blueCom.toString())
            updateLabel(myCalendar)
        }
    }

    private fun updateLabel(myCalendar: Calendar) {
        val myFormat = "dd-MM-yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale.US)
        txtVBD?.setText(sdf.format(myCalendar.time))
    }

    override fun onClick(view: View) {
        val redCom = Random.nextInt(256)
        val greenCom = Random.nextInt(256)
        val blueCom = Random.nextInt(256)
        val color = Color.rgb(redCom, greenCom, blueCom)
        layout?.setBackgroundColor(color)
        txtVRGBVals?.setText(redCom.toString() + ", " + greenCom.toString() + ", " + blueCom.toString())
    }
}