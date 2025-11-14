package com.example.shopapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_product.*

class ProductActivity : AppCompatActivity() {

    private val price = 120

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        btnAddToCart.setOnClickListener {
            val intent = Intent(this, MyCartActivity::class.java)
            intent.putExtra("price", price)
            startActivity(intent)
        }
    }
}
