package com.example.stylosenses.presentations.screen.forget_screen

import android.util.Patterns
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.stylosensess.R
import com.example.stylosenses.presentations.commons.widgets.CustomDefaultBtn
import com.example.stylosenses.presentations.commons.widgets.CustomTextField
import com.example.stylosenses.presentations.commons.widgets.DefaultBackArrow
import com.example.stylosenses.presentations.graph.auth.AuthScreen


@Composable
fun ForgetPasswordScreen(navController: NavController) {
    var email: String = ""
    val emailErrorState = remember {
        mutableStateOf(false)
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        )
        {

            Box(modifier = Modifier.weight(0.3f)) {
                DefaultBackArrow() {
                    navController.popBackStack()
                }
            }
            Box(
                modifier = Modifier.weight(1.0f)) {
                Text(
                    text = "Forget Password",
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center
                )
            }


        }
        Spacer(modifier = Modifier.height(50.dp))
        Text(text = "Forget Password", fontSize = 26.sp, fontWeight = FontWeight.Bold)
        Text(
            text = "Please enter your email and we will send\nyou a link to return your account",
            color = Color.Black,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(150.dp))
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 50.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            CustomTextField(
                placeholder = "example@email.com",
                trailingIcon = R.drawable.mail,
                label = "Email",
                errorState = emailErrorState,
                keyboardType = KeyboardType.Email,
                visualTransformation = VisualTransformation.None,
                onChanged = { newEmail ->
                    //     email = newEmail
                }
            )

            CustomDefaultBtn(shapeSize = 50f, btnText = "Continue") {
                //email pattern
                val pattern = Patterns.EMAIL_ADDRESS
                val isEmailValid = pattern.matcher(email).matches()
                emailErrorState.value = !isEmailValid
                if (isEmailValid) {
                    navController.popBackStack()
                    navController.navigate(AuthScreen.SignInScreen.route)
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp, bottom = 30.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text = "Don't have an account? ", color = Color.Black)
                Text(
                    text = "Sign Up",
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.clickable {
                        navController.navigate(AuthScreen.SignUpScreen.route)
                    })
            }
        }


    }
}