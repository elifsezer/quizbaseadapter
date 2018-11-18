package com.example.esezer.quizbaseadapter

import android.content.DialogInterface
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import com.tapadoo.alerter.Alert
import com.tapadoo.alerter.Alerter
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.tek_satir.*
import java.sql.Time
import java.util.concurrent.TimeUnit

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

        object:CountDownTimer(180000,1000)
        {
            override fun onFinish() {
                sonucGoster()
            }
            override fun onTick(millisUntilFinished: Long) {
                tvsure.setText(String.format("%d : %d ",
                    TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished),
                    TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished)-
                            TimeUnit.MINUTES.toSeconds
                                (TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))))
            }

        }.start()
    }

    fun cevaplari_goster(cevapID: Int) {
        var soru = tumSoruBilgileri.get(suankisoruindexi)
        if (soru.dogruCevap(cevapID)) {
            Toasty.success(this, "Doğru Cevap!", Toast.LENGTH_SHORT, true).show()
                    toplamDogruSayisi++
        } else {
            Toasty.error(this, "Yanlış Cevap", Toast.LENGTH_SHORT,true).show()
        }
        btnhesapla.setOnClickListener {
            sonucGoster()
        }

    }

    fun sonucGoster() {
        Alerter.create(this@MainActivity).setTitle("Sonuc").setText("Dogru Cevap Sayısı :" + toplamDogruSayisi).setBackgroundColorRes(R.color.colorPrimaryDark).setOnClickListener(View.OnClickListener { anasayfa() }).show()
        Alerter.isShowing
        Alerter.isShowing
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
        tumSoruBilgileri = ArrayList<Question>(8)
        tumSoruBilgileri.add(Question("Dünyanın şekli aşağıdaki meyvelerden hangisine benzer?", "Portakal", "Kivi", "Ayva", 1))
        tumSoruBilgileri.add(Question("Aşağıda verilen ifadelerden hangisi doğrudur?", "Dünyanın büyük bölümü karalarla kaplıdır.", "Dünyanın büyük bölümü denizlerle kaplıdır.", "Dünyada yaşam sadece karadadır.", 2))
        tumSoruBilgileri.add(Question("Canlılar için gerekli gazların karışımı dünyanın hangi bölümünde yer alır?", "Su", "Kara", "Hava", 3))
        tumSoruBilgileri.add(Question("Canlılar için gerekli gazların karışımı dünyanın hangi bölümünde yer alır?", "Pisagor", "Aristo", "Kristof Kolomb", 1))
        tumSoruBilgileri.add(Question("Dünyamızın 4'te 3'ünü aşağıdakilerden hangisi oluşturur?", "Kara", "Su", "Hava", 2))
        tumSoruBilgileri.add(Question("Dünya' nın çevresini gemiyle dolaşarak Dünya' nın yuvarlak olduğunu ispatlayan kişi kimdir ?", "Aristo", "Pisagor", "Kristof Kolomb", 3))
        tumSoruBilgileri.add(Question("Yağmur, kar gibi olaylar dünyanın hangi tabakasında meydana gelir?", "Hava", "Su", "Kara", 1))
        tumSoruBilgileri.add(Question("Aşağıda verilen ifadelerden hangisi yanlıştır?", "Dünya katmanlardan oluşur.", "Küre şeklindedir.", "4'te 1'ini denizler oluşturur.", 3))
    }
    fun anasayfa()
    {
        var intent= Intent(applicationContext,icerikActivity::class.java)
        startActivity(intent)
    }
}






