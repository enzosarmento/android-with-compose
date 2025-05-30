package com.example.artsapce

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.artsapce.ui.theme.ArtSapceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSapceTheme {
                ArtSpaceApp()
            }
        }
    }
}

@Composable
fun ArtSpaceApp() {
    var artNumber by remember { mutableIntStateOf(1) }
    var artImage = R.drawable.mona_lisa
    var artName = R.string.mona_name
    var author = R.string.mona_author
    when (artNumber) {
        1 -> {
            artImage = R.drawable.mona_lisa
            artName = R.string.mona_name
            author = R.string.mona_author
        }
        2 -> {
            artImage = R.drawable.meisje
            artName = R.string.meisje_name
            author = R.string.meisje_author
        }
        else -> {
            artImage = R.drawable.grito
            artName = R.string.grito_name
            author = R.string.grito_author
        }
    }
    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {
        ArtDisplayScreen(
            artImage = artImage,
            artDescription = artName
        )
        ArtDescription(
            artName = artName,
            author = author
        )
        ArtSpaceNavigation(
            artNumber = artNumber,
            previous = {
                artNumber--
                if (artNumber < 1) {
                    artNumber = 3
                }
            },
            next = {
                artNumber++
                if (artNumber > 3) {
                    artNumber = 1
                }
            }
        )
    }
}

@Composable
fun ArtDisplayScreen(
    artImage: Int,
    @StringRes artDescription: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp)
            .shadow(3.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(artImage),
            contentDescription = stringResource(artDescription),
            modifier = Modifier.size(
                height = 400.dp,
                width = 250.dp
            )
        )
    }
    Spacer(
        Modifier.height(48.dp)
    )
}

@Composable
fun ArtDescription(
    @StringRes artName: Int,
    @StringRes author: Int,
    modifier: Modifier = Modifier
) {
    Column(
        Modifier
            .fillMaxWidth()
            .background(color = colorResource(R.color.light_gray))
            .padding(24.dp)
    ) {
        Text(
            text = stringResource(artName),
            lineHeight = 1.2.em,
            fontSize = 24.sp,
            color = colorResource(R.color.gray)
        )
        Text(
            text = stringResource(author),
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun ArtSpaceNavigation(
    artNumber: Int,
    previous: (Int) -> Unit,
    next: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(top = 24.dp)
    ) {
        Button(
            onClick = {
                previous(artNumber)
            },
            modifier = Modifier.weight(.5f),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                text = stringResource(R.string.previous)
            )

        }
        Spacer(
            modifier = Modifier.padding(horizontal = 32.dp)
        )
        Button(
            onClick = {
                next(artNumber)
            },
            modifier = Modifier.weight(.5f),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                text = stringResource(R.string.next)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    ArtSapceTheme {
        ArtSpaceApp()
    }
}