package com.example.chapter3topic1
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_bmi.*

class BmiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi)
        btnHitung.setOnClickListener{
            var tinggiBadan = editTextTB.text.toString()
            var beratBadan = editTextBB.text.toString()
            var bmi = hitungBMI(beratBadan.toDouble(), tinggiBadan.toDouble())
            txtUmur.text = "${editTextUmur.text} tahun"
            txtTB.text = "$tinggiBadan cm"
            txtBB.text = "$beratBadan kg"
            txtBMI.text = String.format("%.2f", bmi)
            txtKategori.text = kat(bmi)
        }
        btnReset.setOnClickListener{
            reset()
        }
    }

    fun hitungBMI(beratBadan: Double, tinggi: Double): Double{
        var tinggiBadan = tinggi / 100
        var bmi = beratBadan / (tinggiBadan * tinggiBadan)
        return bmi
    }

    fun reset(){
        txtUmur.text = ""
        txtTB.text = ""
        txtBB.text = ""
        txtBMI.text = ""
        txtKategori.text = ""
        editTextUmur.setText("")
        editTextTB.setText("")
        editTextBB.setText("")
    }

    fun kat(bmi: Double):String{
        val kat: String
        if (bmi < 16 && bmi > 0) {kat = "Terlalu Kurus"}
        else if (bmi >= 16 && bmi <= 17) {kat = "Cukup Kurus"}
        else if (bmi > 17 && bmi <= 18.5) {kat = "Sedikit Kurus"}
        else if (bmi > 18.5 && bmi <= 25) {kat = "Normal"}
        else if (bmi > 25 && bmi <= 30) {kat = "Gemuk"}
        else if (bmi > 30 && bmi <= 35) {kat = "Obesitas Kelas I"}
        else if (bmi > 35 && bmi <= 40) { kat = "Obesitas Kelas II"}
        else if (bmi > 40) {kat = "Obesitas Kelas III"}
        else {kat = "BMI Keluar Ambang Batas"}
        return kat
    }
}