package com.example.dapmotoristas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dapmotoristas.databinding.ActivityPerfilBinding

class Perfil : AppCompatActivity() {
    private lateinit var binding : ActivityPerfilBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityPerfilBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.btnVoltar.setOnClickListener {
            IrParaTelaMenu()
        }
        binding.btnEditar.setOnClickListener {
            IrParaTelaEditar()
        }
    }

    private fun IrParaTelaMenu() {
        val telaMenu = Intent(this, TelaInicialMoto::class.java)
        startActivity(telaMenu)
    }
    private fun IrParaTelaEditar() {
        val telaEditar = Intent(this, TelaEditar::class.java)
        startActivity(telaEditar)
    }
}