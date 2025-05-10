package esan.carrera.pc01.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp

@Composable
fun ConversorDivisasScreen() {
    var monto by remember { mutableStateOf("") }
    var tipoConversion by remember { mutableStateOf("USD a PEN") }
    var resultado by remember { mutableStateOf("") }

    // Función para manejar la conversión
    fun convertir() {
        val montoIngresado = monto.toDoubleOrNull()
        if (montoIngresado != null && montoIngresado > 0) {
            val tasa = 3.80
            resultado = if (tipoConversion == "USD a PEN") {
                "Resultado: ${(montoIngresado * tasa)} PEN"
            } else {
                "Resultado: ${(montoIngresado / tasa)} USD"
            }
        } else {
            resultado = "Por favor, ingresa un monto válido"
        }
    }

    // Layout de la pantalla
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Monto a convertir", style = MaterialTheme.typography.bodyLarge)

        Spacer(modifier = Modifier.height(8.dp))

        // OutlinedTextField para ingresar el monto
        OutlinedTextField(
            value = monto,
            onValueChange = { monto = it },
            label = { Text("Monto") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        // RadioButton para seleccionar la conversión
        Row {
            RadioButton(
                selected = tipoConversion == "USD a PEN",
                onClick = { tipoConversion = "USD a PEN" }
            )
            Text("USD a PEN", modifier = Modifier.padding(start = 8.dp))

            Spacer(modifier = Modifier.width(16.dp))

            RadioButton(
                selected = tipoConversion == "PEN a USD",
                onClick = { tipoConversion = "PEN a USD" }
            )
            Text("PEN a USD", modifier = Modifier.padding(start = 8.dp))
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botón para hacer la conversión
        Button(onClick = { convertir() }) {
            Text("Convertir")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Mostrar el resultado de la conversión
        Text(text = resultado)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewConversorDivisasScreen() {
    ConversorDivisasScreen()
}