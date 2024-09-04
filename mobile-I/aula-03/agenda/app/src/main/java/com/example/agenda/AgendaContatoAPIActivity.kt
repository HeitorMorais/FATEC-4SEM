package com.example.agenda

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import okhttp3.Call
import okhttp3.Callback
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import java.io.IOException

class AgendaContatoAPIActivity : Activity() {
    val URL_BASE = "https://mobile-4sem-default-rtdb.firebaseio.com"
    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.layout_agenda)

        val edtNome = findViewById<EditText>(R.id.edtNome)
        val edtEmail = findViewById<EditText>(R.id.edtEmail)
        val edtTelefone = findViewById<EditText>(R.id.edtTelefone)
        val btnGravar = findViewById<Button>(R.id.gravarBtn)
        val client = OkHttpClient()
        val contatoJson = """
                {
                    "nome": "${edtNome.text}",
                    "email": "${edtEmail.text}",
                    "telefone": "${edtTelefone.text}"
                }
            """.trimIndent()
        btnGravar.setOnClickListener {
            val request = Request.Builder()
                .url("${URL_BASE}/contatos.json")
                .post(contatoJson.toRequestBody(
                    "application/json".toMediaType()
                ))
                .build()

            val response = object: Callback {
                override fun onFailure(call: Call, e: IOException) {
                    Log.v("AGENDA", "Erro: ${e.message} ao cadastrar o contato")
                }

                override fun onResponse(call: Call, response: Response) {
                    Log.v("AGENDA", "Contato cadastrado com sucesso ${edtNome.text}, ${edtTelefone.text}, ${edtEmail.text}")
                }
            }

            client.newCall( request ).enqueue( response )
        }
    }
}