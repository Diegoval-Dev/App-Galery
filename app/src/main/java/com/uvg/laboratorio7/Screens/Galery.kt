package com.uvg.laboratorio7.Screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.uvg.laboratorio7.R
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.uvg.laboratorio7.Model.ArtImage

@Composable
fun GaleryScreen(navController: NavController, onLogout: () -> Unit){
    GaleryBodyContent(navController = navController, onLogout = onLogout)
}

@Composable
fun GaleryBodyContent( navController: NavController, onLogout: () -> Unit){
    var numberArt by remember { mutableStateOf( 0) }

    val mutableListOfPersons = mutableListOf(ArtImage("Diru","Ruth","(2022)", R.drawable.spiralbetty_1667763462561) ,
        ArtImage("Burgues Cat 1", "Diego", "(2021)" , R.drawable.dall_e_2023_04_03_19_56_08___una_foto_realista_de_un_gato_burgu_s_vestido_de_traje_con_un_monoculo_bebiendo_vino)
    )


    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item{
            GaleryImage(id = idImage)
        }
        item{
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Button(onClick = { /*TODO*/ }) {
                    Text("Anterior")
                }
                Button(
                    onClick = {
                        onLogout()
                    }
                ) {
                    Text("Logout")
                }
                Button(onClick = { /*TODO*/ }) {
                    Text("Siguiente")
                }
            }
        }
    }
}

@Composable
fun GaleryImage(@DrawableRes id: Int){
    val image = painterResource(id)

    Column(
        modifier = Modifier
            .width(300.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Card(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(330.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White,
            )
        ) {
            Image(
                painter = image,
                contentDescription = stringResource(R.string.image),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
            )
        }
        Spacer(modifier = Modifier.height(40.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.LightGray,
            )
        ){
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                verticalArrangement = Arrangement.Center
            ){
                Text(
                    text = "TITULO",
                    fontSize = 22.sp,
                    fontWeight = FontWeight(200)
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "Autor",
                        fontSize = 15.sp,
                        fontWeight = FontWeight(800),
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = "ANIO",
                        fontSize = 15.sp,
                        fontWeight = FontWeight(300)
                    )
                }
            }
        }
    }

}