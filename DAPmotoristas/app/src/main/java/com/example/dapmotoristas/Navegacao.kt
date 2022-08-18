package com.example.dapmotoristas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dapmotoristas.databinding.ActivityNavegacaoBinding

class Navegacao : AppCompatActivity() {
    private lateinit var binding: ActivityNavegacaoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNavegacaoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.btnVoltar.setOnClickListener {
            irParaTelaMenu()
        }
    }
    private fun irParaTelaMenu(){
        val telaCadastro = Intent(this, TelaInicialMoto::class.java)
        startActivity(telaCadastro)
    }
}