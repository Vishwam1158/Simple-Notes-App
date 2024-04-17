package com.vishwam.simplenotesapp

import android.app.Activity
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.IconButton
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat.finishAffinity

// for top app bar
@Composable
fun  AppBarView(
    title: String,
    onBackNavClicked: () -> Unit = {}
) {
    val navigationIcon : (@Composable () -> Unit)? =
        {
            if(!title.contains("Notes")){
                IconButton(onClick = { onBackNavClicked() }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack, // Auto mirror for some language that uses right to left writing, so showing theme mirror icons
                        tint = Color.White,
                        contentDescription = "Back Arrow  Icon"
                    )
                }
            }
            else{
               null
            }

    }
    
    TopAppBar(
        title = {
            Text(text = title, 
                color = colorResource(id = R.color.white),
                modifier = Modifier
                    .padding(start = 4.dp)
                    .heightIn(max = 24.dp) // Content's max height is 24 dp
            )
        },
        elevation = 3.dp,
        backgroundColor = colorResource(id = R.color.app_bar_color),
        navigationIcon = navigationIcon
        
    )
}