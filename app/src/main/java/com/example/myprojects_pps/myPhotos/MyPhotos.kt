package com.example.myprojects_pps.myPhotos

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.content.res.Configuration.*
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.myprojects_pps.MyBottomNavigation
import com.example.myprojects_pps.Portada
import com.example.myprojects_pps.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyPhotos(navController: NavHostController) {
    var selectedImage by remember { mutableStateOf<ImageData?>(null) }

    Scaffold(bottomBar = { MyBottomNavigation(navController) }, modifier = Modifier
        .fillMaxSize()
        .padding(top = 8.dp),
        content = {
            LazyRow(
                modifier = Modifier
                    .height(130.dp)
                    .fillMaxWidth()
            ) {
                items(getAboutData()) { about ->
                    ItemAbout(imageData = about) {
                        selectedImage = about
                    }

                }
            }
            Spacer(modifier = Modifier.height(30.dp))
            if (selectedImage != null) {
                Surface {
                    Image(
                        painter = painterResource(id = selectedImage!!.photo),
                        contentDescription = "Game Image",
                        modifier = Modifier
                            .fillMaxSize()
                    )
                }
            } else {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Transparent,
                ) { }
            }
        }
    )
}
data class ImageData(
    @DrawableRes var photo: Int
)

fun getAboutData(): List<ImageData> {
    return listOf(
        ImageData(
            R.drawable.image1
        ),
        ImageData(
            R.drawable.image2
        ),
        ImageData(
            R.drawable.image3
        ),
        ImageData(
            R.drawable.image4
        ),
        ImageData(
            R.drawable.image5
        ),
        ImageData(
            R.drawable.image6
        ),
        ImageData(
            R.drawable.image7
        ),
        ImageData(
            R.drawable.image8
        ),
    )
}

@Composable
fun ItemAbout(imageData: ImageData, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .width(180.dp)
            .padding(end = 5.dp)
            .clickable(onClick = onClick)
        ,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = imageData.photo),
            contentDescription = "Image",
            modifier = Modifier
                .fillMaxSize()
        )

    }
}