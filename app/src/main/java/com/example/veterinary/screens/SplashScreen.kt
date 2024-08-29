package com.example.veterinary.screens

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.example.veterinary.R
import kotlinx.coroutines.delay

@Composable

fun SplashScreen(navController: NavHostController) {

    var isAnimating by remember { mutableStateOf(false) }

    val rotation by animateFloatAsState(
        targetValue = if (isAnimating) 0f else 12f,
        animationSpec = tween(durationMillis = 300)
    )

    val scale by animateFloatAsState(
        targetValue = if (isAnimating) 1.5f else 1.3f,
        animationSpec = tween(durationMillis = 300)
    )

    LaunchedEffect(Unit) {

            isAnimating = !isAnimating
            delay(1000)
        }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_16_9),
            contentDescription = "Animated Image",
            modifier = Modifier
                .fillMaxSize()
                .scale(scale)
                .rotate(rotation)
        )
    }


}