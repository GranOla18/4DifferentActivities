package com.axinpz.proyectosegundoparcial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import kotlin.random.Random

class MichiGeneratorActivity : AppCompatActivity(), View.OnClickListener {

    val images = arrayOf(
        R.drawable.michi1,
        R.drawable.michi2,
        R.drawable.michi3,
        R.drawable.michi4,
        R.drawable.michi5,
        R.drawable.michi6,
        R.drawable.michi7,
        R.drawable.michi8,
        R.drawable.michi9,
        R.drawable.michi10,
    )

    var imageView: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_michi_generator)

        imageView = findViewById<ImageView>(R.id.imageView)
        val btnMichi = findViewById<Button>(R.id.btn_get_michi)

        btnMichi.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        val imageIdx = Random.nextInt(11)
        imageView?.setImageResource(images[imageIdx])
    }
}