package com.example.footballapp.ui.screens

import android.content.Context
import android.content.res.Configuration
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.footballapp.R
import com.example.footballapp.ui.theme.AppTheme
import com.joelkanyi.horizontalcalendar.HorizontalCalendarView
import kotlin.coroutines.jvm.internal.CompletedContinuation.context


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = { TopAppBar()},
        bottomBar = {},
        content = {
              Column(modifier = modifier.padding(it)) {
                UpcomingFixturesTitle()
              }
        }
    )
}

@Composable
fun TopAppBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.padding(start = 10.dp,top = 20.dp, end = 10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Box(
            modifier = modifier
                .background(color = Color.Transparent, shape = CircleShape)
                .border(
                    border = BorderStroke(2.dp, Color.LightGray),
                    shape = CircleShape,
                )
                .size(60.dp),
            contentAlignment = Alignment.Center
        ){
            Icon(
                painter = painterResource(id = R.drawable.menu),
                contentDescription = stringResource(id = R.string.menu)
            )
        }
            Text(
                text = stringResource(id = R.string.welcome_nyae),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp,

            )
        Spacer(modifier = modifier.weight(1f))
        Box(
            modifier = modifier
                .background(color = Color.Transparent, shape = CircleShape)
                .border(
                    border = BorderStroke(2.dp, color = Color.LightGray),
                    shape = CircleShape
                )
                .size(60.dp),
            contentAlignment = Alignment.Center
        ){
            Icon(
                painter = painterResource(id = R.drawable.bell), 
                contentDescription = stringResource(id = R.string.notifications))
        }
        Box(
            modifier = modifier
                .background(color = Color.Transparent, shape = CircleShape)
                .border(
                    border = BorderStroke(2.dp, color = Color.LightGray),
                    shape = CircleShape
                )
                .size(60.dp),
            contentAlignment = Alignment.Center
        ){
            Icon(
                painter = painterResource(id = R.drawable.search),
                contentDescription = stringResource(id = R.string.search))
        }
    }
}

@Composable
fun CalendarComponent(modifier: Modifier = Modifier) {
    HorizontalCalendarView(
        onDayClick = {
             day ->
            Toast.makeText(context,day.fullDate,Toast.LENGTH_SHORT).show()
        },
        selectedCardColor = Color.Magenta,
        unSelectedCardColor = Color.Transparent,
        selectedTextColor = Color.White,
        unSelectedTextColor = Color.LightGray
    )
}

@Composable
fun LiveScoreComponent(modifier: Modifier = Modifier) {
    
}

@Composable
fun UpcomingFixturesTitle(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 10.dp)
    ) {
        // There's an Icon before the text composable
        Text(
            text = stringResource(id = R.string.todays_match),
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp
        )
        Spacer(modifier = modifier.weight(1f))
        Icon(
            imageVector = Icons.Default.KeyboardArrowRight,
            contentDescription = stringResource(id = R.string.arrow_pointing_right)
        )
    }
}
@Composable
fun UpcomingFixtures(modifier: Modifier = Modifier) {
    
}

@Composable
fun BottomBarComponent() {
    
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showSystemUi = true)
@Preview(showBackground = true, showSystemUi = true )
@Composable
fun HomeScreenPreview() {
    AppTheme {
        HomeScreen()
    }
}