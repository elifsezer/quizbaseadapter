package com.example.esezer.quizbaseadapter

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.main.tek_satir.view.*

class SorularBaseAdapter(context: Context, tumSoruBilgileri:ArrayList<Question>) : BaseAdapter() {

    var tumquizs = ArrayList<Question>()
    var context: Context

    init {
        this.tumquizs=tumSoruBilgileri
        this.context = context
    }

    //listeki her bir eleman oluşturulurken tetiklenen her bir method.
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {

        var viewHolder: ViewHolder
        var tek_satir_view = convertView
        //null ise ögeler ilk defa oluşturuldugunu anlıyoruz. Her seferinde inflate işlemi yapılmıyor.
        if (tek_satir_view == null) {
            var inflater = LayoutInflater.from(context)
            tek_satir_view = inflater.inflate(R.layout.tek_satir, parent, false)
            viewHolder = ViewHolder(tek_satir_view)
            tek_satir_view.tag = viewHolder
        } else {
            viewHolder = tek_satir_view.getTag() as ViewHolder
        }
        viewHolder.sorular.setText(tumquizs.get(position).Sorular)
        viewHolder.secenekler1.setText(tumquizs.get(position).secenek1)
        viewHolder.secenekler2.setText(tumquizs.get(position).secenek2)
        viewHolder.secenekler3.setText(tumquizs.get(position).secenek3)
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
}

class ViewHolder(tek_satir_view: View) {

    var sorular: TextView
    var secenekler1: RadioButton
    var secenekler2: RadioButton
    var secenekler3: RadioButton

    init {
        this.sorular = tek_satir_view.tv_soru
        this.secenekler1 = tek_satir_view.rbutton1
        this.secenekler2 = tek_satir_view.rbutton2
        this.secenekler3 = tek_satir_view.rbutton3
    }

}

