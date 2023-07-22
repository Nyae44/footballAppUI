package com.example.footballapp.ui.screens

import android.content.res.Configuration
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.footballapp.R
import com.example.footballapp.ui.theme.AppTheme
import com.kizitonwose.calendar.compose.WeekCalendar
import com.kizitonwose.calendar.compose.weekcalendar.rememberWeekCalendarState
import com.kizitonwose.calendar.core.WeekDay
import com.kizitonwose.calendar.core.atStartOfMonth
import com.kizitonwose.calendar.core.daysOfWeek
import com.kizitonwose.calendar.core.firstDayOfWeekFromLocale
import java.time.LocalDate
import java.time.YearMonth


@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = { TopAppBar()},
        bottomBar = {},
        content = {
              Column(modifier = modifier.padding(it)) {
                CalendarComponent()
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

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CalendarComponent() {
    val currentDate = remember { LocalDate.now() }
    val currentMonth = remember { YearMonth.now() }
    val startDate = remember { currentMonth.minusMonths(100).atStartOfMonth() } // Adjust as needed
    val endDate = remember { currentMonth.plusMonths(100).atEndOfMonth() } // Adjust as needed
    val firstDayOfWeek = remember { firstDayOfWeekFromLocale() } // Available from the library
    val daysOfWeek = daysOfWeek()

    val state = rememberWeekCalendarState(
        startDate = startDate,
        endDate = endDate,
        firstVisibleWeekDate = currentDate,
        firstDayOfWeek = firstDayOfWeek,

    )

    WeekCalendar(
        state = state,
        dayContent = { Day(it) },
        monthHeader = { month -> }
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
       /** Text(
            text = stringResource(id = R.string.todays_match),
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp
        )
        Spacer(modifier = modifier.weight(1f))
        Icon(
            imageVector = Icons.Default.KeyboardArrowRight,
            contentDescription = stringResource(id = R.string.arrow_pointing_right)
        )**/
    }
}
@Composable
fun UpcomingFixtures(modifier: Modifier = Modifier) {
    
}

@Composable
fun BottomBarComponent() {

}
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Day(day: WeekDay) {
    Box(
        modifier = Modifier
            .aspectRatio(1f), // This is important for square sizing!
        contentAlignment = Alignment.Center
    ) {
        Text(text = day.date.dayOfMonth.toString())
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showSystemUi = true)
@Preview(showBackground = true, showSystemUi = true )
@Composable
fun HomeScreenPreview() {
    AppTheme {
        HomeScreen()
    }
}