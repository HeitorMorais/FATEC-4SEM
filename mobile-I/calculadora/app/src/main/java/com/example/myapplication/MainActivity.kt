package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.Horizontal
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text2.input.TextFieldCharSequence
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var contador = mutableIntStateOf(0)
        setContent {
            Contador( contador )
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun Contador( contador : MutableIntState) {

    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(onClick = {
            contador.value -= 1
            Log.d("AULA11", "Contador: ${contador.value}")
        }) {

            Text("-", fontSize = 48.sp)
        }
        Text(text = "${contador.value}", fontSize = 42.sp)
        Button(onClick = {
            contador.value += 1
            Log.d("AULA11", "Contador: ${contador.value}")
        }) {
            Text("+", fontSize = 48.sp)
        }
    }
}


@Composable
fun calculadora() {
    val nomesBotoes = listOf(
        "1", "2", "3", "+",
        "4", "5", "6", "-",
        "7", "8", "9", "*",
        ".", "0", "=", "/"
    )

    val indice = 0;
    Column(modifier = Modifier
        .padding(30.dp)
        .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            TextField(modifier = Modifier.width(225.dp), value = "", onValueChange = {},
            label={Text("Numeros", fontSize = 12.sp)})
            Button(onClick = { /*TODO*/ }) {
                Text("CE", fontSize = 28.sp)
            }
        }
        for(linha in 0 .. 3) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                for (coluna in 0..3) {
                    Button(onClick = { /*TODO*/ }) {
                        val indice = linha * 4 + coluna
                        val texto = nomesBotoes[indice]
                        Text(texto, fontSize = 28.sp)
                    }
                }
            }
        }


    }
}