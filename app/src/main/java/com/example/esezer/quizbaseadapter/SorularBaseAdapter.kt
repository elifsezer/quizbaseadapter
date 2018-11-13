package com.example.esezer.quizbaseadapter

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.tek_satir.view.*

class SorularBaseAdapter(context: Context) : BaseAdapter() {

    var tumquizs = ArrayList<Question>()
    var toplamDogruSayisi: Int = 0 //doğru cevap sayısı
    var suankisoruindexi: Int = 0 //sınav sorularının indexi atamak için degisken ürettik.
    var context: Context

    init {
        tumquizs = ArrayList<Question>()
        this.context = context
        tumquizs.add(Question("Dünyanın şekli aşağıdaki meyvelerden hangisine benzer?", "ayva", "marul", "kavun", 1))
        tumquizs.add(Question("'' surprised / I / feel '' Verilen kelimelerin doğru sıralanışı hangi seçenekte verilmiştir?  ", "I surprised feel.", "Feel I suprised.", "I feel suprised.", 3)
        )

    }

    //listeki her bir eleman oluşturulurken tetiklenen her bir method.
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var inflater = LayoutInflater.from(context)
        var tek_satir_view = inflater.inflate(R.layout.tek_satir, parent, false)

        tek_satir_view.tv_soru.setText(tumquizs.get(position).Sorular)
        tek_satir_view.rbutton1.setText(tumquizs.get(position).secenek1)
        tek_satir_view.rbutton2.setText(tumquizs.get(position).secenek2)
        tek_satir_view.rbutton3.setText(tumquizs.get(position).secenek3)
        return tek_satir_view

    }

    override fun getItem(position: Int): Any {
        return tumquizs.get(position)
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return tumquizs.size
    }


   fun  cevaplari_goster(cevapID:Int)
   {
       val soru = tumquizs.get(suankisoruindexi)
       if (soru.dogruCevap(cevapID)) {
           toplamDogruSayisi++
           Toast.makeText(context, "Doğru Seçim", Toast.LENGTH_SHORT).show()
       } else {
           Toast.makeText(context, "Yanlış seçim", Toast.LENGTH_SHORT).show()
       }
       suankisoruindexi++
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


}



class Question(var Sorular: String, var secenek1: String, var secenek2: String, var secenek3: String, var sorununDogruCevabi: Int) {

    fun dogruCevap(sorularinNumaralari: Int): Boolean {
        if (sorularinNumaralari == sorununDogruCevabi) {
            return true
        } else return false
    }

}