package com.example.aplicativos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dapmotoristas.databinding.LayoutTelainicialmotoBinding

class TelaInicialMoto : AppCompatActivity() {
    private lateinit var binding : LayoutTelainicialmotoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LayoutTelainicialmotoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btNavegacaomoto.setOnClickListener {
            IrParaNavegacao()
        }
        binding.btListamoto.setOnClickListener {
            IrParaListaAlunos()
        }
        binding.btPerfilmoto.setOnClickListener {
            IrParaTelaPerfil()
        }
    }
    private fun IrParaNavegacao(){
        val telaNavegacao = Intent(this, Navegacao::class.java)
        startActivity(telaNavegacao)
    }
    private fun IrParaListaAlunos(){
        val telaListaAlunos = Intent(this, Navegacao::class.java)
        startActivity(telaListaAlunos)
    }
    private fun IrParaTelaPerfil(){
        val telaPerfil = Intent(this, Navegacao::class.java)
        startActivity(telaPerfil)
    }
}