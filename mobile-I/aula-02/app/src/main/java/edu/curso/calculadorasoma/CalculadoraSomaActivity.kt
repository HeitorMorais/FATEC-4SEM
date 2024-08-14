package edu.curso.calculadorasoma

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class CalculadoraSomaActivity : Activity() {
    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        Log.v("CALCULADORA", "Activity criada onCreate()")
        setContentView(R.layout.calculadora_layout)

        val edtNum1 = findViewById<EditText>(R.id.edtNumero1)
        val edtNum2 = findViewById<EditText>(R.id.edtNumber2)
        val sumBtn = findViewById<Button>(R.id.btnSomar)

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
        }
    }
    override fun onStart() {
        super.onStart()
        Log.v("CALCULADORA", "onStart() with success")
    }

    override fun onResume() {
        super.onResume()
        Log.v("CALCULADORA", "onResume() with success")
    }

    override fun onPause() {
        super.onPause()
        Log.v("CALCULADORA", "onPause(); application is paused")
    }

    override fun onStop() {
        super.onStop()
        Log.v("CALCULADORA", "onStop(); the application stopped")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v("CALCULADORA", "onDestroy(); application was been destroyed")
    }
}