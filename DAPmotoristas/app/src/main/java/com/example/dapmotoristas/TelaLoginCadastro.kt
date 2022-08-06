package com.example.dapmotoristas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dapmotoristas.databinding.ActivityTelaCadastroBinding

class TelaLoginCadastro : AppCompatActivity() {
    private lateinit var binding : ActivityTelaCadastroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.textMensagemClick1.setOnClickListener {
            IrParaTelaLogin()
        }
    }
    private fun IrParaTelaLogin(){
        val telaLogin = Intent(this, TelaLogin::class.java)
        startActivity(telaLogin)
    }
}