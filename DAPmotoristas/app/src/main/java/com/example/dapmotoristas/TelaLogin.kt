package com.example.dapmotoristas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aplicativos.TelaInicialMoto
import com.example.dapmotoristas.databinding.ActivityTelaLoginBinding

class TelaLogin : AppCompatActivity() {
    private lateinit var binding : ActivityTelaLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.textMensagemClick1.setOnClickListener {
            IrParaTelaCadastro()
        }
        binding.button.setOnClickListener {
            IrParaTelaMenu()
        }
    }

    private fun IrParaTelaCadastro(){
        val telaCadastro = Intent(this, TelaCadastro::class.java)
        startActivity(telaCadastro)
    }
    private fun IrParaTelaMenu(){
        val telaMenu = Intent(this, TelaInicialMoto::class.java)
        startActivity(telaMenu)
    }
}