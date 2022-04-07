package com.axinpz.proyectosegundoparcial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import java.lang.IllegalArgumentException

class MainActivity : AppCompatActivity(), View.OnClickListener  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnColorGen = findViewById<Button>(R.id.btn_color_gen)
        val btnMichiGen = findViewById<Button>(R.id.btn_michi_gen)
        val btnLatestAnime = findViewById<Button>(R.id.btn_anime)
        val btnPlayVideo = findViewById<Button>(R.id.btn_play)

        btnColorGen.setOnClickListener(this)
        btnMichiGen.setOnClickListener(this)
        btnLatestAnime.setOnClickListener(this)
        btnPlayVideo.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        val intent = when(view.id){
            R.id.btn_color_gen -> Intent(this, colorGeneratorActivity::class.java)
            R.id.btn_michi_gen -> Intent(this, MichiGeneratorActivity::class.java)
            R.id.btn_anime -> Intent(this, LatestAnimeActivity::class.java)
            R.id.btn_play -> Intent(this, PlayVideoActivity::class.java)
            else -> throw IllegalArgumentException("Invalid Action")
        }
        startActivity(intent)
    }
}