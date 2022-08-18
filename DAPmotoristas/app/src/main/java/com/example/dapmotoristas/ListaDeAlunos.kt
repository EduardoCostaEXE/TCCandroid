package com.example.dapmotoristas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dapmotoristas.databinding.ActivityListaDeAlunosBinding

class ListaDeAlunos : AppCompatActivity() {
    private lateinit var binding : ActivityListaDeAlunosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaDeAlunosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.button.setOnClickListener {
            IrParaTelaMenu()
        }
    }

    private fun IrParaTelaMenu(){
        val telaMenu = Intent(this, TelaInicialMoto::class.java)
        startActivity(telaMenu)
    }
}