package com.example.dappassageiros

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dappassageiros.databinding.ActivityTelaCadastroBinding

class TelaCadastro : AppCompatActivity() {
    private lateinit var binding: ActivityTelaCadastroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.button.setOnClickListener {
            irParatelaEditar()
        }
        binding.textMensagemClick1.setOnClickListener {
            irParaTelaLogin()
        }
    }
    private fun irParaTelaLogin(){
        val telaLogin = Intent(this, TelaLogin::class.java)
        startActivity(telaLogin)
    }
    private fun irParatelaEditar(){
        val telaEditar = Intent(this, TelaPassageiro::class.java)
        startActivity(telaEditar)
    }
}