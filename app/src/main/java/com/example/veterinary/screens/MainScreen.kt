package com.example.veterinary.screens

import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
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
import com.example.veterinary.screens.composables.CustomCard
import com.example.veterinary.screens.composables.ExitDialog

@Composable
fun MainScreen(navController: NavHostController) {

    val TitleTextStyle = TextStyle(
        color = Color(0xFF252B1E),
        fontSize = 40.sp,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Italic,
        fontFamily = FontFamily.Serif,
        letterSpacing = 2.sp,
    )

    val TitleTextStyle2 = TextStyle(
        color = Color(0xFF05C2E4),
        fontSize = 40.sp,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Italic,
        fontFamily = FontFamily.Serif,
        letterSpacing = 2.sp
    )

    val SubTitle = TextStyle(
        color = Color(0xFF252B1E),
        fontSize = 22.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily.Serif,
        letterSpacing = 2.sp
    )


    var showDialog by remember { mutableStateOf(false) }
    val context = LocalContext.current

    // BackHandler to handle the back button press
    BackHandler {
        showDialog = true
    }

    if (showDialog) {
        ExitDialog(
            onDismiss = { showDialog = false },
            onConfirmExit = {
                showDialog = false
                (context as ComponentActivity).finish() // Closes the app
            }
        )
    }



    Box(
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
            painter = painterResource(id = R.drawable.animals),
            contentDescription = "MainMenuBottomBackgroundPets",
            modifier = Modifier
                .align(Alignment.BottomCenter)
        )

        Column(
            modifier = Modifier.fillMaxSize()
        ) {

            Spacer(Modifier.size(125.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Tóth", style = TitleTextStyle)
                Text(text = "Vet", style = TitleTextStyle2)
            }
            
            Spacer(modifier = Modifier.size(2.dp))
            
            Text(
                text = "ÁllatKórház",
                style = SubTitle,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.size(75.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Első kártya
                CustomCard(
                    R.drawable.aboutus,
                    "aboutUs",
                    "Rendelőnkről",
                    modifier = Modifier,
                    doSomething()
                )

                //Második kártya
                CustomCard(
                    R.drawable.appointment,
                    "appointment",
                    "Időpont foglalás",
                    modifier = Modifier,
                    doSomething()
                )

            }



            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {

                //harmadik kártya
                CustomCard(
                    R.drawable.history,
                    "history",
                    "Előzmények",
                    modifier = Modifier,
                    doSomething()
                )

                CustomCard(
                    R.drawable.pharmacy,
                    "pharmacy",
                    "Állatgyógyszertár",
                    modifier = Modifier,
                    doSomething()
                )



            }
        }
    }
}

fun doSomething(): () -> Unit {

    return {}
}

@Composable
@Preview
fun TestView() {
    MainScreen(navController = NavHostController(LocalContext.current))
}


