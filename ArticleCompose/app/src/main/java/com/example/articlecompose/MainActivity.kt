package com.example.articlecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.articlecompose.ui.theme.ArticleComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArticleComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Article(
                        title = stringResource(R.string.article_title),
                        paragraph1 = stringResource(R.string.paragraph_text_1),
                        paragraph2 = stringResource(R.string.paragraph_text_2)
                    )
                }
            }
        }
    }
}

@Composable
fun Article(title: String, paragraph1: String, paragraph2: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ) {
        ArticleImage()
        ArticleTitle(title)
        ArticleText(paragraph1, Modifier.padding(start = 16.dp, end = 16.dp))
        ArticleText(paragraph2, Modifier.padding(16.dp))
    }
}

@Composable
fun ArticleImage(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.bg_compose_background)
    Image(
        painter = image,
        contentDescription = null
    )
}

@Composable
fun ArticleTitle(title: String, modifier: Modifier = Modifier) {
    Text(
        text = title,
        fontSize = 24.sp,
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun ArticleText(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        modifier = modifier,
        textAlign = TextAlign.Justify
    )
}

@Preview(showBackground = true)
@Composable
fun ArticlePreview() {
    ArticleComposeTheme {
        Article(
            title = stringResource(R.string.article_title),
            paragraph1 = stringResource(R.string.paragraph_text_1),
            paragraph2 = stringResource(R.string.paragraph_text_2)
        )
    }
}