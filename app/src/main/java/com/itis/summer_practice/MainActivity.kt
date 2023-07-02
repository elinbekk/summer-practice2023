package com.itis.summer_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    private var button: Button? = null
    private var name: EditText? = null
    private var height: EditText? = null
    private var weight: EditText? = null
    private var age: EditText? = null
    private var value = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        name = findViewById(R.id.editTextText)
        height = findViewById(R.id.editTextNumber)
        weight = findViewById(R.id.editTextNumber2)
        age = findViewById(R.id.editTextNumber3)
        button = findViewById(R.id.button)

        val textView = findViewById<TextView>(R.id.textView)

        button?.setOnClickListener {
            if (inputIsEmpty()) {
                textView?.text = "Data entered incorrectly!"
            } else {
                val n = name?.text.toString()
                val h = height?.text.toString().toInt()
                val w = weight?.text.toString().toDouble()
                val a = age?.text.toString().toInt()
                value = (w * 7 + h * 7 - a * 5 + n.length * 2).roundToInt()
                if (inputIsCorrect(n, h, w, a)) {
                    textView?.text = "Your level of luck: $value"
                } else {
                    textView?.text = "Data entered incorrectly"
                }
            }
        }
    }

    private fun inputIsEmpty(): Boolean {
        return (name?.text.toString().isEmpty() || height?.text.toString()
            .isEmpty() || weight?.text.toString().isEmpty() || age?.text.toString().isEmpty())
    }

    private fun inputIsCorrect(arg1: String, arg2: Int, arg3: Double, arg4: Int): Boolean {
        return ((arg1.length < 50) && (arg2 in 1..250) && (arg4 in 1 .. 250) && (arg4 in 1..150))
    }
}