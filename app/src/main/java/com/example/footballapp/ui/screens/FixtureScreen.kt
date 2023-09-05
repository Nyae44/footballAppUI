package com.example.footballapp.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.footballapp.R
import com.example.footballapp.data.FixtureRepository.leagueType
import com.example.footballapp.model.League
import com.example.footballapp.ui.theme.AppTheme


@Composable
fun FixtureScreen(modifier: Modifier = Modifier) {
    Scaffold (
        topBar = {},
        bottomBar = {},
        content = {
            Surface (
                modifier = modifier
                    .padding(it)
            ){
                Column {
                    FixtureTopBar()
                    LeagueTypeComponent()
                }

            }
        }
    )
}

@Composable
fun FixtureTopBar(modifier: Modifier = Modifier) {
    Row (
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ){
        Icon(
            painter = painterResource(id = R.drawable.arrowback),
            contentDescription = stringResource(id = R.string.arrow_back)
        )
        Text(
            text = stringResource(id = R.string.fixtures),
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.SemiBold,
            fontSize = 30.sp,
            fontStyle = FontStyle.Italic
        )
        Icon(
            painter = painterResource(id = R.drawable.search),
            contentDescription = stringResource(id = R.string.search),
            modifier = modifier
                .padding(top = 3.dp)
                .size(35.dp)
        )
    }
}
@Composable
fun FixtureBottomBar(modifier: Modifier = Modifier) {

}

@Composable
fun LeagueType(league: League,modifier: Modifier = Modifier) {
    var isSelected by remember { mutableStateOf(false) }
    val selectedLeagueIndex = remember { mutableStateOf(-1)}
    //Colors for selected and unselected color
    val selectedColor = Color.Magenta
    val unselectedColor = Color.Gray
    Row (
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 10.dp, end = 10.dp, start = 10.dp)
    ){
            FilledTonalButton(
                onClick = {
                  isSelected = !isSelected
                },
                colors = if (isSelected) ButtonDefaults.buttonColors(selectedColor) else ButtonDefaults.buttonColors(unselectedColor),
            ) {
                Text(text = stringResource(id = league.leagueName))
              }
    }
}

@Composable
fun LeagueTypeComponent(modifier: Modifier = Modifier) {
    LazyRow(){
        itemsIndexed(leagueType){index,league ->
            LeagueType(league = league)
        }
    }
}
@Composable
fun FullFixtureList(modifier: Modifier = Modifier) {

}



@Preview(showSystemUi = true, showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun FixtureScreenPreview() {
    AppTheme {
        FixtureScreen()
    }
}