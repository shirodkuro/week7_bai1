package com.example.bai1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.ComponentActivity


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)

        val editTextNumber = findViewById<EditText>(R.id.editTextNumber)
        val radioButtonEven = findViewById<RadioButton>(R.id.radioButton2)
        val radioButtonOdd = findViewById<RadioButton>(R.id.radioButton3)
        val radioButtonSquare = findViewById<RadioButton>(R.id.radioButton4)
        val submitButton = findViewById<Button>(R.id.button)
        val resultTextView = findViewById<TextView>(R.id.resultTextView)

        submitButton.setOnClickListener {
            val inputText = editTextNumber.text.toString()
            if (inputText.isNotEmpty()) {
                val n = inputText.toIntOrNull()
                if (n != null && n >= 0) {
                    val result = when {
                        radioButtonEven.isChecked -> generateEvenNumbers(n)
                        radioButtonOdd.isChecked -> generateOddNumbers(n)
                        radioButtonSquare.isChecked -> generateSquareNumbers(n)
                        else -> listOf("Vui lòng chọn một loại số")
                    }
                    resultTextView.text = result.joinToString(", ")
                } else {
                    resultTextView.text = "Vui lòng nhập số nguyên dương hợp lệ"
                }
            } else {
                resultTextView.text = "Vui lòng nhập số"
            }
        }
    }
    private fun generateEvenNumbers(n: Int): List<Int> {
        return (0..n).filter { it % 2 == 0 }
    }

    private fun generateOddNumbers(n: Int): List<Int> {
        return (0..n).filter { it % 2 != 0 }
    }

    private fun generateSquareNumbers(n: Int): List<Int> {
        return (0..n).filter { isPerfectSquare(it) }
    }

    private fun isPerfectSquare(num: Int): Boolean {
        val sqrt = Math.sqrt(num.toDouble()).toInt()
        return sqrt * sqrt == num
    }
}
