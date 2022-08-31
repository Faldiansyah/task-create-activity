package com.example.chapter3topic1
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_penjumlahan.*
import kotlinx.android.synthetic.main.activity_penjumlahan.btnReset

class PenjumlahanActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_penjumlahan)
        btnHasil.setOnClickListener{
            var angka1 = editAngka1.text.toString().toInt()
            var angka2 = editAngka2.text.toString().toInt()
            var hasil = angka1 + angka2
            textViewHasil.text = "Hasil $angka1 + $angka2 = $hasil"
            if(hasil > 100) textViewHasilKondisi.text = "Hasil lebih Dari 100"
            else textViewHasilKondisi.text = "Hasil kurang dari 100"
        }
        btnReset.setOnClickListener{
            reset()
        }
    }

    fun reset(){
        editAngka1.setText("")
        editAngka2.setText("")
    }
}