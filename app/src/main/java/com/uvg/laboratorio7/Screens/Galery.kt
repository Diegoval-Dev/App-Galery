package com.uvg.laboratorio7.Screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.uvg.laboratorio7.R

@Composable
fun GaleryScreen(){

}

@Composable
fun GaleryBodyContent(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

    }
}

@Composable
fun GaleryImage(@DrawableRes id: Int){
    val image = painterResource(id)
    Box(
        modifier = Modifier
            .fillMaxSize()
    ){
        Image(
            painter = image,
            contentDescription = stringResource(R.string.image),
            contentScale = ContentScale.Crop
        )
    }
}