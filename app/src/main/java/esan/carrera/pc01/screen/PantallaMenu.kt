package esan.carrera.pc01.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun PantallaMenu(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { navController.navigate("edad_perro") }) {
            Text("Calculadora de Edad Canina")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate("conversor_divisas") }) {
            Text("Conversor de Divisas")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate("catalogo") }) {
            Text("Catálogo de Productos")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPantallaMenu() {
    // Aquí podemos ver cómo se ve la PantallaMenu en la vista previa
    PantallaMenu(navController = rememberNavController())
}
