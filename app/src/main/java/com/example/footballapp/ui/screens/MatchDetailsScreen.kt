package com.example.footballapp.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.footballapp.R

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
            }
        }
    )
}
@Composable
fun TopBarComponent(modifier: Modifier = Modifier) {
    Row (
        modifier = modifier
            .padding(start = 10.dp),
        horizontalArrangement = Arrangement.spacedBy(15.dp)
    ){
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = stringResource(id = R.string.arrow_back)
        )
        Text(
            text = stringResource(id = R.string.match_details),
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Preview(name = "dark theme", uiMode = Configuration.UI_MODE_NIGHT_YES, showSystemUi = true, showBackground = true)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MatchDetailsPreview() {
    MatchDetailsScreen()
}