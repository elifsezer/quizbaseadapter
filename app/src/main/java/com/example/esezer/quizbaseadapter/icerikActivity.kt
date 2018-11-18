package com.example.esezer.quizbaseadapter

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_icerik.*

class icerikActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_icerik)
        button1.setOnClickListener {
            fen_bilimleri()
        }

    }

    fun fen_bilimleri()
    {
        var intent=Intent(applicationContext,MainActivity::class.java)
        startActivity(intent)
    }

}
