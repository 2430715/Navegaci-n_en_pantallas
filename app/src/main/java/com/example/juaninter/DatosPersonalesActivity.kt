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

class DatosPersonalesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_datos_personales)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Configurar botón Regresar
        val btnRegresar = findViewById<Button>(R.id.btnRegresar)
        btnRegresar.setOnClickListener {
            finish() // Cierra esta actividad y vuelve a la anterior
        }

        val toolbar = findViewById<Toolbar>(R.id.toolbar_container)
        if (toolbar != null) {
            toolbar.setNavigationOnClickListener { view ->
                val popup = PopupMenu(this, view)
                popup.menuInflater.inflate(R.menu.menu, popup.menu)
                popup.setOnMenuItemClickListener { item ->
                    when (item.itemId) {
                        R.id.opcion_datos -> true
                        R.id.opcion_precios -> {
                            Toast.makeText(this, "Abriendo Lista de Precios", Toast.LENGTH_SHORT).show()
                            true
                        }
                        else -> false
                    }
                }
                popup.show()
            }//Siguente panatalla lista de preciods, editable
        }
    }
}
