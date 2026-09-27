package com.example.szinkevero

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
    Column {
        Text("RGB Szinkevero")
        Text("Red: ${red.toInt()}")
        Slider(value=red, onValueChange = {newValue-> red = newValue}, valueRange = 0f..255f)
        Text("Green: ${green.toInt()}")
        Slider(value=green, onValueChange = {newValue-> green = newValue}, valueRange = 0f..255f)
        Text("Blue: ${blue.toInt()}")
        Slider(value=blue, onValueChange = {newValue-> blue = newValue}, valueRange = 0f..255f)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SzinKeveroTheme {
        Greeting("Android")
    }
}