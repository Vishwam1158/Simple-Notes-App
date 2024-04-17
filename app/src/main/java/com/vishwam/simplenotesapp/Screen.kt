package com.vishwam.simplenotesapp

import android.health.connect.datatypes.ExerciseRoute

// if class is sealed other can't inherit it
sealed class Screen(val route: String) {
    object HomeScreen: Screen("home")
    object AddScreen: Screen("add")
}