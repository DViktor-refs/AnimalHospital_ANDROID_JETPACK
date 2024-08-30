package com.example.veterinary.screens.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column


import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.veterinary.R

@Composable

fun CustomCard(
    imageResId: Int,
    contentDescription: String, 
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    navController: NavHostController
) {

    Card(
        modifier
            .size(150.dp)
            .clickable {  navController.navigate("aboutus") },
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(10.dp),
        border = BorderStroke(1.dp, Color(0xFFA4E9D2))
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(Modifier.size(15.dp))

            Image(
                painter = painterResource(id = imageResId),
                contentDescription = contentDescription,
                modifier
                    .size(150.dp, 100.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(
                        brush = Brush.radialGradient(
                            colors = listOf(
                                Color(0xFFE9E9E9),
                                Color(0XFFEBE4E4)
                            ), center = Offset(50.0f, 50.0f),
                            radius = 500.0f
                        )
                    ),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.size(5.dp))

            Text(
                text = text,
                modifier = Modifier
                    .wrapContentSize()
                    .align(alignment = Alignment.CenterHorizontally),
                fontWeight = FontWeight.Bold


            )
        }

    }
}