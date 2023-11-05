package com.example.myprojects_pps

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.myprojects_pps.elSol.SolPortada
import com.example.myprojects_pps.ui.theme.Purple40
import com.example.myprojects_pps.ui.theme.Purple80

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Portada(navController: NavHostController){

    Scaffold(bottomBar = ({ MyBottomNavigation(navController) })) {
        Column(modifier = Modifier
            .fillMaxSize()
            .background(Color.Green),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {

            Text(text = "MyProjects",
                textAlign = TextAlign.Center,
                fontSize = 50.sp,
                fontStyle = FontStyle.Italic)
        }

    }
}


@Composable
fun MyBottomNavigation(navController: NavHostController) {
    NavigationBar {
        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate("MyPhotos")},
            icon = { Icon(imageVector = Icons.Default.Person, contentDescription = "") },
            label = { Text("MyPhotos") })

        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate("CoffeShops") },
            icon = { Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = "") },
            label = { Text("CoffeeShops") })

        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate("SolPortada")},
            icon = { Icon(imageVector = Icons.Default.Star, contentDescription = "") },
            label = { Text("ElSol") })
    }
}

