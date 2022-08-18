package com.example.dapmotoristas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import com.example.dapmotoristas.databinding.ActivityTelaCadastroBinding

class TelaCadastro : AppCompatActivity() {
    private lateinit var binding : ActivityTelaCadastroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.textMensagemClick.setOnClickListener {
            IrParaTelaLogin()
        }
        binding.button.setOnClickListener {
            IrParaTelaPerfilCadastro()
        }
    }
    private fun validacao() : Boolean {
        if (TextUtils.isEmpty(binding.editNome.text)){
            binding.editNome.setError("Nome é obrigatório")
            binding.editNome.requestFocus()
            return false
        }
        if (TextUtils.isEmpty(binding.editEmail.text)){
            binding.editEmail.setError("Email é obrigatório")
            binding.editEmail.requestFocus()
            return false
        }
        if (TextUtils.isEmpty(binding.editSenha.text)){
            binding.editSenha.setError("Senha é obrigatório")
            binding.editSenha.requestFocus()
            return false
        }
        return true
    }
    private fun IrParaTelaLogin(){
        val telaLogin = Intent(this, TelaLogin::class.java)
        startActivity(telaLogin)
    }

    private fun IrParaTelaPerfilCadastro(){
        if (validacao()) {
            val telaPerfilCadastro = Intent(this, TelaEditar::class.java)
            startActivity(telaPerfilCadastro)
        }
    }
}