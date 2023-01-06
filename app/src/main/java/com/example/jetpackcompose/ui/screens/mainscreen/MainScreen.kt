package com.example.jetpackcompose.ui.screens.mainscreen

import android.util.Log
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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
            ImageRow()
            Testsa()



    }

}

@Composable
fun ImageRow(
    modifier: Modifier = Modifier
) {
    Surface(
        shape = MaterialTheme.shapes.small,
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .width(193.dp)
                .background(Color.Yellow)
                .fillMaxWidth()
        ) {

            Image(painterResource(id =  R.drawable.pizza),
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
        modifier= modifier
            .height(120.dp)
            .background(Color.Transparent),
        rows = GridCells.Fixed(2) ){
        items(40){ items->
            ImageRow()
        }
    }

}


@Composable
fun ImageColumn(
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.background(Color.Yellow)

    ) {
        Image(
            painter = painterResource(id = R.drawable.pizza),
            contentDescription = "greece default",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(88.dp)
                .clip(CircleShape)
        )
        Text(
            text = "Evan maroge",
            style = MaterialTheme.typography.h5,
            modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 8.dp)
        )
    }
}
//grid holder
@Composable
fun StraightHolder(
modifier: Modifier = Modifier
){
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding= PaddingValues(horizontal = 16.dp),
        modifier = modifier ){
        items (30){ item->
            ImageColumn()

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
    Column(modifier = Modifier.fillMaxSize().background(Color.Transparent)) {
        Spacer(modifier = Modifier.padding(vertical = 10.dp))


        Column(modifier = Modifier.fillMaxHeight(.5f)) {
            HomeSection(R.string.app_name) {
                StraightHolder()
                Spacer(modifier = Modifier.padding(vertical = 16.dp))
                GridHolder()
            }
        }

        Spacer(modifier = Modifier.padding(vertical = 16.dp))

        Column(

            modifier = Modifier.fillMaxHeight(.5f)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Button 1")
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Button 2")
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