package com.axinpz.proyectosegundoparcial

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import java.lang.IllegalArgumentException
import kotlin.random.Random

class colorGeneratorActivity : AppCompatActivity(), View.OnClickListener {

    var layout: ConstraintLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color_generator)

        val btnRandomColor = findViewById<Button>(R.id.btn_random_color)
        layout = findViewById<ConstraintLayout>(R.id.color_layout)

        btnRandomColor.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        val random = Random.nextInt(0, 256)

        val color = Color.rgb(Random.nextInt(256), Random.nextInt(256), Random.nextInt(256))
        layout?.setBackgroundColor(color)
    }
}