package edu.pe.cibertec.appdemorest.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import edu.pe.cibertec.appdemorest.presentation.screen.HomeScreen
import edu.pe.cibertec.appdemorest.presentation.screen.PhotoGalleryScreen
import edu.pe.cibertec.appdemorest.presentation.screen.PostDetailScreen
import edu.pe.cibertec.appdemorest.presentation.screen.PostListScreen
import edu.pe.cibertec.appdemorest.presentation.screen.SplashScreen
import edu.pe.cibertec.appdemorest.presentation.screen.UserListScreen

@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = "splash"
    ) {
        composable("splash") {
            SplashScreen(
                onNavigateToHome = {
                    navController.navigate("home") {
                        popUpTo("splash") { inclusive = true }
                    }
                }
            )
        }

        composable("home") {
            HomeScreen(navController = navController)
        }

        composable("posts") {
            PostListScreen(
                onPostClick = { postId ->
                    navController.navigate("post_detail/$postId")
                }
            )
        }

        composable("post_detail/{postId}") { backStackEntry ->
            val postId = backStackEntry.arguments?.getString("postId")?.toIntOrNull() ?: 0
            PostDetailScreen(
                postId = postId,
                onBackClick = { navController.popBackStack() }
            )
        }

        composable("users") {
            UserListScreen()
        }

        composable("photos") {
            PhotoGalleryScreen()
        }
    }
}
