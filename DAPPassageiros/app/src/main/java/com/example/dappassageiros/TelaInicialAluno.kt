package com.example.dappassageiros

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dappassageiros.databinding.ActivityTelaInicialAlunoBinding

class TelaInicialAluno : AppCompatActivity() {
    private lateinit var binding : ActivityTelaInicialAlunoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaInicialAlunoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.btnSair.setOnClickListener {
            finish()
        }
        binding.btnNavegacao.setOnClickListener {
            irParaTelaNavegacao()
        }
        binding.btnPerfil.setOnClickListener {
            irParaTelaPerfil()
        }
        binding.btnListaMotoristas.setOnClickListener {
            irParaTelaMotoristas()
        }
    }
    private fun irParaTelaNavegacao(){
        val telaNavegacao = Intent(this, AcompanharTrajeto::class.java)
        startActivity(telaNavegacao)
    }
    private fun irParaTelaPerfil(){
        val telaPerfil = Intent(this, TelaPassageiroFinal::class.java)
        startActivity(telaPerfil)
    }
    private fun irParaTelaMotoristas(){
        val telaMotoristas = Intent(this, ListaDeMotoristas::class.java)
        startActivity(telaMotoristas)
    }
}