package esan.carrera.pc01.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import coil.compose.rememberImagePainter

@Composable
fun CatalogoProductosScreen() {
    // Productos de ejemplo
    val productos = listOf(
        Producto("Laptop", 1000.0, "Laptop", "https://www.pcfactory.com.pe/public/foto/3048/1_1000.jpg?t=1744744734871"),
        Producto("Smartphone", 500.0, "Smartphone", "https://m.media-amazon.com/images/I/41JqIcVU2cL._AC_.jpg")
    )

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        productos.forEach { producto ->
            Card(modifier = Modifier.padding(8.dp)) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = producto.nombre, style = MaterialTheme.typography.headlineSmall)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "$${producto.precio}", style = MaterialTheme.typography.bodyLarge)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = producto.categoria, style = MaterialTheme.typography.bodyMedium)
                    Spacer(modifier = Modifier.height(8.dp))
                    // Cargar la imagen usando Coil
                    Image(
                        painter = rememberImagePainter(producto.imagen),
                        contentDescription = producto.nombre,
                        modifier = Modifier.fillMaxWidth().height(200.dp),
                        contentScale = ContentScale.Crop
                    )
                }
            }
        }
    }
}

data class Producto(val nombre: String, val precio: Double, val categoria: String, val imagen: String)

@Preview(showBackground = true)
@Composable
fun PreviewCatalogoProductosScreen() {
    CatalogoProductosScreen()
}
