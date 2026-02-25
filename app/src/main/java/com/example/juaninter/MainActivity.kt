package com.example.juaninter

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.PopupMenu
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

/**
 * Actividad Principal de la aplicación.
 * Muestra una imagen de un coche y un menú de navegación en el Toolbar.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Habilita el diseño de borde a borde (edge-to-edge)
        enableEdgeToEdge()
        
        // Establece el diseño XML para esta actividad
        setContentView(R.layout.activity_main)

        // Configura el padding de la vista principal para que no se solape con las barras del sistema (estado y navegación)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Busca el Toolbar en el diseño mediante su ID
        val toolbar = findViewById<Toolbar>(R.id.toolbar_container)

        // Verifica si el toolbar existe para evitar errores
        if (toolbar != null) {
            // Configura la acción al pulsar el icono de navegación (hamburguesa)
            toolbar.setNavigationOnClickListener { view ->
                // Crea un menú desplegable (PopupMenu) vinculado a la vista pulsada
                val popup = PopupMenu(this, view)
                // Infla el recurso de menú (menu.xml) dentro del PopupMenu
                popup.menuInflater.inflate(R.menu.menu, popup.menu)

                // Define qué sucede al pulsar cada opción del menú
                popup.setOnMenuItemClickListener { item ->
                    when (item.itemId) {
                        R.id.opcion_datos -> {
                            // Inicia la actividad de Datos Personales
                            val intent = Intent(this, DatosPersonalesActivity::class.java)
                            startActivity(intent)
                            true
                        }
                        R.id.opcion_precios -> {
                            // Inicia la actividad de Lista de Precios
                            val intent = Intent(this, ListaPreciosActivity::class.java)
                            startActivity(intent)
                            true
                        }
                        else -> false
                    }
                }
                // Muestra el menú en pantalla
                popup.show()
            }
        }
    }
}
