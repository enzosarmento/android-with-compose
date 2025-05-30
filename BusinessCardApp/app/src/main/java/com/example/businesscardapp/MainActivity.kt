package com.example.businesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscardapp.ui.theme.BusinessCardAppTheme
import com.example.businesscardapp.ui.theme.GreenAndroid
import com.example.businesscardapp.ui.theme.PurpleGrey40
import java.nio.file.WatchEvent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardAppTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Presentation(
            photo = painterResource(R.drawable.android_logo),
            name = stringResource(R.string.name),
            title = stringResource(R.string.title)
        )
        ContactData(
            phoneNumber = stringResource(R.string.phone_number),
            socialMedia = stringResource(R.string.social_media),
            email = stringResource(R.string.email)
        )
    }
}

@Composable
private fun Presentation(photo: Painter, name: String, title: String, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = photo,
            contentDescription = null,
            modifier = Modifier.background(PurpleGrey40).size(152.dp),
        )
        Text(
            text = name,
            fontSize = 28.sp,
            modifier = Modifier.padding(top = 16.dp, bottom = 16.dp)
        )
        Text(
            text = title,
            color = GreenAndroid
        )
    }
}

@Composable
private fun ContactData(phoneNumber: String, socialMedia: String, email: String, modifier: Modifier = Modifier) {
    val phoneIcon = painterResource(R.drawable.phone_24dp_3ddc84)
    val shareIcon = painterResource(R.drawable.share_24dp_3ddc84)
    val emailIcon = painterResource(R.drawable.email_24dp_3ddc84)
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Row(
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Icon(
                painter = phoneIcon,
                contentDescription = null,
                tint = GreenAndroid,
                modifier = Modifier.padding(end = 12.dp)
            )
            Text(
                text = phoneNumber
            )
        }
        Row(
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Icon(
                painter = shareIcon,
                contentDescription = null,
                tint = GreenAndroid,
                modifier = Modifier.padding(end = 12.dp)
            )
            Text(
                text = socialMedia
            )
        }
        Row {
            Icon(
                painter = emailIcon,
                contentDescription = null,
                tint = GreenAndroid,
                modifier = Modifier.padding(end = 12.dp)
            )
            Text(
                text = email
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardAppPreview() {
    BusinessCardAppTheme {
        BusinessCardApp()
    }
}