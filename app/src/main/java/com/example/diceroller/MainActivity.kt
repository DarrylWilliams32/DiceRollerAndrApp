package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

/*this activity will allow user to push a button which simulates rolling dice
prints number of dice.roll() to screen
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)  //creates reference to button
        rollButton.setOnClickListener { roll() }        //sets function to 'listen' for button click
        roll()
    }

    private fun roll() {
        val dice = Dice(6)      //numSides is being set to '6'
        val diceRoll = dice.roll()      //creates first dice
        val diceRoll2 = dice.roll()     //creates second instance of dice
        //makes the roll() function interact with the imageView
        val diceImage: ImageView = findViewById(R.id.imageView)
        val diceImage2: ImageView = findViewById(R.id.imageView3)

        //creates logic that will change image view based on what dice1 has rolled
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        //updates imageView with correct resource ID
        diceImage.setImageResource(drawableResource)

        //creates logic that will change image view based on what dice2 has rolled
        val drawableResource2 = when (diceRoll2) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        //updates imageView with correct resource ID
        diceImage2.setImageResource(drawableResource2)
    }
}

class Dice(private val numSides: Int) {   //class created called Dice
    //function created to simulate dice rolling
    fun roll(): Int {
        return (1..numSides).random()
    }
}