package com.example.rolldiceapp

import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)

        rollButton.setOnClickListener {
            rollDice()
//            rollDice2()
        }
    }

    private fun rollDice() {
        // Create new Dice object with 6 sides and roll the dice
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // Find the ImageView in the layout
        val diceImage: ImageView = findViewById(R.id.imageView)

        // Determine which drawable resource ID to use based on the dice roll
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Update the ImageView with the correct drawable resource ID
        diceImage.setImageResource(drawableResource)

        // Toast the number
        val  toast = Toast.makeText(this, diceRoll.toString() , Toast.LENGTH_SHORT)
        toast.show()
//        val resultTextView: TextView = findViewById(R.id.textView)
//        resultTextView.text = diceRoll.toString()
    }

//    private fun rollDice2() {
//        val dice = Dice(6)
//        val diceRoll = dice.roll()
//        val resultTextView2: TextView = findViewById(R.id.textView2)
//        resultTextView2.text = diceRoll.toString()
//    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}