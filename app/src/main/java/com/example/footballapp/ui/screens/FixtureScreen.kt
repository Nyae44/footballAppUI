package com.example.footballapp.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
    Row (
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 10.dp, end = 10.dp, start = 10.dp)
    ){
        Card(
            modifier = modifier
        ) {
            FilledTonalButton(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(Color.Magenta)
            ) {
                Text(text = stringResource(id = league.leagueName))
            }
        }
    }
}

@Composable
fun LeagueTypeComponent(modifier: Modifier = Modifier) {
    LazyRow(){
        items(leagueType){league ->
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
    FixtureScreen()
}