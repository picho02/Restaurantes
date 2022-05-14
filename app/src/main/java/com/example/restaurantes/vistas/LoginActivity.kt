package com.example.restaurantes.vistas

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.restaurantes.clases.Usuario
import com.example.restaurantes.clases.UsuarioResponse
import com.example.restaurantes.databinding.ActivityLoginBinding
import com.example.restaurantes.interfaces.APIService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val usuarios = mutableListOf<Usuario>()
    private var usuarioIngresado = ""
    private var pswIngresado = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        search()


    }

    override fun onStart() {
        super.onStart()
        binding.btnRegistrar.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
        binding.btnLogin.setOnClickListener {
            usuarioIngresado = binding.etUser.text.toString()
            pswIngresado = binding.etPwd.text.toString()
            valorar()

        }
    }


    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl("https://demo1416549.mockable.io/")
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    fun search() {

        CoroutineScope(Dispatchers.IO).launch {
            val call: Response<UsuarioResponse> =
                getRetrofit().create(APIService::class.java).getUsuarios("usuarios2")
            val usuario: UsuarioResponse? = call.body()
            val tmpUsuario: List<Usuario> = usuario?.usuarios ?: emptyList()
            runOnUiThread { //Para corre en el hiloprincipal
                if (call.isSuccessful) {

                    if (usuarios != null) {
                        usuarios.clear()
                        usuarios.addAll(tmpUsuario)
                    }

                } else {
                    //Error, Manejo del error
                    showError()
                }


            }
        }
    }

    private fun showError() {
        Toast.makeText(this, "error", Toast.LENGTH_LONG).show()
    }
    fun valorar(){
        if (usuarioIngresado == "" || pswIngresado == ""){
            Toast.makeText(this,"ingrese todos los datos",Toast.LENGTH_LONG).show()
        }else{
            var i = 0
            while (i < usuarios.size){
                if (usuarioIngresado == usuarios[i].nombre){
                    if (pswIngresado == usuarios[i].contrasenia){
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        return
                    }
                }
                i++
            }
            Toast.makeText(this,"Usuario o contraseña incorrecto",Toast.LENGTH_LONG).show()
        }
    }
}