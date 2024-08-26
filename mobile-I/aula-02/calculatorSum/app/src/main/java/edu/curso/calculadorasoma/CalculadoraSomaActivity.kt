package edu.curso.calculadorasoma

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class CalculadoraSomaActivity : Activity() {
    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        Log.v("CALCULADORA", "Activity criada onCreate()")
        setContentView(R.layout.calculadora_layout)

        val edtNum1 = findViewById<EditText>(R.id.edtNumero1)
        val edtNum2 = findViewById<EditText>(R.id.edtNumber2)
        val sumBtn = findViewById<Button>(R.id.btnSomar)
        var viewResult = findViewById<TextView>(R.id.viewResult)

        sumBtn.setOnClickListener {
            var num1 = edtNum1.text.toString().toDoubleOrNull()
            var num2 = edtNum2.text.toString().toDoubleOrNull()
            if(num1 == null){
                num1 = 0.0
            }
            if(num2 == null){
                num2 = 0.0
            }
            Log.v("CALCULADORA", "Resultado: ${num1 + num2}")
            viewResult.text = "Resultado: ${num1 + num2}"
        }
    }
}