package com.example.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import kotlin.random.Random


class MainActivity : AppCompatActivity() {

    lateinit var diceImage: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton = findViewById<Button>(R.id.rollButton)
        //val diceImg = findViewById<ImageView>(R.id.dice_img)
        val seekBar = findViewById<SeekBar>(R.id.seekBar)
        val button = findViewById<Button>(R.id.button)
        val intent = Intent(this, MainActivity2::class.java)
        diceImage = findViewById(R.id.dice_img)

        rollButton.setOnClickListener{
            val rand = Random.nextInt(6) + 1
            val drawableResource = when (rand) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            }

            diceImage.setImageResource(drawableResource)
        }

        button.setOnClickListener{
            startActivity(intent)
        }
    }
}