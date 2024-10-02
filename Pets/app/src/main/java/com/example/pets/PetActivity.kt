package com.example.pets

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.google.gson.Gson
import okhttp3.Call
import okhttp3.Callback
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import okio.IOException
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class PetActivity : Activity() {
    val URL_BASE = "https://firebase..."
    val lista = ArrayList<Pet>()
    val clientHttp = OkHttpClient()
    val gson = Gson() // gson serve para transformar objetos da classe em json
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    lateinit var edtNome : EditText
    lateinit var edtRaca : EditText
    lateinit var edtPeso : EditText
    lateinit var edtNascimento : EditText

    override fun onCreate (bundle: Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.pet_layout)

        val edtNome = findViewById<EditText>(R.id.edt_nome)
        val edtRaca = findViewById<EditText>(R.id.edt_raca)
        val edtPeso = findViewById<EditText>(R.id.edt_peso)
        val edtNascimento = findViewById<EditText>(R.id.edt_nascimento)

        val btnGravar = findViewById<Button>(R.id.btn_gravar)
        val btnPesquisar = findViewById<Button>(R.id.btn_pesquisar)
        btnGravar.setOnClickListener {
            val p = paraEntidade()
            salvarFirebase( p )
            carregarFirebase()
        }

        btnPesquisar.setOnClickListener {
            for (pet in lista) {
                if (pet.nome.contains( edtNome.text )) {
                    paraTela( pet )
                }
            }
        }
    }

    fun paraEntidade() : Pet {

        var p = Pet()
        p.nome = edtNome.text.toString()
        p.raca = edtRaca.text.toString()
        p.peso = edtPeso.text.toString().toFloat()
        p.nascimento = LocalDate.parse(edtNascimento.text.toString(), formatter)
        return p
    }

    fun paraTela(p : Pet) {
        edtNome.setText( p.nome )
        edtRaca.setText( p.raca )
        edtPeso.setText( p.peso.toString() )
        val txtNascimento : String? = p.nascimento.format(formatter)
        edtNascimento.setText( txtNascimento )
    }

    fun carregarFirebase() {


        val request = Request.Builder()
            .get()
            .url("$URL_BASE/pets.json")
            .build()

        val response = object : Callback {
            override fun onFailure(call: Call, e : IOException) {
                Log.e("PET", "Erro ao ler os dados", e)
            }

            override fun onResponse (call : Call, response : Response) {
                val textoJson = response.body?.string() ?: "{}"
                val mapa : HashMap<String, Pet> =
                    gson.fromJson(textoJson, HashMap<String, Pet>()::class.java)
                lista.clear()
                for (petItem in mapa) {
                    lista.add(petItem.value)
                }
            }
        }
        clientHttp.newCall(request).enqueue(response)
    }

    fun salvarFirebase(p : Pet) {
        val petJson = gson.toJson( p )
        val request = Request.Builder()
            .post(petJson.toRequestBody(
                "application/json".toMediaType()
            ))
            .url("$URL_BASE/pets.json")
            .build()
        val response = object : Callback {
            override fun onFailure(call: Call, e: java.io.IOException) {
                Log.e("PET", "Erro ao gravar o pet", e)
            }

            override fun onResponse(call: Call, response: Response) {
                Log.e("PET", "Pet gravado com sucesso")
            }
        }
        clientHttp.newCall(request).enqueue(response)
    }

}