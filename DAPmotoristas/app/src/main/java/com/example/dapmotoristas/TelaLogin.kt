package com.example.dapmotoristas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import com.example.dapmotoristas.databinding.ActivityTelaLoginBinding

class TelaLogin : AppCompatActivity() {
    private lateinit var binding : ActivityTelaLoginBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_DAPMotoristas)
        binding = ActivityTelaLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.textMensagemClick.setOnClickListener {
            IrParaTelaCadastro()
        }
        binding.button.setOnClickListener {
            IrParaTelaMenu()
        }
    }
    private fun validacao() : Boolean {
        if (TextUtils.isEmpty(binding.editTextEmail.text)){
            binding.editTextEmail.setError("Email é obrigatório")
            binding.editTextEmail.requestFocus()
            return false
        }
        if (TextUtils.isEmpty(binding.editTextSenha.text)){
            binding.editTextSenha.setError("Senha é obrigatório")
            binding.editTextSenha.requestFocus()
            return false
        }
        return true
    }
    private fun IrParaTelaCadastro(){
        val telaCadastro = Intent(this, TelaCadastro::class.java)
        startActivity(telaCadastro)
    }
    fun IrParaTelaMenu(){

        if (validacao()) {
            val telaMenu = Intent(this, TelaInicialMoto::class.java)
            startActivity(telaMenu)
        }
    }
}