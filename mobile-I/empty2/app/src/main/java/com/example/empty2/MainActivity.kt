package com.example.empty2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
                Agenda()
            }
        }
    }

data class Contato(
    var nome : String = "",
    var email : String = "",
    var telefone : String = ""
)

@Preview(showBackground=true)
@Composable
fun Agenda(){
    val textLabel = listOf(
            "Nome", "Email", "Telefone"
    )
    val nome = remember {mutableStateOf("aaaa")}
    val email = remember {mutableStateOf("bbb")}
    val telefone = remember {mutableStateOf("xx")}
    val valuesText = listOf(
        nome, email, telefone
    )
    val contactList = remember { mutableStateListOf<Contato>()}

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Agenda de Contatos")
        for(linha in 0..2) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                val texto = textLabel[linha]
                Text(texto, modifier = Modifier.padding(10.dp))
                OutlinedTextField(value = valuesText[linha].value, onValueChange = {valuesText[linha].value = it}, modifier = Modifier.fillMaxWidth())
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
           Button(onClick = {
               val contato = Contato(
                   nome = nome.value,
                   email = email.value,
                   telefone = telefone.value)
               contactList.add(contato)
           }) {
               Text("Gravar")
           }
            Button(onClick = {}) {
                Text("Pesquisar")
            }
        }
//        Column {
//            for (contato in contactList) {
//                Card() {
//                    Text(contato.nome)
//                    Text(contato.email)
//                }
//            }
//        }
        LazyColumn() {
            item {
                Text("inicio da Lazy Column")
            }
        }
    }
}