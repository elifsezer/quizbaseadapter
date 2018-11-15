package com.example.esezer.quizbaseadapter

import android.content.DialogInterface
import android.content.res.ColorStateList
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.tek_satir.*

class MainActivity : AppCompatActivity() {
    lateinit var tumSoruBilgileri: ArrayList<Question>
    var toplamDogruSayisi: Int = 0
    var suankisoruindexi: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        veriKaynagiHazirla()
        var myBaseAdapter = SorularBaseAdapter(this, tumSoruBilgileri)
        listsoru.adapter=myBaseAdapter
    }

    fun cevaplari_goster(cevapID: Int) {
        var soru = tumSoruBilgileri.get(suankisoruindexi)
        rbutton1.setTextColor(Color.GREEN)
        if (soru.dogruCevap(cevapID)) {
            Toast.makeText(this, "Dogru", Toast.LENGTH_SHORT).show()
            toplamDogruSayisi++

        }
        else
        {
            Toast.makeText(this,"Yanlış",Toast.LENGTH_SHORT).show()
        }
        btnhesapla.setOnClickListener {
            sonucGoster()
        }

        }

    fun sonucGoster()

    {
        var alert=AlertDialog.Builder(this)
        alert.setTitle("Sonuc")
        alert.setMessage("Tebrikler Dogru Sayısı : "+toplamDogruSayisi)
        alert.setPositiveButton("Ok")
        {
            dialogInterface: DialogInterface?, i: Int ->
            finish()
        }
        alert.show()
    }

    fun radiobutton_1(view: View) {
        cevaplari_goster(1)


    }

    fun radiobutton_2(view: View) {

        cevaplari_goster(2)
    }

    fun radiobutton_3(view: View) {

        cevaplari_goster(3)

    }

        private fun veriKaynagiHazirla() {
        tumSoruBilgileri = ArrayList<Question>()
        tumSoruBilgileri.add(Question("Canlılar için gerekli gazların karışımı dünyanın hangi bölümünde yer alır?", "Su", "Kara", "Hava", 1))
        tumSoruBilgileri.add(Question("Yağmur, kar gibi olaylar dünyanın hangi tabakasında meydana gelir?", "Hava", "Su", "Kara", 1))


    }
}






