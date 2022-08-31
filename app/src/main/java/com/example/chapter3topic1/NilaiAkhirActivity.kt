package com.example.chapter3topic1
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_nilai_akhir.*
import kotlinx.android.synthetic.main.activity_nilai_akhir.btnHitung
import kotlinx.android.synthetic.main.activity_nilai_akhir.btnReset

class NilaiAkhirActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nilai_akhir)
        btnHitung.setOnClickListener{
            val nama = editTextNama.text.toString()
            val nim = editTextNIM.text.toString()
            val nilaiUas = editTextUAS.text.toString()
            val nilaiUts = editTextUTS.text.toString()
            val nilaiTugas = editTextTugas.text.toString()
            tampilkanData(nama, nim, nilaiUas, nilaiUts, nilaiTugas)
            tampilkanNilai(nilaiUas.toDouble(), nilaiUts.toDouble(), nilaiTugas.toDouble())
        }
        btnReset.setOnClickListener {
            editTextNama.setText("")
            editTextNIM.setText("")
            editTextUAS.setText("")
            editTextUTS.setText("")
            editTextTugas.setText("")
            txtNama.text = ""
            txtNIM.text = ""
            txtUAS.text = ""
            txtUTS.text = ""
            txtTugas.text = ""
            txtTotal.text = ""
            txtRataRata.text = ""
            txtNilaiHrf.text = ""
            txtStatus.text = ""
        }
    }

    fun nilaiTotal(nilaiUas: Double, nilaiUts: Double, nilaiTugas: Double): Double{
        return (nilaiUas + nilaiUts + nilaiTugas)
    }

    fun rataRata(totalNilai :Double): Double{
        return (totalNilai/3)
    }

    fun cekKategoriNilai(rataRata:Double):String{
        if (rataRata in 0.0..60.0) return "F"
        else if(rataRata in 61.0..70.0) return "D"
        else if(rataRata in 71.0..80.0) return "C"
        else if(rataRata in 81.0..90.0) return "B"
        else if(rataRata in 91.0..100.0) return "A"
        else return "Data tidak valid"
    }

    fun statusLulus(statusNilai:String):String{
        if (statusNilai == "A" || statusNilai == "B" || statusNilai == "C") return "Lulus"
        else return "Tidak Lulus"
    }

    fun tampilkanData(nama: String, nim: String, nilaiUas: String, nilaiUts: String, nilaiTugas: String){
        txtNama.text = nama
        txtNIM.text = nim
        txtUAS.text = nilaiUas
        txtUTS.text = nilaiUts
        txtTugas.text = nilaiTugas
    }

    fun tampilkanNilai(nilaiUas: Double, nilaiUts: Double, nilaiTugas: Double){
        if(nilaiUts in 0.0..100.0 && nilaiUas in 0.0..100.0 && nilaiTugas in 0.0..100.00){
            val totalNilai = nilaiTotal(nilaiUts, nilaiUas, nilaiTugas)
            val hasil = rataRata(totalNilai)
            val hurufNilai = cekKategoriNilai(hasil)
            txtTotal.text = totalNilai.toString()
            txtRataRata.text = String.format("%.2f", hasil)
            txtNilaiHrf.text = hurufNilai
            txtStatus.text = statusLulus(hurufNilai)
        }
        else{
            txtTotal.text = "Nilai Melebihi Range"
            txtRataRata.text = "Nilai Melebihi Range"
            txtNilaiHrf.text = "Nilai Melebihi Range"
            txtStatus.text = "Tidak Lulus"
        }
    }
}