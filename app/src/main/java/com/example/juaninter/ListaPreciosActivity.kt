package com.example.juaninter

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.PopupMenu
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ListaPreciosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lista_precios)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Configurar botón Regresar
        findViewById<Button>(R.id.btnRegresar).setOnClickListener {
            finish()
        }

        // Configurar Toolbar y Menú
        val toolbar = findViewById<Toolbar>(R.id.toolbar_container)
        if (toolbar != null) {
            toolbar.setNavigationOnClickListener { view ->
                val popup = PopupMenu(this, view)
                popup.menuInflater.inflate(R.menu.menu, popup.menu)
                popup.setOnMenuItemClickListener { item ->
                    when (item.itemId) {
                        R.id.opcion_datos -> {
                            // Aquí podrías ir a Datos Personales si quisieras
                            true
                        }
                        R.id.opcion_precios -> true // Ya estamos aquí
                        else -> false
                    }
                }
                popup.show()
            }
        }
    }
}
