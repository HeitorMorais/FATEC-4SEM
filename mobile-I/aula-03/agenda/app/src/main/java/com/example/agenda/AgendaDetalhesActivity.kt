package com.example.agenda

import android.app.Activity
import android.os.Bundle
import android.widget.Button

class AgendaDetalhesActivity : Activity() {
    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)

        setContentView(R.layout.layout_detalhes_agenda)

        val btnVoltar = findViewById<Button>(R.id.btnVoltar)
    }
}