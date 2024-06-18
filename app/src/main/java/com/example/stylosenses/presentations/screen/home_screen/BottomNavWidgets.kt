package com.example.stylosenses.presentations.screen.home_screen

import com.example.stylosensess.R
import com.example.stylosenses.presentations.graph.home.ShopHomeScreen

sealed class BottomNavItem(val tittle: String, val icon: Int, val route: String) {
    object HomeNav : BottomNavItem(
        tittle = "Home",
        icon = R.drawable.ic_home,
        route = ShopHomeScreen.DashboardScreen.route
    )

    object FavouriteNav : BottomNavItem(
        tittle = "Activity",
        icon = R.drawable.bill_icon,
        route = ShopHomeScreen.FavouriteScreen.route
    )

    object FeatureNav : BottomNavItem(
        tittle = "Feature",
        icon = R.drawable.phone,
        route = ShopHomeScreen.FeatureScreen.route
    )

    object ChatNav : BottomNavItem(
        tittle = "Chat",
        icon = R.drawable.chat_bubble_icon,
        route = ShopHomeScreen.ChatScreen.route
    )

    object ProfileNav : BottomNavItem(
        tittle = "Profile",
        icon = R.drawable.user_icon,
        route = ShopHomeScreen.ProfileScreen.route
    )
}
