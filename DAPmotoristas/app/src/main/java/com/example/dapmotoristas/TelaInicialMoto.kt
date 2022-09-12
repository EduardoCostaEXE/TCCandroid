package com.example.dapmotoristas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dapmotoristas.databinding.ActivityTelaInicialMotoBinding


class TelaInicialMoto : AppCompatActivity() {
    private lateinit var binding : ActivityTelaInicialMotoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaInicialMotoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.btnNavegacao.setOnClickListener {
            IrParaNavegacao()
        }
        binding.btnListaAlunos.setOnClickListener {
            IrParaListaAlunos()
        }
        binding.btnSolicitacoes.setOnClickListener {
            IrParaSolicitacoes()
        }
        binding.btnPerfil.setOnClickListener {
            IrParaTelaPerfil()
        }
        binding.btnSair.setOnClickListener {
            irParaTelaLogin()
        }
    }
    private fun irParaTelaLogin(){
        val telaLogin = Intent(this, TelaLogin::class.java)
        startActivity(telaLogin)
    }
    private fun IrParaNavegacao(){
        val telaNavegacao = Intent(this, Navegacao::class.java)
        startActivity(telaNavegacao)
    }
    private fun IrParaListaAlunos(){
        val telaListaAlunos = Intent(this, ListagemAlunos::class.java)
        startActivity(telaListaAlunos)
    }
    private fun IrParaSolicitacoes(){
        val telaSolicitacoes = Intent(this, ListaSolicitacoes::class.java)
        startActivity(telaSolicitacoes)
    }
    private fun IrParaTelaPerfil(){
        val telaPerfil = Intent(this, Perfil::class.java)
        startActivity(telaPerfil)
    }
}