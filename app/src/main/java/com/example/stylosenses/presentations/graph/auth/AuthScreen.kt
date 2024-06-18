package com.example.stylosenses.presentations.graph.auth

sealed class AuthScreen(val route: String) {
    object OnBoardingScreen : AuthScreen("splash_screen")
    object SignInScreen : AuthScreen("sign_in_screen")
    object SignUpScreen : AuthScreen("sign_up_screen")
    object SignInSuccess : AuthScreen("sign_success")
    object ForgetPasswordScreen : AuthScreen("forget_password_screen")
    object OTPScreen : AuthScreen("otp_screen")
}