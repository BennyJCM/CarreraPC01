package esan.carrera.pc01.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CalculadoraEdadScreen() {
    // Usando mutableStateOf para las variables
    var edadPerro by remember { mutableStateOf("") }
    var tamanoPerro by remember { mutableStateOf("Pequeño") }
    var resultado by remember { mutableStateOf(0) }

    // Lógica para calcular la edad en años perro
    fun calcularEdad() {
        val edad = edadPerro.toIntOrNull()
        if (edad != null && edad > 0) {
            resultado = when (tamanoPerro) {
                "Pequeño" -> edad * 5
                "Mediano" -> edad * 6
                "Grande" -> edad * 7
                else -> 0
            }
        } else {
            resultado = 0
        }
    }

    // Layout de la pantalla
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Calculadora de Edad Canina", style = MaterialTheme.typography.headlineLarge)

        Spacer(modifier = Modifier.height(16.dp))

        // Campo para ingresar la edad en años humanos
        OutlinedTextField(
            value = edadPerro,
            onValueChange = { edadPerro = it },
            label = { Text("Edad en años humanos") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Menú desplegable para seleccionar el tamaño del perro
        var expanded by remember { mutableStateOf(false) }
        Box(modifier = Modifier.fillMaxWidth()) {
            TextButton(
                onClick = { expanded = !expanded },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Selecciona el tamaño del perro: $tamanoPerro")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botón para calcular la edad
        Button(onClick = { calcularEdad() }) {
            Text("Calcular Edad")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Mostrar el resultado de la conversión
        Text("Edad en años perro: $resultado", style = MaterialTheme.typography.bodyLarge)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCalculadoraEdadScreen() {
    CalculadoraEdadScreen()
}
