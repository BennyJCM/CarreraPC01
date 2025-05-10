package esan.carrera.pc01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import esan.carrera.pc01.screen.PantallaMenu
import esan.carrera.pc01.screen.CalculadoraEdadScreen
import esan.carrera.pc01.screen.ConversorDivisasScreen
import esan.carrera.pc01.screen.CatalogoProductosScreen
import esan.carrera.pc01.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Para diseño sin bordes
        setContent {
            MyApplicationTheme {
                // Controlador de navegación
                val navController = rememberNavController()

                // Usamos Scaffold para la estructura de la pantalla
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // NavHost para gestionar la navegación entre las pantallas
                    NavHost(
                        navController = navController,
                        startDestination = "menu", // Pantalla inicial
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable("menu") { PantallaMenu(navController) }
                        composable("edad_perro") { CalculadoraEdadScreen() }
                        composable("conversor_divisas") { ConversorDivisasScreen() }
                        composable("catalogo") { CatalogoProductosScreen() }
                    }
                }
            }
        }
    }
}