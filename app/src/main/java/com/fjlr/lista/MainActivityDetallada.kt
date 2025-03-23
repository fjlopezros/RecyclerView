package com.fjlr.lista

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.fjlr.lista.modelo.PersonasRepository
import com.squareup.picasso.Picasso

class MainActivityDetallada : AppCompatActivity() {

    //Declaramos variables tardias
    lateinit var dni: TextView
    lateinit var nombre: TextView
    lateinit var apellidos: TextView
    lateinit var foto: ImageView
    lateinit var volver: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_detallada)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainDetallada)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Encontramos por id
        volver = findViewById(R.id.idVolverDetallada)
        dni = findViewById<TextView>(R.id.idDniDetallada)
        nombre = findViewById<TextView>(R.id.idNombreDetallada)
        apellidos = findViewById<TextView>(R.id.idApellidosDetallada)
        foto = findViewById<ImageView>(R.id.idProductoDetallada)


        //asignamos el dni
        dni.text = intent.getStringExtra("DNI")

        val p = PersonasRepository.getPersonaByDni(dni.text.toString())
        if (p != null) {
            nombre.text = p.nombre
            apellidos.text = p.apellidos
            Picasso.get().load(p.foto).into(foto)
        }

        //boton para volver
        volver.setOnClickListener {
            finish()
        }
    }
}