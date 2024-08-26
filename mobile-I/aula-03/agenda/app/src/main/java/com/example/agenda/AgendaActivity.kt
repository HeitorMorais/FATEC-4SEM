package com.example.agenda

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText


class AgendaActivity : Activity() {
    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        Log.v("AGENDA", "Activity iniciada")
        setContentView(R.layout.layout_agenda)

        val edtNome = findViewById<EditText>(R.id.edtNome)
        val edtTelefone = findViewById<EditText>(R.id.edtTelefone)
        val edtEmail = findViewById<EditText>(R.id.edtEmail)

        val gravarBtn = findViewById<Button>(R.id.gravarBtn)

        gravarBtn.setOnClickListener {
            var nome = edtNome.text.toString()
            var telefone = edtTelefone.text.toString()
            var email =edtEmail.text.toString()

            Log.v("AGENDA", "Nome: ${nome}, Telefone: ${telefone}, Email: ${email}")
        }
    }
}