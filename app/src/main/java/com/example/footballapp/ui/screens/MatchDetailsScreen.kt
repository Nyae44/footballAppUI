package com.example.footballapp.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.footballapp.R
import com.example.footballapp.ui.theme.AppTheme

@Composable
fun MatchDetailsScreen(modifier: Modifier = Modifier) {
    Scaffold (
        topBar = {},
        bottomBar = {},
        content = {
            Surface(
                modifier = modifier
                    .padding(it)
            ) {
                TopBarComponent()
                StatsHeadline()
                MatchStats()

            }
        }
    )
}
@Composable
fun TopBarComponent(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp, top = 10.dp)
            .clip(RoundedCornerShape(15.dp)),
    ) {
        Image(
            painter = painterResource(id = R.drawable.epl_background),
            contentDescription = stringResource(id = R.string.epl_background),
        )
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(start = 10.dp, top = 15.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Icon(
                painter = painterResource(id = R.drawable.left_arrow),
                contentDescription = stringResource(id = R.string.arrow_back),
                tint = Color.White
            )
            Text(
                text = stringResource(id = R.string.match_details),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.SemiBold,
                color = Color.White,
                modifier = modifier
                    .padding(top = 5.dp)
            )
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = stringResource(id = R.string.more_vert),
                modifier = modifier
                    .padding(top = 10.dp),
                tint = Color.White
            )
        }
      Card(
          modifier = modifier
              .align(Alignment.Center)
              .padding(top = 120.dp, end = 20.dp, start = 20.dp)
              .clip(RoundedCornerShape(15.dp))
              .background(Color.White),
          shape = RectangleShape
      ) {
        Column(
            modifier = modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.stamford_bridge),
                style = MaterialTheme.typography.titleMedium,
                modifier = modifier.padding(top = 10.dp),
                fontWeight = FontWeight.SemiBold,

            )
            Text(
                text = stringResource(id = R.string.week_10),
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Light,
            )
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
                    )
                    Text(
                        text = stringResource(id = R.string.home),
                        style = MaterialTheme.typography.bodySmall,
                        fontWeight = FontWeight.SemiBold,
                        fontStyle = FontStyle.Italic,
                        modifier = modifier.padding(start = 25.dp),

                    )

                }
                Text(
                    text = stringResource(id = R.string.result),
                    style = MaterialTheme.typography.headlineLarge,
                    color = Color.White,
                    modifier = modifier
                        .padding(start = 64.dp, top = 40.dp)
                        .background(Color(0xFF5C075F), shape = RectangleShape)
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

                    )
                    Text(
                        text = stringResource(id = R.string.away),
                        style = MaterialTheme.typography.bodySmall,
                        fontWeight = FontWeight.SemiBold,
                        modifier = modifier.padding(start = 25.dp),

                    )
                }

            }
            Row {
                Text(
                    text = stringResource(id = R.string.match_time),
                    modifier = modifier
                        .padding(bottom = 10.dp)
                )
            }
        }
            }
        }
      }

@Composable
fun StatsHeadline(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 340.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        FilledTonalButton(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(Color.Gray)
        ) {
            Text(
                text = stringResource(id = R.string.stats),
                style = MaterialTheme.typography.titleMedium
            )
        }
        FilledTonalButton(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(Color.Gray)
        ) {
            Text(
                text = stringResource(id = R.string.line_ups),
                style = MaterialTheme.typography.titleMedium
            )
        }
        FilledTonalButton(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(Color.Gray)
        ) {
            Text(
                text = stringResource(id = R.string.summary),
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}
@Composable
fun MatchStats(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .padding(top = 400.dp,start = 20.dp, end = 20.dp)
    ) {
        Column(
            modifier = modifier
                .padding(top = 5.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            Row (
                modifier = modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ){
                Text(
                    text = stringResource(id = R.string.shots_on_target_1),
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = stringResource(id = R.string.shots_on_target),
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = stringResource(id = R.string.shots_on_target_2),
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(end = 20.dp),
                horizontalArrangement = Arrangement.End
            ) {
                LinearProgressIndicator(progress = 1f)
            }
            Row (
                modifier = modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ){
                Text(
                    text = stringResource(id = R.string.shots_1),
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold
                )

                Text(
                    text = stringResource(id = R.string.shots),
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold
                )

                Text(
                    text = stringResource(id = R.string.shots_2),
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold,
                )
            }
            Row(
                modifier = modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {

            }
        }
    }
}

@Preview( uiMode = Configuration.UI_MODE_NIGHT_YES, showSystemUi = true, showBackground = true)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MatchDetailsPreview() {
    AppTheme {
        MatchDetailsScreen()
    }
}