package com.example.esezer.quizbaseadapter

import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.ArrayAdapter
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
        listsoru.adapter = myBaseAdapter
        btnhesapla.setOnClickListener {
            if (suankisoruindexi>=tumSoruBilgileri.size)
            {
                sonucGoster()
            }
        }


    }

    fun cevaplari_goster(cevapID: Int) {
        var soru = tumSoruBilgileri.get(suankisoruindexi)
        if (soru.dogruCevap(cevapID)) {
            toplamDogruSayisi++
            Toast.makeText(this, "Dogru", Toast.LENGTH_SHORT).show()
        }
        else
            Toast.makeText(this,"Yanlış",Toast.LENGTH_SHORT).show()
        suankisoruindexi++
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
        tumSoruBilgileri.add(Question("Canlılar için gerekli gazların karışımı dünyanın hangi bölümünde yer alır?", "Su", "Kara", "Hava", 3))
        tumSoruBilgileri.add(Question("Yağmur, kar gibi olaylar dünyanın hangi tabakasında meydana gelir?", "Hava", "Su", "Kara", 1))
        tumSoruBilgileri.add(Question("Aşağıda verilen ifadelerden hangisi yanlıştır?", "Dünya katmanlardan oluşur.", "Küre şeklindedir.", "4'te 1'ini denizler oluşturur.", 3))
        tumSoruBilgileri.add(Question("Dünyamızı oluşturan tabakalardan en içte hangisi yer alır?", "Su tabakası", "Taş tabakası", "Hava tabakası", 3))

    }
}






