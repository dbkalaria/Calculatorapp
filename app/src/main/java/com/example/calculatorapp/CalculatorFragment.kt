package com.example.calculatorapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment

class CalculatorFragment : Fragment() {

    private lateinit var input1: EditText
    private lateinit var input2: EditText
    private lateinit var result: TextView
    private lateinit var calculateButton: Button
    private lateinit var clearButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_calculator, container, false)

        input1 = view.findViewById(R.id.fragment_input1)
        input2 = view.findViewById(R.id.fragment_input2)
        result = view.findViewById(R.id.fragment_result)
        calculateButton = view.findViewById(R.id.btn_calculate)
        clearButton = view.findViewById(R.id.btn_clear)

        calculateButton.setOnClickListener {
            calculateResult()
        }

        clearButton.setOnClickListener {
            clearInputs()
        }

        return view
    }

    private fun calculateResult() {
        val num1 = input1.text.toString().toDoubleOrNull() ?: 0.0
        val num2 = input2.text.toString().toDoubleOrNull() ?: 0.0
        val sum = num1 + num2
        result.text = sum.toString()
    }

    private fun clearInputs() {
        input1.text.clear()
        input2.text.clear()
        result.text = ""
    }

    fun resetCalculator() {
        input1.text.clear()
        input2.text.clear()
        result.text = ""
    }
}
