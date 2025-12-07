package com.example.universitykotlin3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.universitykotlin3.ui.theme.old.UniversityKotlin3Theme
import kotlinx.serialization.Serializable

@Serializable
object LoginScreen

@Serializable
object SignUpScreen

class LoginViewModel : ViewModel() {
    val login = mutableStateOf("")
    val password = mutableStateOf("")
    val passwordVisibility = mutableStateOf(false)
}

class SignUpViewModel : ViewModel() {
    val firstName = mutableStateOf("")
    val lastName = mutableStateOf("")
    val email = mutableStateOf("")
    val password = mutableStateOf("")
    val passwordVisibility = mutableStateOf(false)
}

@Composable
fun Login(
    modifier: Modifier = Modifier,
    navHostController: NavHostController = rememberNavController(),
    loginViewModel: LoginViewModel = viewModel()
) {
    val icon = if (loginViewModel.passwordVisibility.value)
        painterResource(id = R.drawable.visible_on)
    else
        painterResource(id = R.drawable.visible_off)


    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Text(
            text = "Hello Again!",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
        )
        Text(
            text = "Welcome Back you've been missed",
            modifier = Modifier
                .padding(bottom = 25.dp)
        )
        OutlinedTextField(
            value = loginViewModel.login.value,
            onValueChange = { loginViewModel.login.value = it },
            label = { Text("Login") },
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color(0xFF913C8A),
                focusedContainerColor = Color.White,
                unfocusedIndicatorColor = Color.Gray
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text
            ),
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp, bottom = 25.dp)
        )
        OutlinedTextField(
            value = loginViewModel.password.value,
            onValueChange = { loginViewModel.password.value = it },
            label = { Text("Password") },
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color(0xFF913C8A),
                focusedContainerColor = Color.White,
                unfocusedIndicatorColor = Color.Gray
            ),
            trailingIcon = {
                IconButton(onClick = {
                    loginViewModel.passwordVisibility.value = !loginViewModel.passwordVisibility.value
                }) {
                    Icon(
                        painter = icon,
                        contentDescription = "Visibility Icon"
                    )
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            visualTransformation = if (loginViewModel.passwordVisibility.value) VisualTransformation.None
            else PasswordVisualTransformation(),
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp, bottom = 25.dp)
        )
        Box(
            contentAlignment = Alignment.CenterEnd,
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 10.dp, bottom = 25.dp)
        ) {
            Text(
                text = "Forgot Password?",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Button(
            onClick = {},
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF913C8A)
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(start = 10.dp, end = 10.dp)
        ) {
            Text(text = "Log In")
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
        ) {
            Text(
                text = "Don't have an account?",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = " Sign Up",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF913C8A),
                modifier = Modifier
                    .clickable(
                        onClick = {
                            navHostController.navigate(SignUpScreen)
                        }
                    )
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginPreview() {
    UniversityKotlin3Theme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Login(
                modifier = Modifier
                    .padding(top = 100.dp)
                    .padding(innerPadding),
                navHostController = rememberNavController()
            )
        }
    }
}

@Composable
fun SignUp(
    modifier: Modifier = Modifier,
    navHostController: NavHostController = rememberNavController(),
    signUpViewModel: SignUpViewModel = viewModel()
) {
    val icon = if (signUpViewModel.passwordVisibility.value)
        painterResource(id = R.drawable.visible_on)
    else
        painterResource(id = R.drawable.visible_off)


    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Text(
            text = "Welcome!",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
        )
        Text(
            text = "Register an account with Us",
            modifier = Modifier
                .padding(bottom = 25.dp)
        )
        OutlinedTextField(
            value = signUpViewModel.firstName.value,
            onValueChange = { signUpViewModel.firstName.value = it },
            label = { Text("First name") },
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color(0xFF913C8A),
                focusedContainerColor = Color.White,
                unfocusedIndicatorColor = Color.Gray
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text
            ),
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp, bottom = 10.dp)
        )
        OutlinedTextField(
            value = signUpViewModel.lastName.value,
            onValueChange = { signUpViewModel.lastName.value = it },
            label = { Text("Last name") },
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color(0xFF913C8A),
                focusedContainerColor = Color.White,
                unfocusedIndicatorColor = Color.Gray
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text
            ),
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp, bottom = 10.dp)
        )
        OutlinedTextField(
            value = signUpViewModel.email.value,
            onValueChange = { signUpViewModel.email.value = it },
            label = { Text("Enter Email") },
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color(0xFF913C8A),
                focusedContainerColor = Color.White,
                unfocusedIndicatorColor = Color.Gray
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text
            ),
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp, bottom = 10.dp)
        )
        OutlinedTextField(
            value = signUpViewModel.password.value,
            onValueChange = { signUpViewModel.password.value = it },
            label = { Text("Password") },
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color(0xFF913C8A),
                focusedContainerColor = Color.White,
                unfocusedIndicatorColor = Color.Gray
            ),
            trailingIcon = {
                IconButton(onClick = {
                    signUpViewModel.passwordVisibility.value = !signUpViewModel.passwordVisibility.value
                }) {
                    Icon(
                        painter = icon,
                        contentDescription = "Visibility Icon"
                    )
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            visualTransformation = if (signUpViewModel.passwordVisibility.value) VisualTransformation.None
            else PasswordVisualTransformation(),
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp, bottom = 25.dp)
        )
        Button(
            onClick = {},
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF913C8A)
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(start = 10.dp, end = 10.dp)
        ) {
            Text(text = "Log In")
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
        ) {
            Text(
                text = "Already have an account?",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = " Login",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF913C8A),
                modifier = Modifier
                    .clickable(
                        onClick = {
                            navHostController.navigate(LoginScreen)
                        }
                    )
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SignUpPreview() {
    UniversityKotlin3Theme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            SignUp(
                modifier = Modifier
                    .padding(top = 100.dp)
                    .padding(innerPadding)
            )
        }
    }
}

@Composable
fun AuthNavHost(
    modifier: Modifier = Modifier,
    navHostController: NavHostController = rememberNavController()
) {
    Scaffold(
        modifier = modifier
    ) { innerPadding ->
        NavHost(navHostController, startDestination = LoginScreen) {
            composable<LoginScreen> {
                Login(
                    modifier = Modifier
                        .padding(innerPadding)
                        .padding(top = 100.dp),
                    navHostController = navHostController
                )
            }
            composable<SignUpScreen> {
                SignUp(
                    modifier = Modifier
                        .padding(innerPadding)
                        .padding(top = 100.dp),
                    navHostController = navHostController
                )
            }
        }
    }
}

class MainActivity5 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UniversityKotlin3Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AuthNavHost(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}