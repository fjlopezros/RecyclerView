package com.fjlr.lista

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.fjlr.lista.adapter.PersonaAdapter
import com.fjlr.lista.databinding.ActivityMainBinding
import com.fjlr.lista.modelo.Persona
import com.fjlr.lista.modelo.PersonasRepository

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.listaPersonas.layoutManager = LinearLayoutManager(this)
        binding.listaPersonas.adapter = PersonaAdapter(PersonasRepository.listaPeronas) { persona ->
            onClickListener(persona)
        }

    }

    fun onClickListener(persona: Persona) {
        val intent = Intent(this, MainActivityDetallada::class.java)

        intent.putExtra("DNI", persona.dni)

        startActivity(intent)

        Toast.makeText(
            this,
            "Has pulsado en ${persona.nombre}",
            Toast.LENGTH_SHORT
        ).show()
    }
}