package com.example.jetpackcompose.ui.screens.mainscreen

import android.util.Log
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.jetpackcompose.Greeting
import com.example.jetpackcompose.R
import com.example.jetpackcompose.navigation.Screen
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme
import java.util.*

@Composable
fun MainScreen( navController: NavHostController){


    Column() {

        Text(text = "Rocky")

        Button(onClick = {
            navController.navigate(route = Screen.ElectionData.route)
        }) {
            Text(text = "Go to next Screen")

        }

    }

}

@Composable
fun ImageRow(
    modifier: Modifier = Modifier
) {
    Surface(
        shape = MaterialTheme.shapes.small,
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.width(193.dp)
        ) {

            Image(painterResource(id =  R.drawable.ic_launcher_foreground2),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = modifier.size(56.dp)
                )
            Text(
                text = "Evan ",
                style = MaterialTheme.typography.h3,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }

    }
}

//grid holder
@Composable
fun GridHolder(
    modifier: Modifier = Modifier){
    LazyHorizontalGrid(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
        ,
        contentPadding = PaddingValues(horizontal = 16.dp)
        ,
        modifier= modifier.height(120.dp),
        rows = GridCells.Fixed(2) ){
        items(40){ items->
            ImageRow()
        }
    }

}


@Composable
fun HomeSection(
    @StringRes title:Int,
    modifier: Modifier = Modifier,
    content: @Composable ()->Unit
){
    Column(modifier) {
        Text(
            stringResource(id = title).uppercase(Locale.getDefault()),
            style = MaterialTheme.typography.h6,
            modifier = Modifier
                .paddingFromBaseline(top = 40.dp, bottom = 8.dp)
                .padding(horizontal = 17.dp)
        )
        content()
    }
}



@Composable
fun Testsa(
){
    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.padding(vertical = 10.dp))


        Column(modifier = Modifier.fillMaxHeight(.5f)) {
            HomeSection(R.string.app_name) {
                GridHolder()
            }
        }

//        Spacer(modifier = Modifier.padding(vertical = 16.dp))

        Column(modifier = Modifier.fillMaxHeight(.5f)) {
            HomeSection(R.string.app_name) {
                GridHolder()
            }
        }


    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeTheme {
        Column() {
            ImageRow()
            Testsa()
        }

    }
}