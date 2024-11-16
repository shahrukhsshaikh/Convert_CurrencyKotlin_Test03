package com.example.convert_currencykotlin_test03

import android.app.Dialog
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var etAmountInr: EditText
    private lateinit var btnConvert: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etAmountInr = findViewById(R.id.etCountryCurrency)
        btnConvert = findViewById(R.id.btn_convert)

        btnConvert.setOnClickListener {
            val amountInr = etAmountInr.text.toString().toDoubleOrNull()

            if (amountInr != null) {
                showConversionDialog(amountInr)
            } else {
                etAmountInr.error = "Enter a valid amount"
            }
        }
    }

    private fun showConversionDialog(amountInr: Double) {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.custom_dialog)

        val tvResult = dialog.findViewById<TextView>(R.id.tv_result)
        val rbCan = dialog.findViewById<RadioButton>(R.id.rbCan)
        val rbUsa = dialog.findViewById<RadioButton>(R.id.rbUsa)
        val rbUk = dialog.findViewById<RadioButton>(R.id.rbUk)
        val rbChi = dialog.findViewById<RadioButton>(R.id.rbChi)

        rbCan.setOnClickListener { tvResult.text = "${amountInr * 0.015}"}
        rbUsa.setOnClickListener { tvResult.text = "${amountInr * 0.010}" }
        rbUk.setOnClickListener { tvResult.text =  "${amountInr * 0.0092}" }
        rbChi.setOnClickListener { tvResult.text = " ${amountInr * 0.082}" }
        dialog.show()
    }
}