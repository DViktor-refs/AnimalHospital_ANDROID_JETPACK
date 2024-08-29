package com.example.veterinary.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.veterinary.R

@Composable
fun AboutUs(navController: NavHostController) {

    val TitleTextStyle1 = TextStyle(
        color = Color(0xFF1B1D1D),
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily.Serif,

    )

    val TitleTextStyle2 = TextStyle(
        color = Color(0xFF1B1D1D),
        fontSize = 16.sp,
        fontFamily = FontFamily.Serif,
    )


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFC5E9EE),
                        Color(0XFFEBE4E4)
                    )
                )
            ),
    ) {
        Image(
            painter = painterResource(id = R.drawable.aboutusbackgroundimage),
            contentDescription = "" ,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .clip(
                    RoundedCornerShape(
                        bottomStart = 16.dp,
                        bottomEnd = 16.dp
                    )
                ),
            alignment = Alignment.TopCenter,
            contentScale = ContentScale.Crop,

        )

        Spacer(modifier = Modifier
            .height(20.dp))

        Text(
            text = stringResource(R.string.aboutustitle),
            style = TitleTextStyle1,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(5.dp, 0.dp, 5.dp, 12.dp).fillMaxWidth()
            )

        Text(
            text = stringResource(R.string.introduction),
            style = TitleTextStyle2,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(10.dp, 5.dp, 10.dp, 0.dp)
        )

        Spacer(modifier = Modifier.size(8.dp))

        Row(modifier = Modifier.fillMaxWidth(), Arrangement.Center) {
            Icon(
                imageVector = Icons.Filled.Email,
                contentDescription = "",
                tint = Color(0xFF05C2E4),
                modifier = Modifier
                    .padding(0.dp,16.dp,0.dp,0.dp).weight(2.0f)
                )
            Text(text = stringResource(R.string.emailaddress),
                modifier = Modifier
                    .padding(16.dp,16.dp, 0.dp, 0.dp)
                    .weight(3.0f))
        }

        Row(modifier = Modifier.fillMaxWidth(), Arrangement.Center) {
            Icon(
                imageVector = Icons.Filled.Phone,
                contentDescription = "",
                tint = Color(0xFF05C2E4),
                modifier = Modifier
                    .padding(0.dp,16.dp,0.dp,0.dp)
                    .weight(2.0f)
            )
            Text(text = stringResource(R.string.phonenumber),
                modifier = Modifier
                    .padding(16.dp,16.dp, 0.dp, 0.dp)
                    .weight(3.0f))
        }

        Row(modifier = Modifier.fillMaxWidth(), Arrangement.Center) {
            Icon(
                imageVector = Icons.Filled.Home,
                contentDescription = "",
                tint = Color(0xFF05C2E4),
                modifier = Modifier
                    .padding(0.dp,16.dp,0.dp,0.dp)
                    .weight(2.0f)
            )
            Text(text = stringResource(R.string.address),
                modifier = Modifier
                    .padding(16.dp,16.dp, 0.dp, 0.dp)
                    .weight(3.0f))
        }

        Box(modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ) {
            Row(horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    navController.navigate("main")

            }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "",
                    tint = Color(0xFF05C2E4),
                    modifier = Modifier
                        .padding(0.dp,0.dp,0.dp, 40.dp)
                )

                Text(text = "Vissza a főoldalra",
                    modifier = Modifier
                        .padding(16.dp, 0.dp, 0.dp, 40.dp)
                )
            }
        }





    }
}

fun goToMainMenu() {

}

@Composable
@Preview
fun AboutUsPreview() {
    AboutUs(navController = NavHostController(LocalContext.current))
}