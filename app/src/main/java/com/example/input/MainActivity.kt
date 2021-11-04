package com.example.input

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Spinner
import android.widget.Button
import android.widget.TextView
import java.text.DecimalFormat


class MainActivity : AppCompatActivity() {


    var costOfMeal = 0.00
    var totalCharges = 0.00


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Id's
        val cost = findViewById<EditText>(R.id.idCost)
        val group = findViewById<Spinner>(R.id.spinnerGroup)
        val calc = findViewById<Button>(R.id.buttonCalculate)
        val output = findViewById<TextView>(R.id.output)


        // On tap
        calc.setOnClickListener {
            costOfMeal = cost.text.toString().toDouble()
            val currency = DecimalFormat("$###,###.00")


            // Set to 0.00
            totalCharges = 0.00
            when (group.selectedItem.toString()) {
                "5%" -> totalCharges += costOfMeal + (costOfMeal / 10) / 2
                "10%" -> totalCharges += costOfMeal + (costOfMeal / 10)
                "15%" -> totalCharges += costOfMeal + (costOfMeal / 10 + costOfMeal / 10 / 2)
                "20%" -> totalCharges += costOfMeal + (costOfMeal / 10 * 2)
                "25%" -> totalCharges += costOfMeal + (costOfMeal / 10 * 2 + costOfMeal / 10 / 2)

            }



            // Display
            val formatted = currency.format( totalCharges )
            output.text = "The cost is $formatted"


        }


    }


}

