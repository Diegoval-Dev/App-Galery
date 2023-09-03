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

val mutableListOfPersons = mutableListOf(ArtImage("Diru","Ruth","(2022)", R.drawable.spiralbetty_1667763462561),
    ArtImage("Burgues Cat 1", "Diego", "(2021)" , R.drawable.dall_e_2023_04_03_19_56_08___una_foto_realista_de_un_gato_burgu_s_vestido_de_traje_con_un_monoculo_bebiendo_vino),
    ArtImage("Gurgues Cat 2", "Josue", "(2020)", R.drawable.dall_e_2023_04_03_19_59_43___cat_dressed_in_a_suit_drinking_wine___cinematic__photoshoot__shot_on_25mm_lens__depth_of_field__dof__tilt_blur__shutter_speed_1_1000__f_22__white_bala),
    ArtImage("Cat Style","Fernando","(1455)", R.drawable.dall_e_2023_04_03_19_59_52___cat_dressed_in_a_suit_drinking_wine___cinematic__photoshoot__shot_on_25mm_lens__depth_of_field__dof__tilt_blur__shutter_speed_1_1000__f_22__white_bala),
    ArtImage("Capy", "Josh", "(455 B.C.)", R.drawable.dall_e_2023_01_27_09_19_50___una_foto_realista_de_un_capibara_burgu_s_vestido_de_traje_con_un_monoculo_bebiendo_vino),
    ArtImage("Style Capy", "Andres", "(4155 B.C.)",R.drawable.dall_e_2023_04_03_19_50_13___a_photo_of_a_bourgeois_capybara__dressed_in_18th_century_costume_drinking_wine__cinematic__photoshoot__shot_on_25mm_lens__depth_of_field__dof__tilt_bl)
)

@Composable
fun GaleryBodyContent( navController: NavController, onLogout: () -> Unit){
    var numberArt by remember { mutableStateOf( 0) }
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item{
            GaleryImage(id =  mutableListOfPersons[numberArt].idImage, title = mutableListOfPersons[numberArt].name, author = mutableListOfPersons[numberArt].author, year = mutableListOfPersons[numberArt].year)
        }
        item{
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Button(
                    onClick = {
                        numberArt = (numberArt - 1 + mutableListOfPersons.size) % mutableListOfPersons.size
                    }
                ) {
                    Text("Anterior")
                }
                Button(
                    onClick = {
                        onLogout()
                    }
                ) {
                    Text("Logout")
                }
                Button(
                    onClick = {
                        numberArt = (numberArt + 1) % mutableListOfPersons.size
                    }
                ) {
                    Text("Siguiente")
                }
            }
        }
    }
}

@Composable
fun GaleryImage(@DrawableRes id: Int, title: String, author: String, year: String){
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