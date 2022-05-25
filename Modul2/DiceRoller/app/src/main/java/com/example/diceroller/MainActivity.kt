package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var diceImage1: ImageView
    lateinit var diceImage2: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.text = getString(R.string.let_roll)
        rollButton.setOnClickListener{
            rollDice()
        }
        diceImage1 = findViewById(R.id.dice_image1)
        diceImage2 = findViewById(R.id.dice_image2)
    }

    private fun rollDice(){
        val randomInt1 = Random().nextInt(6) + 1
        val drawableResource1 = when (randomInt1){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        val randomInt2 = Random().nextInt(6) + 1
        val drawableResource2 = when (randomInt2){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        if(randomInt1==randomInt2){
             Toast.makeText(applicationContext, "Selamat anda dapat dadu double!", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(applicationContext, "Anda belum beruntung!", Toast.LENGTH_SHORT).show()
        }
        diceImage1.setImageResource(drawableResource1)
        diceImage2.setImageResource(drawableResource2)
    }
}