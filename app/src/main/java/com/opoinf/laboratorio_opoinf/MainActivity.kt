package com.opoinf.laboratorio_opoinf

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.opoinf.laboratorio_opoinf.modulo.CartScreen
import com.opoinf.laboratorio_opoinf.modulo.DashboardScreen
import com.opoinf.laboratorio_opoinf.modulo.ProfileScreen
import com.opoinf.laboratorio_opoinf.ui.theme.LaboratorioOpoinfTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LaboratorioOpoinfTheme {
                MainScreen()
            }
        }
    }
}

sealed class BottomNavItem(val title: String, val icon: ImageVector, val route: String) {
    object Cart : BottomNavItem("Cart", Icons.Default.ShoppingCart, "cart")
    object Dashboard : BottomNavItem("Dashboard", Icons.Default.Home, "dashboard")
    object Profile : BottomNavItem("Profile", Icons.Default.Person, "profile")
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val items = listOf(
        BottomNavItem.Cart,
        BottomNavItem.Dashboard,
        BottomNavItem.Profile
    )

    Scaffold(
        bottomBar = { BottomNavigationBar(navController, items) }
    ) { innerPadding ->
        NavHostContainer(navController, Modifier.padding(innerPadding))
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController, items: List<BottomNavItem>) {
    NavigationBar {
        val currentRoute = currentRoute(navController)
        items.forEach { item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = item.title) },
                label = { Text(item.title) },
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Composable
fun NavHostContainer(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(navController, startDestination = BottomNavItem.Dashboard.route, modifier = modifier) {
        composable(BottomNavItem.Cart.route) { CartScreen() }
        composable(BottomNavItem.Dashboard.route) { DashboardScreen() }
        composable(BottomNavItem.Profile.route) { ProfileScreen() }
    }
}

@Composable
fun currentRoute(navController: NavHostController): String? {
    val navBackStackEntry = navController.currentBackStackEntryAsState()
    return navBackStackEntry.value?.destination?.route
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LaboratorioOpoinfTheme {
        MainScreen()
    }
}