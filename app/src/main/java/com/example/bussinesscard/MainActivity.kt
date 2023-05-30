package com.example.bussinesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bussinesscard.ui.theme.BussinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BussinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyScreen(
                        name = stringResource(R.string.regxl),
                        phoneNumber = stringResource(R.string.phone_number),
                        instaID = stringResource(R.string.username),
                        email = stringResource(R.string.email)
                    )
                }
            }
        }
    }
}

@Composable
fun MyScreen(
    name: String,
    phoneNumber: String,
    instaID: String,
    email: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .background(color = Color(218, 247, 166))
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Introduction(
                name = name,
                modifier = Modifier
                    .fillMaxHeight(0.7f)
                    .wrapContentHeight(align = Alignment.CenterVertically)
            )
            Contact(
                phoneNumber = phoneNumber,
                instaID = instaID,
                email = email,
                modifier = Modifier.fillMaxHeight()
            )
        }
    }
}

@Composable
fun Introduction(name: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.android_logo),
            contentDescription = "Android Logo",
            modifier = Modifier
                .size(120.dp, 120.dp)
                .fillMaxWidth()
        )
        Text(
            text = name, fontSize = 60.sp, modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(), textAlign = TextAlign.Center
        )
        Text(
            text = stringResource(R.string.android_developer),
            color = Color(76, 175, 80, 255),
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun Contact(phoneNumber: String, instaID: String, email: String, modifier: Modifier = Modifier) {
    val phone = Icons.Rounded.Phone
    val mail = Icons.Rounded.Email
    val share = Icons.Rounded.Share
    Column(
        modifier = modifier
            .padding(40.dp)
            .fillMaxWidth()
            .fillMaxHeight(), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ContactRow(imageVector = phone, type = phoneNumber)
        ContactRow(imageVector = share, type = instaID)
        ContactRow(imageVector = mail, type = email)
    }
}

@Composable
fun ContactRow(imageVector: ImageVector, type: String, modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .padding(8.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier
                .fillMaxWidth(0.4f)
                .wrapContentWidth(align = Alignment.End),
            imageVector = imageVector,
            contentDescription = null,
            tint = Color(76, 175, 80, 255)
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.Start),
            text = type
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyScreen(
        name = stringResource(R.string.regxl),
        phoneNumber = stringResource(R.string.phone_number),
        instaID = stringResource(R.string.username),
        email = stringResource(R.string.email)
    )
}