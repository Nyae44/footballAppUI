package com.example.footballapp.data

import com.example.footballapp.R
import com.example.footballapp.model.Fixture

object FixtureRepository {
    val matchFixtures = listOf<Fixture>(
        Fixture(R.string.n_forest, R.drawable.n_forest, R.string.time_1, R.string.liverpool, R.drawable.liverpool),
        Fixture(R.string.man_city,R.drawable.manchester_city_logo,R.string.time_2,R.string.brighton,R.drawable.brighton),
        Fixture(R.string.wolves,R.drawable.wolverhampton_logo,R.string.time_3,R.string.leicester,R.drawable.leicester)
    )
}