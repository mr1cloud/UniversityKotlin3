package com.example.universitykotlin3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.universitykotlin3.ui.theme.Shapes

import com.example.universitykotlin3.ui.theme.UniversityKotlin3ThemeNew
import com.example.universitykotlin3.ui.theme.old.UniversityKotlin3Theme

data class Bike(
    val id: Int,
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)

val bikesList = listOf(
    Bike(
        1, "Kawasaki Z650",
        "Мотоцикл создан для новичков, рекомендуем!",
        R.drawable.kawasaki_z650
    ),
    Bike(
        2,
        "Yamaha MT-07",
        "Тоже неплохой мотоцикл, с доступной ценой до 500 тыс. рублей.",
        R.drawable.yamaha_mt07
    ),
    Bike(
        3,
        "Yamaha MT-10",
        "Данный вариант создан для людей, которые откатали пару сезонов на более простом мотоцикле.",
        R.drawable.yamaha_mt10
    ),
    Bike(
        4,
        "Yamaha JX6",
        "Мощный мотоцикл, с объекмом двигателя более 600 кб. см.",
        R.drawable.yamaha_jx6
    ),
    Bike(
        5,
        "KTM Duke 390",
        "Это легкий, маневренный и мощный нейкед-байк с агрессивным дизайном.",
        R.drawable.ktm_duke_390
    )
)

class MainActivity1 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UniversityKotlin3Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Task1(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UniversityKotlin3ThemeNew {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Task2(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Task1(modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(items = bikesList) { item ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp, horizontal = 12.dp)
            ) {
                Row {
                    Image(
                        painter = painterResource(id = item.image),
                        contentDescription = item.title,
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .clip(ShapeDefaults.Medium)
                            .height(128.dp)
                            .width(128.dp)
                    )
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = item.title,
                            style = MaterialTheme.typography.titleLarge
                        )
                        Text(
                            text = item.description,
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Task1Preview() {
    UniversityKotlin3Theme {
        Task1()
    }
}

@Composable
fun Task2(modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(items = bikesList) { item ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp, horizontal = 12.dp)
            ) {
                Row {
                    Image(
                        painter = painterResource(id = item.image),
                        contentDescription = item.title,
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .clip(Shapes.medium)
                            .height(128.dp)
                            .width(128.dp)
                    )
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = item.title,
                            style = MaterialTheme.typography.titleMedium
                        )
                        Text(
                            text = item.description,
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Task2Preview() {
    UniversityKotlin3ThemeNew {
        Task2()
    }
}