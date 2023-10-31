package com.example.myprojects_pps.elSol

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClaseInfo(navController: NavHostController) {
    Scaffold {
        var drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
        val scope = rememberCoroutineScope()
        Scaffold(bottomBar = { MyBAP(drawerState) }) {
            MyModalDrawer2(drawerState,scope,navController)
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyModalDrawer2(drawerState: DrawerState, scope: CoroutineScope, navController: NavHostController) {
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Column(modifier = Modifier.padding(8.dp)) {
                    Image(painter = painterResource(id = R.drawable.corona_solar), contentDescription = "", modifier = Modifier.fillMaxWidth(), contentScale = ContentScale.Crop)
                    NavigationDrawerItem(icon ={  Icon(imageVector = Icons.Filled.Build, contentDescription = "Build") } ,label = { Text(
                        text = "Build", modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    ) }, selected = false , onClick = { scope.launch { drawerState.close() }
                        navController.navigate("Portada")})

                    NavigationDrawerItem(icon = { Icon(imageVector = Icons.Filled.Info, contentDescription = "Info") },label = {
                        Text(
                            text = "Info", modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                        ) }, selected =false , onClick = { scope.launch { drawerState.close() }
                        navController.navigate("ClaseInfo")})

                    NavigationDrawerItem(icon = { Icon(imageVector = Icons.Filled.Email, contentDescription = "Email") },label = {   Text(
                        text = "Email", modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    ) }, selected =false , onClick = {  scope.launch { drawerState.close() }
                        navController.navigate("ClaseInfo")})
                }
            }
        }
        ,content = {} )

}
