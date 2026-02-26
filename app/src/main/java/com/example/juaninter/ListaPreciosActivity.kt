package com.example.juaninter

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.PopupMenu
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

/**
 * Actividad que muestra una tabla editable de precios de autos.
 */
class ListaPreciosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Habilita el diseño edge-to-edge
        enableEdgeToEdge()
        
        // Establece el diseño XML
        setContentView(R.layout.activity_lista_precios)

        // Ajusta los márgenes para las barras del sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Configura el botón "Regresar" para volver a la pantalla principal
        findViewById<Button>(R.id.btnRegresar).setOnClickListener {
            finish()
        }

        // Configura el Toolbar para el menú desplegable
        val toolbar = findViewById<Toolbar>(R.id.toolbar_container)
        if (toolbar != null) {
            toolbar.setNavigationOnClickListener { view ->
                val popup = PopupMenu(this, view)
                // Carga el archivo de menú 'menu.xml'
                popup.menuInflater.inflate(R.menu.menu, popup.menu)
                
                // Define la navegación del menú
                popup.setOnMenuItemClickListener { item ->
                    when (item.itemId) {
                        R.id.opcion_datos -> {
                            // Aquí podrías añadir lógica para ir a Datos Personales si fuera necesario
                            true
                        }
                        R.id.opcion_precios -> true // Ya estamos en esta pantalla
                        else -> false
                    }
                }
                popup.show()
            }
        }
    }
}
