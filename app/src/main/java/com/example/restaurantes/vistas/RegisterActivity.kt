package com.example.restaurantes.vistas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.restaurantes.R
import com.example.restaurantes.databinding.ActivityMainBinding
import com.example.restaurantes.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnCancelarRegister.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        binding.btnAceptarRegister.setOnClickListener {
            Toast.makeText(this,"Aun no implementado",Toast.LENGTH_LONG).show()
        }
    }
}