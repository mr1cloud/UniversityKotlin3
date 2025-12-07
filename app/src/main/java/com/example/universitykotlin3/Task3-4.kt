package com.example.universitykotlin3

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.universitykotlin3.ui.theme.old.UniversityKotlin3Theme

class MainActivity3 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("MainActivity3", "onCreate called")

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UniversityKotlin3Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Task3(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    override fun onStart() {
        Log.d("MainActivity3", "onStart called")
        super.onStart()
    }

    override fun onResume() {
        Log.d("MainActivity3", "onResume called")
        super.onResume()
    }

    override fun onPause() {
        Log.d("MainActivity3", "onPause called")
        super.onPause()
    }

    override fun onStop() {
        Log.d("MainActivity3", "onStop called")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d("MainActivity3", "onDestroy called")
        super.onDestroy()
    }
}

@Composable
fun Task3(modifier: Modifier = Modifier) {
    Text(
        text = "Task 3",
        modifier = modifier
    )
}

class CounterViewModel : ViewModel() {
    val count: MutableState<Int> = mutableIntStateOf(0)

    fun increment() {
        count.value++
    }

    fun decrement() {
        count.value--
    }
}

class MainActivity4 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UniversityKotlin3Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Task4(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Task4(
    modifier: Modifier = Modifier,
    counterViewModel: CounterViewModel = viewModel()
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Count: ${counterViewModel.count.value}")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { counterViewModel.increment() }) {
            Text(text = "Increment")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { counterViewModel.decrement() }) {
            Text(text = "Decrement")
        }
    }
}

