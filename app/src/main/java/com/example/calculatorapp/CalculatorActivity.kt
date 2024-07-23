package com.example.calculatorapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class CalculatorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        val value1 = intent.getDoubleExtra("value1", 0.0)
        val value2 = intent.getDoubleExtra("value2", 0.0)

        val calculatorFragment = CalculatorFragment().apply {
            arguments = Bundle().apply {
                putDouble("value1", value1)
                putDouble("value2", value2)
            }
        }

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, calculatorFragment)
            commit()
        }
    }
}
