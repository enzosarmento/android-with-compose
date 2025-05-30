package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.Back
import com.example.lemonade.ui.theme.LemonadeTheme
import com.example.lemonade.ui.theme.Pink80

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                LemonadeApp()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LemonadeApp() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        LemonadeWithButtonAndImage(modifier = Modifier
            .fillMaxSize()
        )
    }
}

@Composable
fun LemonadeWithButtonAndImage(modifier: Modifier = Modifier) {
    var imageButton = 0
    var imageDescription = 0
    var phrase = 0
    var currentStep by remember { mutableIntStateOf(1) }
    var squeeze by remember { mutableIntStateOf(0) }
    var squeezeQtd by remember { mutableIntStateOf((2..4).random()) }
    when (currentStep) {
        2 -> {
            imageButton = R.drawable.lemon_squeeze
            imageDescription = R.string.lemon
            phrase = R.string.second_phrase
        }
        3 -> {
            imageButton = R.drawable.lemon_drink
            imageDescription = R.string.glass_of_lemonade
            phrase = R.string.third_phrase
        }
        4 -> {
            imageButton = R.drawable.lemon_restart
            imageDescription = R.string.empty_glass
            phrase = R.string.fourth_phrase

        }
        else -> {
            imageButton = R.drawable.lemon_tree
            imageDescription = R.string.lemon_tree
            phrase = R.string.first_phrase
        }
    }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = {
                if (currentStep == 2) {
                    if (squeeze == squeezeQtd) {
                        currentStep++
                        squeeze = 0
                        squeezeQtd = (2..4).random()
                    }
                    squeeze++
                } else if (currentStep == 4) {
                    currentStep = 1
                } else {
                    currentStep++
                }
            },
            shape = RoundedCornerShape(36.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Back
            )
        ) {
            Image(
                painter = painterResource(imageButton),
                contentDescription = stringResource(imageDescription),
            )
        }
        Spacer(
            modifier = Modifier.height(32.dp)
        )
        Text(
            text = stringResource(phrase),
            fontSize = 18.sp
        )
    }
}