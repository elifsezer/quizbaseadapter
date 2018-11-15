package com.example.esezer.quizbaseadapter

class Question(var Sorular: String, var secenek1: String, var secenek2: String, var secenek3: String, var sorununDogruCevabi: Int) {
    fun dogruCevap(cevaplarinNumaralari: Int): Boolean {
        if (cevaplarinNumaralari == sorununDogruCevabi) {
            return true
        } else return false
    }

}