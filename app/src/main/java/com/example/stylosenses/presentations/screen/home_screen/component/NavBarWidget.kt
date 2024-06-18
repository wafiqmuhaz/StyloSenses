package com.example.stylosenses.presentations.screen.home_screen.component

import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.BottomNavigation
//import androidx.compose.material.BottomNavigationItem
//import androidx.compose.material.Icon
//import androidx.compose.material.MaterialTheme
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.stylosenses.commons.Constrains
import com.example.stylosenses.presentations.graph.detail.DetailScreen
import com.example.stylosenses.presentations.graph.home.ShopHomeScreen
import com.example.stylosenses.presentations.screen.home_screen.BottomNavItem


@Composable
fun NavigationBarWidgets(
    navController: NavController,
    isVisible: (Boolean) -> Unit,
) {
    val navItemList = listOf(
        BottomNavItem.HomeNav,
        BottomNavItem.FavouriteNav,
        BottomNavItem.FeatureNav,
        BottomNavItem.ChatNav,
        BottomNavItem.ProfileNav,
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    var bottomNavVisibility by remember { mutableStateOf<Boolean>(true) }

    if (bottomNavVisibility) {
        NavigationBar(
//            backgroundColor = Color.White,
            modifier = Modifier
                .background(color = Color.White)
                .shadow(
                    shape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp),
                    elevation = 12.dp,
                )
                .clip(RoundedCornerShape(topEnd = 10.dp, topStart = 10.dp))


        ) {
            navItemList.forEach { screen ->
                NavigationBarItem(
                    selected = navBackStackEntry?.destination?.route == screen.route,
                    icon = {
                        Icon(
                            painter = painterResource(id = screen.icon),
                            contentDescription = null,
                            tint = if (navBackStackEntry?.destination?.route == screen.route) MaterialTheme.colorScheme.primary else LocalContentColor.current,
                        )
                    },
                      label = { Text(text = screen.tittle) },
                    onClick = {
                        navController.navigate(screen.route)
                    },
//                    unselectedContentColor = MaterialTheme.colorScheme.background,
                )
            }
        }
    }

    //hide topBar
    when (navBackStackEntry?.destination?.route) {
        ShopHomeScreen.DashboardScreen.route -> {
            bottomNavVisibility = true
            isVisible(true)
        }
        ShopHomeScreen.FavouriteScreen.route -> {
            bottomNavVisibility = true
            isVisible(true)
        }
        DetailScreen.ProductDetailScreen.route + "/{${Constrains.PRODUCT_ID_PARAM}}" -> {

            bottomNavVisibility = false
            isVisible(false)
        }
        DetailScreen.CartScreen.route -> {
            bottomNavVisibility = false
            isVisible(false)
        }
        DetailScreen.NotificationScreen.route -> {
            bottomNavVisibility = false
            isVisible(false)
        }
        else -> {
            bottomNavVisibility = true
            isVisible(false)
        }
    }


}