package com.example.chapter3topic1
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnPenjumlahan.setOnClickListener {
            var next = Intent(this, PenjumlahanActivity ::class.java)
            startActivity(next)
        }
        btnBMI.setOnClickListener{
            var next = Intent(this, BmiActivity ::class.java)
            startActivity(next)
        }
        btnNilaiAkhir.setOnClickListener{
            var next = Intent(this, NilaiAkhirActivity ::class.java)
            startActivity(next)
        }
    }
}