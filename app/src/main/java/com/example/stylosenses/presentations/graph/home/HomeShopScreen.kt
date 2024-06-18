package com.example.stylosenses.presentations.graph.home

sealed class ShopHomeScreen(val route: String) {
    object DashboardScreen : ShopHomeScreen("dashboard_screen")
    object ChatScreen : ShopHomeScreen("conversation_screen")
    object EditProfileScreen : ShopHomeScreen("edit_profile_screen")
    object ProfileScreen : ShopHomeScreen("profile_screen")
    object FavouriteScreen : ShopHomeScreen("favourite_screen")
    object TailorListScreen : ShopHomeScreen("tailor_list_screen")


    object ProfileDetailScreen : ShopHomeScreen("profile_detail_screen")
    object SettingsScreen : ShopHomeScreen("settings_screen")
    object NotificationScreen : ShopHomeScreen("notification_screen")
    object HelpCenterScreen : ShopHomeScreen("help_center_screen")
    object LogoutScreen : ShopHomeScreen("logout_screen")
    // Feature Screen
    object FeatureScreen : ShopHomeScreen("feature_screen")

    object FeatureScreen2 : ShopHomeScreen("feature_screen_2")
    object FeatureScreen3 : ShopHomeScreen("feature_screen_3")
    object FeatureScreen4 : ShopHomeScreen("feature_screen_4")
    //Taylor&Laundry
    object TaylorScreen : ShopHomeScreen("taylor_screen")
    object LaundryScreen : ShopHomeScreen("laundry_screen")
    object TaylorDetailScreen : ShopHomeScreen("detail_taylor")
    object LaundryDetailScreen : ShopHomeScreen("detail_laundry")
//    object FeatureScreen4 : ShopHomeScreen("feature_screen_4")
}
