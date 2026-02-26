package com.example.juaninter

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.PopupMenu
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

/**
 * Actividad que muestra la información personal del usuario.
 * Incluye una foto circular y datos fijos.
 */
class DatosPersonalesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Habilita el diseño de borde a borde para aprovechar toda la pantalla
        enableEdgeToEdge()
        
        // Carga el diseño XML de la pantalla de datos personales
        setContentView(R.layout.activity_datos_personales)

        // Ajusta los márgenes para evitar que el contenido quede bajo las barras del sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Configura el botón "Regresar" para cerrar la pantalla actual
        val btnRegresar = findViewById<Button>(R.id.btnRegresar)
        btnRegresar.setOnClickListener {
            // Finaliza esta actividad y regresa a la anterior (MainActivity)
            finish()
        }

        // Configura el Toolbar para permitir la navegación mediante el menú
        val toolbar = findViewById<Toolbar>(R.id.toolbar_container)
        if (toolbar != null) {
            toolbar.setNavigationOnClickListener { view ->
                val popup = PopupMenu(this, view)
                popup.menuInflater.inflate(R.menu.menu, popup.menu)
                popup.setOnMenuItemClickListener { item ->
                    when (item.itemId) {
                        R.id.opcion_datos -> true // Ya estamos en esta pantalla, no hacemos nada
                        R.id.opcion_precios -> {
                            // Acción para navegar a la lista de precios (podrías usar un Intent aquí)
                            Toast.makeText(this, "Abriendo Lista de Precios", Toast.LENGTH_SHORT).show()
                            true
                        }
                        else -> false
                    }
                }
                popup.show()
            }
        }
    }
}
