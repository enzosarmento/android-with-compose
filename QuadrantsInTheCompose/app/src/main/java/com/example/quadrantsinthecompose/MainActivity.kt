package com.example.quadrantsinthecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quadrantsinthecompose.ui.theme.FirstPurple
import com.example.quadrantsinthecompose.ui.theme.FourthPurple
import com.example.quadrantsinthecompose.ui.theme.QuadrantsInTheComposeTheme
import com.example.quadrantsinthecompose.ui.theme.SecondPurple
import com.example.quadrantsinthecompose.ui.theme.ThirdPurple
import java.nio.file.WatchEvent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuadrantsInTheComposeTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    QuadrantsApp()
                }
            }
        }
    }
}

@Composable
fun QuadrantsApp() {
    Column {
        Row(
            modifier = Modifier.fillMaxSize().weight(2f)
        ) {
            Quadrant(
                title = stringResource(R.string.title_first_quadrant),
                text = stringResource(R.string.text_first_quadrant),
                color = FirstPurple,
                modifier = Modifier.weight(1f).fillMaxSize()
            )
            Quadrant(
                title = stringResource(R.string.title_second_quadrant),
                text = stringResource(R.string.text_second_quadrant),
                color = SecondPurple,
                modifier = Modifier.weight(1f).fillMaxSize()
            )
        }
        Row(
            modifier = Modifier.fillMaxSize().weight(2f)
        ) {
            Quadrant(
                title = stringResource(R.string.title_third_quadrant),
                text = stringResource(R.string.text_third_quadrant),
                color = ThirdPurple,
                modifier = Modifier.weight(1f).fillMaxSize()
            )
            Quadrant(
                title = stringResource(R.string.title_fourth_quadrant),
                text = stringResource(R.string.text_fourth_quadrant),
                color = FourthPurple,
                modifier = Modifier.weight(1f).fillMaxSize()
            )
        }
    }
}

@Composable
private fun Quadrant(title: String, text: String, color: Color, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.background(color).padding(16.dp),
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = text,
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true)
@Composable
fun QuadrantPreview() {
    QuadrantsInTheComposeTheme {
        QuadrantsApp()
    }
}