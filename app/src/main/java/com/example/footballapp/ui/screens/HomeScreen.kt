package com.example.footballapp.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.footballapp.R
import com.example.footballapp.ui.theme.AppTheme
import com.kizitonwose.calendar.compose.WeekCalendar
import com.kizitonwose.calendar.compose.weekcalendar.rememberWeekCalendarState
import com.kizitonwose.calendar.core.WeekDay
import com.kizitonwose.calendar.core.WeekDayPosition
import com.kizitonwose.calendar.core.atStartOfMonth
import com.kizitonwose.calendar.core.daysOfWeek
import com.kizitonwose.calendar.core.firstDayOfWeekFromLocale
import java.text.SimpleDateFormat
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.TextStyle
import java.util.Date
import java.util.Locale

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = { TopAppBar()},
        bottomBar = {},
        content = {
              Column(modifier = modifier.padding(it)) {
                CurrentDate()
                CalendarComponent()
                LiveScoreComponentTitle()
                LiveScoreComponent()
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
fun CurrentDate(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 20.dp, start = 10.dp)
    ) {
        val sdf = SimpleDateFormat(" ' 'dd-MM-yyyy ' 'HH:mm:ss z ")
        val currentDateAndTime = sdf.format(Date())
        Icon(
            imageVector = Icons.Default.DateRange,
            contentDescription = stringResource(id = R.string.today_date)
        )
        Text(
            text = currentDateAndTime,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold
        )
    }
}
@Composable
fun CalendarComponent(modifier : Modifier = Modifier) {
    Column(modifier = modifier.padding(top = 20.dp)) {
        val currentDate = remember { LocalDate.now() }
        val currentMonth = remember { YearMonth.now() }
        val startDate =
            remember { currentMonth.minusMonths(100).atStartOfMonth() } // Adjust as needed
        val endDate = remember { currentMonth.plusMonths(100).atEndOfMonth() } // Adjust as needed
        val firstDayOfWeek = remember { firstDayOfWeekFromLocale() } // Available from the library
        var selectedDate by remember { mutableStateOf<LocalDate?>(null) }
        val daysOfWeek = remember { daysOfWeek() }


        val state = rememberWeekCalendarState(
            startDate = startDate,
            endDate = endDate,
            firstVisibleWeekDate = currentDate,
            firstDayOfWeek = daysOfWeek.first(),

            )


        DaysOfWeekTitle(daysOfWeek = daysOfWeek)
        WeekCalendar(
            state = state,
            dayContent = { day ->
                Day(day = day, isSelected = selectedDate == day.date) { day ->
                    selectedDate = if (selectedDate == day.date) null else day.date
                }
            },
            weekHeader = { month ->
                val daysOfWeek = month.days.map { it.date.dayOfWeek }
            }
        )
    }
}

@Composable
fun LiveScoreComponentTitle(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 20.dp, start = 10.dp)
    ) {
        // There's an Icon before the text composable
        Text(
            text = stringResource(id = R.string.live_match),
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp
        )
        Spacer(modifier = modifier.weight(1f))
        Icon(
            imageVector = Icons.Default.KeyboardArrowRight,
            contentDescription = stringResource(id = R.string.arrow_pointing_right),
            modifier = modifier.padding(end = 20.dp)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LiveScoreComponent(modifier: Modifier = Modifier) {
     Box(
    modifier = modifier
        .padding(top = 20.dp, start = 20.dp, end = 20.dp)
        .clip(RoundedCornerShape(15.dp))
        .size(700.dp),

    ) {
    Image(
    painter = painterResource(id = R.drawable.epl_background),
    contentDescription = stringResource(id = R.string.epl_background),
    modifier = modifier.blur(5.dp)
    )
    Column(modifier = modifier) {
        Column(
            modifier = modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.stamford_bridge),
                style = MaterialTheme.typography.titleMedium,
                modifier = modifier.padding(top = 10.dp),
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )
            Text(
                text = stringResource(id = R.string.week_10),
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Light,
                color = Color.White
            )


        }
        Row(
            modifier = modifier.fillMaxWidth(),
        ) {
            Column(
                modifier = modifier.padding(start = 10.dp),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Row() {
                    Image(
                        painter = painterResource(id = R.drawable.chelsea),
                        contentDescription = stringResource(id = R.string.chelsea),
                        modifier = modifier.size(80.dp)
                    )
                }

                Text(
                    text = stringResource(id = R.string.chelsea),
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold,
                    modifier = modifier.padding(start = 10.dp),
                    color = Color.White
                )
                Text(
                    text = stringResource(id = R.string.home),
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.SemiBold,
                    fontStyle = FontStyle.Italic,
                    modifier = modifier.padding(start = 25.dp),
                    color = Color.White
                )

            }
            Text(
                text = stringResource(id = R.string.result),
                style = MaterialTheme.typography.headlineLarge,
                color = Color.White,
                modifier = modifier.padding(start = 64.dp, top = 40.dp)
                    .background(Color.Black, shape = RectangleShape)
                )
            Spacer(modifier = modifier.weight(1f))
          Column(
              modifier = modifier.padding(end = 10.dp),
              verticalArrangement = Arrangement.SpaceEvenly
          ) {
              Image(
                  painter = painterResource(id = R.drawable.manchester_united),
                  contentDescription = stringResource(id = R.string.manchester_united),
                  modifier = Modifier.size(80.dp)
              )
                  Text(
                      text = stringResource(id = R.string.manchester_united),
                      style = MaterialTheme.typography.titleMedium,
                      fontWeight = FontWeight.SemiBold,
                      color = Color.White
                  )
                  Text(
                      text = stringResource(id = R.string.away),
                      style = MaterialTheme.typography.bodySmall,
                      fontWeight = FontWeight.SemiBold,
                      modifier = modifier.padding(start = 25.dp),
                      color = Color.White
                  )

          }

        }
        Text(
            text = stringResource(id = R.string.match_time),
            color = Color.Green,
            modifier = modifier.padding(start = 155.dp)
        )
    }
 }
}


@Composable
fun UpcomingFixturesTitle(modifier: Modifier = Modifier) {

}
@Composable
fun UpcomingFixtures(modifier: Modifier = Modifier) {

}

@Composable
fun BottomBarComponent() {

}
@Composable
fun Day(day: WeekDay,isSelected:Boolean, onClick:(WeekDay) -> Unit) {
    Box(
        modifier = Modifier
            .aspectRatio(1f)
            .clip(RectangleShape)
            .background(color = if (isSelected) Color.Magenta else Color.Transparent)
            .clickable(
                enabled = day.position == WeekDayPosition.RangeDate,
                onClick = { onClick(day) }
            ), // This is important for square sizing!
        contentAlignment = Alignment.Center
    ) {
        Text(text = day.date.dayOfMonth.toString())
    }
}

@Composable
fun DaysOfWeekTitle(daysOfWeek: List<DayOfWeek>) {
    Row(modifier = Modifier.fillMaxWidth()) {
        for (dayOfWeek in daysOfWeek){
            Text(
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center,
                text = dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.getDefault()))
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showSystemUi = true)
@Preview(showBackground = true, showSystemUi = true )
@Composable
fun HomeScreenPreview() {
    AppTheme {
        HomeScreen()
    }
}