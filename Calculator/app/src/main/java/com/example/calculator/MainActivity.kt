package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //declare all necessary xml elements
        val output_txt = findViewById<TextView>(R.id.editTextNumber)
        val clear_btn = findViewById<Button>(R.id.clearBtn)
        val dec_btn = findViewById<Button>(R.id.decimalPBtn)
        val plus_btn = findViewById<Button>(R.id.plusBtn)
        val minus_btn = findViewById<Button>(R.id.minusBtn)
        val equals_btn = findViewById<Button>(R.id.equalsBtn)
        val times_btn = findViewById<Button>(R.id.timesBtn)
        val btn_0 = findViewById<Button>(R.id.zeroBtn)
        val btn_1 = findViewById<Button>(R.id.oneBtn)
        val btn_2 = findViewById<Button>(R.id.twoBtn)
        val btn_3 = findViewById<Button>(R.id.threeBtn)
        val btn_4 = findViewById<Button>(R.id.fourBtn)
        val btn_5 = findViewById<Button>(R.id.fiveBtn)
        val btn_6 = findViewById<Button>(R.id.sixBtn)
        val btn_7 = findViewById<Button>(R.id.sevenBtn)
        val btn_8 = findViewById<Button>(R.id.eightBtn)
        val btn_9 = findViewById<Button>(R.id.nineBtn)

        val calculation = mutableListOf<String>()
        fun inputNumber(number: Int){
            calculation.add(number.toString())
            output_txt.text = calculation.toString()
        }
        fun inputOperator(operator: String){
            //add logic so formated correctly
            if (calculation.isNotEmpty()) { //add and previous element !- operator
                calculation.add(operator)
                output_txt.text = calculation.toString()
            }
        }

        //clear display
        clear_btn.setOnClickListener { calculation.clear()
            output_txt.text = calculation.toString()
        }

        //operators
        dec_btn.setOnClickListener { inputOperator(".") }
        plus_btn.setOnClickListener { inputOperator("+") }
        minus_btn.setOnClickListener { inputOperator("-") }
        equals_btn.setOnClickListener {  }
        times_btn.setOnClickListener { inputOperator("*") }

        //numbers
        btn_0.setOnClickListener { inputNumber(0) }
        btn_1.setOnClickListener { inputNumber(1) }
        btn_2.setOnClickListener { inputNumber(2) }
        btn_3.setOnClickListener { inputNumber(3) }
        btn_4.setOnClickListener { inputNumber(4) }
        btn_5.setOnClickListener { inputNumber(5) }
        btn_6.setOnClickListener { inputNumber(6) }
        btn_7.setOnClickListener { inputNumber(7) }
        btn_8.setOnClickListener { inputNumber(8) }
        btn_9.setOnClickListener { inputNumber(9) }









    }
}