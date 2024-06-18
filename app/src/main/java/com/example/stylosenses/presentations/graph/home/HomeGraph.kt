package com.example.stylosenses.presentations.graph.home

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.stylosenses.presentations.graph.Graph
import com.example.stylosenses.presentations.graph.detail.DetailScreen
import com.example.stylosenses.presentations.graph.detail.detailNavGraph
import com.example.stylosenses.presentations.screen.LaundryScreen
import com.example.stylosenses.presentations.screen.chat_screen.ChatScreen
import com.example.stylosenses.presentations.screen.dashboard_screen.component.DashboardScreen
import com.example.stylosenses.presentations.screen.detail_taylor_screen.component.DetailTaylorScreen
import com.example.stylosenses.presentations.screen.fav_screen.FavouriteScreen
import com.example.stylosenses.presentations.screen.ml_feature_screen.FeatureScreen
import com.example.stylosenses.presentations.screen.ml_feature_screen.FeatureScreen2
import com.example.stylosenses.presentations.screen.ml_feature_screen.FeatureScreen3
import com.example.stylosenses.presentations.screen.ml_feature_screen.FeatureScreen4
import com.example.stylosenses.presentations.screen.profile_screen.ProfileScreen
import com.example.stylosenses.presentations.screen.profile_screen.help_center_screen.HelpCenterScreen
import com.example.stylosenses.presentations.screen.profile_screen.profile_edit_user_screen.EditProfileScreen
import com.example.stylosenses.presentations.screen.profile_screen.profile_user_screen.ProfileDetailScreen
import com.example.stylosenses.presentations.screen.profile_screen.setting_screen.SettingsScreen
import com.example.stylosenses.presentations.screen.tailor_list_screen.TailorListScreen
import com.example.stylosenses.presentations.screen.taylor_screen.TaylorScreen


@Composable
fun HomeNavGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        route = Graph.HOME,
        startDestination = ShopHomeScreen.DashboardScreen.route
    ) {
        composable(ShopHomeScreen.DashboardScreen.route) {
            DashboardScreen(
                navController = navHostController
            ) { productId ->
                navHostController.navigate(DetailScreen.ProductDetailScreen.route + "/${productId}")
            }
        }
        composable(ShopHomeScreen.TailorListScreen.route) {
            TailorListScreen()
        }
        composable(ShopHomeScreen.FavouriteScreen.route) {
            FavouriteScreen()
        }
        composable(ShopHomeScreen.ChatScreen.route) {
            ChatScreen()
        }
        composable(ShopHomeScreen.EditProfileScreen.route) {
            EditProfileScreen(navController = navHostController)
        }
        composable(ShopHomeScreen.ProfileDetailScreen.route) {
            ProfileDetailScreen(navController = navHostController)
        }
        composable(ShopHomeScreen.FeatureScreen.route) {
            FeatureScreen(navController = navHostController)
        }
        composable(ShopHomeScreen.SettingsScreen.route) {
            SettingsScreen()
        }
        composable(ShopHomeScreen.HelpCenterScreen.route) {
            HelpCenterScreen()
        }
        composable(ShopHomeScreen.ProfileScreen.route) {
//            ProfileScreen() {
//                navHostController.popBackStack()
//            }
            ProfileScreen(navController = navHostController)
        }
        composable(ShopHomeScreen.FeatureScreen2.route) {
            FeatureScreen2(navController = navHostController)
        }
        composable(ShopHomeScreen.FeatureScreen3.route) {
            FeatureScreen3(navController = navHostController)
        }
        composable(ShopHomeScreen.FeatureScreen4.route) {
            FeatureScreen4(navController = navHostController)
        }
        //
        composable(ShopHomeScreen.TaylorScreen.route) {
            TaylorScreen()
        }
        composable(ShopHomeScreen.TaylorDetailScreen.route) {
            DetailTaylorScreen()
        }
        composable(ShopHomeScreen.LaundryScreen.route) {
            LaundryScreen()
        }
        //detail graph
        detailNavGraph(navController = navHostController)
    }
}