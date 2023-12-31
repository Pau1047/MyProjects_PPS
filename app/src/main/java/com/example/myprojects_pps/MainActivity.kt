package com.example.myprojects_pps

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myprojects_pps.coffeshops.CoffeShops
import com.example.myprojects_pps.elSol.ClaseInfo
import com.example.myprojects_pps.myPhotos.MyPhotos
import com.example.myprojects_pps.ui.theme.MyProjects_PPSTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyProjects_PPSTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "Portada"){
                        composable("Portada"){ Portada(navController)}
                        composable("MyPhotos"){
                            Surface(modifier = Modifier.fillMaxSize())
                        {
                            MyPhotos(navController)}
                        }
                        composable("CoffeShops"){
                            Surface(modifier = Modifier.fillMaxSize())
                            {
                                CoffeShops(navController)

                            }
                        }
                        composable("SolPortada"){
                            Surface(
                                modifier = Modifier.fillMaxSize(),
                                color = MaterialTheme.colorScheme.background
                            ) {
                                val navController = rememberNavController()
                                NavHost(navController = navController,startDestination = "SolPortada"){
                                    composable("SolPortada"){ com.example.myprojects_pps.elSol.SolPortada(navController)}
                                    composable("ClaseInfo"){ ClaseInfo(navController) }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyProjects_PPSTheme {
        //Greeting("Android")
    }
}