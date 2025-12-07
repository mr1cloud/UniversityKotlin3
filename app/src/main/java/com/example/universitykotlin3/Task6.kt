package com.example.universitykotlin3

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.universitykotlin3.ui.theme.old.UniversityKotlin3Theme


@Composable
fun CompactScreen(
    modifier: Modifier = Modifier,
) {
    var selectedItem by rememberSaveable { mutableStateOf<Int?>(null) }

    if (selectedItem == null) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Items",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Column {
                repeat(10) { index ->
                    Text(
                        text = "Item ${index + 1}",
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { selectedItem = index + 1 }
                            .padding(vertical = 12.dp)
                    )
                }
            }
        }
    } else {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            Button(
                onClick = { selectedItem = null },
                modifier = Modifier.padding(bottom = 16.dp)
            ) {
                Text("Back to list")
            }
            Text(
                text = "Details for item $selectedItem",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Text(
                text = "This is the detail view for the selected item.",
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}

@Composable
fun MediumScreen(
    modifier: Modifier = Modifier,
) {
    var selectedItem by rememberSaveable { mutableStateOf<Int?>(null) }

    Row(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.Top
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(0.4f)
        ) {
            Text(
                text = "Items",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            repeat(10) { index ->
                Text(
                    text = "Item ${index + 1}",
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { selectedItem = index + 1 }
                        .padding(vertical = 12.dp)
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(start = 16.dp),
            contentAlignment = Alignment.TopStart
        ) {
            if (selectedItem == null) {
                Text(
                    text = "Select an item from the list to see details",
                    color = Color.Gray
                )
            } else {
                Column {
                    Text(
                        text = "Details for item $selectedItem",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                    Text(
                        text = "This is the detail view for the selected item.",
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun ExpandedScreen(
    modifier: Modifier = Modifier,
) {
    MediumScreen(modifier = modifier)
}

@Composable
fun AdaptiveApplication(
    windowSize: WindowWidthSizeClass,
    modifier: Modifier = Modifier,
) {
    Log.d("AdaptiveApp", "Window size: $windowSize")
    when (windowSize) {
        WindowWidthSizeClass.Compact -> {
            CompactScreen(modifier = modifier)
        }

        WindowWidthSizeClass.Medium -> {
            MediumScreen(modifier = modifier)
        }

        WindowWidthSizeClass.Expanded -> {
            ExpandedScreen(modifier = modifier)
        }

        else -> {
            Text(text = "Unknown window size")
        }
    }
}

class MainActivity6 : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val windowSize = calculateWindowSizeClass(this)

            UniversityKotlin3Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AdaptiveApplication(
                        windowSize = windowSize.widthSizeClass,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}