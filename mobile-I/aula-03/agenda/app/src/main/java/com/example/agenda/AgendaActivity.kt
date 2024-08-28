package com.example.agenda

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast


class AgendaActivity : Activity() {
    val lista = ArrayList<Contato>()
    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        Log.v("AGENDA", "Activity iniciada")
        setContentView(R.layout.layout_agenda)

        val edtNome = findViewById<EditText>(R.id.edtNome)
        val edtTelefone = findViewById<EditText>(R.id.edtTelefone)
        val edtEmail = findViewById<EditText>(R.id.edtEmail)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)

        val btnGravar = findViewById<Button>(R.id.gravarBtn)
        val btnPesquisar : Button = findViewById(R.id.btnPesquisar)
        btnGravar.setOnClickListener {
            var nome = edtNome.text.toString()
            var telefone = edtTelefone.text.toString()
            var email = edtEmail.text.toString()
            val contato = Contato(nome = nome, telefone = telefone, email = email)
            lista.add( contato )
            Toast.makeText(this,
                "Contato gravado com sucesso", Toast.LENGTH_LONG).show()
            edtNome.setText("")
            edtTelefone.setText("")
            edtEmail.setText("")
        }
        btnPesquisar.setOnClickListener {
            for (contato in lista) {
                if(contato.nome.contains (edtNome.text)) {
                    edtNome.setText(contato.nome)
                    edtTelefone.setText(contato.telefone)
                    edtEmail.setText(contato.email)
                }
            }
        }
    }
}

data class Contato( var nome: String = "", var telefone: String = "", var email: String = "")
