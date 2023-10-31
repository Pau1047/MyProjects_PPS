package com.example.myprojects_pps.elSol

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(
    ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class
)
@Composable
fun Portada(navController: NavHostController) {
    var drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember{SnackbarHostState()}

    Scaffold(snackbarHost = { SnackbarHost(hostState = snackbarHostState)},bottomBar = { MyBAP(drawerState) }) {
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(bottom = it.calculateBottomPadding()) ){
            MyModalDrawer(drawerState,scope,navController,snackbarHostState)
        }
    }
}

data class InfoPortada(
    var imagen: Int,
    var name: String
)

fun getInfoPortada(): List<InfoPortada> {
    return listOf(
        InfoPortada(
            R.drawable.corona_solar,
            "Corona Solar"
        ),
        InfoPortada(
            R.drawable.erupcionsolar,
            "Erupcion Solar"
        ),
        InfoPortada(
            R.drawable.espiculas,
            "Espiculas"
        ),
        InfoPortada(
            R.drawable.filamentos,
            "Filamentos"
        ),
        InfoPortada(
            R.drawable.magnetosfera,
            "Magnetosfera"
        ),
        InfoPortada(
            R.drawable.manchasolar,
            "Mancha Solar"
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCard(infoPortada: InfoPortada,snackbarHostState: SnackbarHostState) {
    var extended by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = MaterialTheme.shapes.medium,
        onClick = {scope.launch{snackbarHostState.showSnackbar(infoPortada.name)}}

    ) {
        Column() {

            Image(
                painter = painterResource(id = infoPortada.imagen), contentDescription = "Imatge",
                modifier = Modifier
                    .fillMaxSize()
                    .height(220.dp),
                contentScale = ContentScale.Crop
            )

            BottomAppBar(modifier = Modifier.height(55.dp)) {
                Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically){
                    Text(text = infoPortada.name)

                    IconButton(onClick = { extended = !extended }) {
                        Icon(
                            imageVector = Icons.Filled.MoreVert,
                            contentDescription = "Back"
                        )
                    }
                }

                DropdownMenu(expanded = extended, onDismissRequest = { extended = !extended }) {
                    DropdownMenuItem(
                        text = { Text(text = "Copiar") },
                        onClick = { /*TODO*/ },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Filled.Add,
                                contentDescription = "Back"
                            )
                        })
                    DropdownMenuItem(
                        text = { Text(text = "Eliminar") },
                        onClick = { /*TODO*/ },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Filled.Delete,
                                contentDescription = "Back"
                            )
                        })

                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyBAP(drawerState: DrawerState) {
    var contador by remember { mutableStateOf(0) }
    var scope = rememberCoroutineScope()

    BottomAppBar {
        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
           Row {
               IconButton(onClick = { scope.launch{drawerState.open()} }) {
                   Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back" )
               }
               Spacer(modifier = Modifier.width(10.dp))
               BadgedBox(badge = {
                   Badge {
                       Text(text = contador.toString())
                   }
               }, modifier = Modifier
                   .padding(10.dp)
                   .clickable { contador++ }) {
                   Icon(imageVector = Icons.Filled.Favorite, contentDescription = "Fav")
               }
           }

            Row {
                FloatingActionButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Filled.Add, contentDescription = "Add")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyModalDrawer(drawerState: DrawerState,scope: CoroutineScope,navController: NavHostController, snackbarHostState: SnackbarHostState) {
    
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Column(modifier = Modifier.padding(8.dp)) {
                    Image(painter = painterResource(id = R.drawable.corona_solar), contentDescription = "", modifier = Modifier.fillMaxWidth(), contentScale = ContentScale.Crop)
                    NavigationDrawerItem(icon ={  Icon(imageVector = Icons.Filled.Build, contentDescription = "Build")} ,label = { Text(
                        text = "Build", modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    ) }, selected = false , onClick = { scope.launch { drawerState.close() }
                        navController.navigate("Portada")})

                    NavigationDrawerItem(icon = { Icon(imageVector = Icons.Filled.Info, contentDescription = "Info")},label = {
                        Text(
                            text = "Info", modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                        ) }, selected =false , onClick = { scope.launch { drawerState.close() }
                        navController.navigate("ClaseInfo")})

                    NavigationDrawerItem(icon = {Icon(imageVector = Icons.Filled.Email, contentDescription = "Email")},label = {   Text(
                        text = "Email", modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    ) }, selected =false , onClick = {  scope.launch { drawerState.close() }
                        navController.navigate("ClaseInfo")})
                }
            }
        }
    ,content = {Box(modifier = Modifier
            .fillMaxSize()) {
            val getInfoPortada = getInfoPortada()

            LazyVerticalGrid(columns = GridCells.Fixed(2), content = {
                items(getInfoPortada) { index ->
                    MyCard(index,snackbarHostState)
                }
            })
        }} )

    }
