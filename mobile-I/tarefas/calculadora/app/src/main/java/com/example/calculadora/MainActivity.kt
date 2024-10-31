package com.example.calculadora

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
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.calculadora.ui.theme.CalculadoraTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculadoraTela()
        }
    }
}



@Preview(showBackground = true)
@Composable
fun CalculadoraTela() {
    var index = 0
   val calculatorButtons : List<String> = listOf(
       "1", "2", "3", "+",
       "4", "5", "6", "-",
       "7", "8" ,"9", "*",
       ".", "0", "=", "/"
   )
    Column(modifier = Modifier.
            fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(value = "", onValueChange = {})
            Button(onClick = { /*TODO*/ }) {
                Text("CE")
            }
        }
        while(index < 16) {
            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                Arrangement.SpaceAround
            ){
                Button(onClick = { /*TODO*/ }) {
                    Text(calculatorButtons[index])
                }
                Button(onClick = { /*TODO*/ }) {
                    Text(calculatorButtons[index+1])
                }
                Button(onClick = { /*TODO*/ }) {
                    Text(calculatorButtons[index+2])
                }
                Button(onClick = { /*TODO*/ }) {
                    Text(calculatorButtons[index+3])
                }
            }
            index += index + 4
        }
    }


}

