package com.example.szinkevero

import android.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.szinkevero.ui.theme.SzinKeveroTheme
import androidx.compose.material3.Slider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.ui.unit.dp
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SzinKeveroTheme {
                RGBColorMixer()
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}
@Composable
fun RGBColorMixer() {
    var red by remember {
        mutableStateOf((0f))
    }
    var green by remember {
        mutableStateOf((0f))
    }
    var blue by remember {
        mutableStateOf((0f))
    }
    val color = Color(
        red = red.toInt(),
        green = green.toInt(),
        blue = blue.toInt()
    )

    Column(modifier = Modifier.padding(30.dp, 50.dp))  {
        Text("RGB Szinkevero")
        Text("Red: ${red.toInt()}")
        Slider(value=red, onValueChange = {newValue-> red = newValue}, valueRange = 0f..255f)
        Text("Green: ${green.toInt()}")
        Slider(value=green, onValueChange = {newValue-> green = newValue}, valueRange = 0f..255f)
        Text("Blue: ${blue.toInt()}")
        Slider(value=blue, onValueChange = {newValue-> blue = newValue}, valueRange = 0f..255f)
        Text("RGB(${red.toInt()},${green.toInt()},${blue.toInt()})")
        Text("HEX: ${String.format("#%02X%02X%02X", red.toInt(), green.toInt(), blue.toInt())}") // Ezt sajnos leneztem az internetrol, megyek es megbanom buneimet
        Box(modifier = Modifier.fillMaxWidth().height(200.dp).background(color))
        Column () {
            Button(onClick = {
                val randomRed = Random.nextInt(0,255).toFloat()
                val randomGreen = Random.nextInt(0,255).toFloat()
                val randomBlue = Random.nextInt(0,255).toFloat()
                red = randomRed
                green = randomGreen
                blue= randomBlue
            }) {Text("Random")}
            Button(onClick = {
                red = 0f
                green = 0f
                blue= 0f
            }) {Text("Reset")}

        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SzinKeveroTheme {
        Greeting("Android")
    }
}