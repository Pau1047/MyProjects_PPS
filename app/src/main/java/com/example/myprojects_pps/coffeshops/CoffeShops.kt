package com.example.myprojects_pps.coffeshops

import android.annotation.SuppressLint
import android.widget.RatingBar
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.displayCutoutPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.myprojects_pps.MyBottomNavigation
import com.example.myprojects_pps.Portada
import java.lang.Math.ceil
import java.lang.Math.floor


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CoffeShops (navController: NavHostController) {

    Scaffold(topBar = { MyTopAppBar() }, bottomBar =  { MyBottomNavigation(navController) },modifier = Modifier
        .fillMaxSize()
        .padding(top = 8.dp),
        content = {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = it.calculateTopPadding()),

        ) {

            LazyColumn {
                items(getInfoCoffes()) { info ->
                    MyCard(infoCoffe = info, navController = navController)
                }
            }
        }
    })
}

@Composable
fun MyCard(infoCoffe: InfoCoffe, navController: NavHostController) {
    var rating by remember { mutableStateOf(0) }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { navController.navigate("Opiniones/${infoCoffe.titles}") },

        shape = MaterialTheme.shapes.medium

    ) {
        Column() {

            Image(painter = painterResource(id = infoCoffe.images), contentDescription = "Imatge",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Text(text = infoCoffe.titles,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                fontSize = 40.sp
            )

            RatingBar(modifier = Modifier.padding(start = 20.dp),
                rating = rating,
                onRatingChanged = { newRating ->
                    rating = newRating
                })

            Text(text = infoCoffe.directions)

            Divider()

            TextButton(onClick = { /*TODO*/ }) {
                Text(text = "RESERVE")
            }

        }
    }
}

@Composable
fun RatingBar(
    modifier: Modifier = Modifier,
    rating: Int = 0,
    stars: Int = 5,
    onRatingChanged: (Int) -> Unit
) {
    Row(modifier = modifier) {
        repeat(stars) { starIndex ->
            Icon(
                imageVector = Icons.Outlined.Star,
                contentDescription = null,
                tint = if (starIndex < rating) Color.Black else Color.White,
                modifier = Modifier
                    .padding(end = 10.dp)
                    .clickable { onRatingChanged(starIndex + 1) }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar() {
    var extended by remember { mutableStateOf(false) }

    TopAppBar(
        title = { Text(text = "CoffeShops") },
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Back"
                )
            }
        },
        actions = {
            IconButton(onClick = { extended = !extended }) {
                Icon(
                    imageVector = Icons.Filled.MoreVert,
                    contentDescription = "Back"
                )
            }
            DropdownMenu(expanded = extended, onDismissRequest = { extended = !extended}) {
                DropdownMenuItem(text = { Text(text = "Compartir") }, onClick = { /*TODO*/ }, leadingIcon = { Icon(
                    imageVector = Icons.Filled.Share,
                    contentDescription = "Back"
                )})
                DropdownMenuItem(text = { Text(text = "Album") }, onClick = { /*TODO*/ }, leadingIcon = { Icon(
                    imageVector = Icons.Filled.Lock,
                    contentDescription = "Back"
                )})

            }

        }
    )
}