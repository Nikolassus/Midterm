package com.example.shopapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_my_cart.*

class MyCartActivity : AppCompatActivity() {

    private var quantity = 1
    private var price = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_cart)

        price = intent.getIntExtra("price", 0)
        productSinglePrice.text = "$price$"
        totalText.text = "Total: $price$"

        btnPlus.setOnClickListener {
            quantity++
            txtQuantity.text = quantity.toString()
            updateTotal()
        }

        btnMinus.setOnClickListener {
            if (quantity > 1) {
                quantity--
                txtQuantity.text = quantity.toString()
                updateTotal()
            }
        }

        btnOrder.setOnClickListener {
            startActivity(Intent(this, SuccessPopActivity::class.java))
        }

        btnBack.setOnClickListener {
            finish()  // goes back to ProductActivity
        }
    }

    private fun updateTotal() {
        val total = price * quantity
        totalText.text = "Total: ${total}$"
    }
}
