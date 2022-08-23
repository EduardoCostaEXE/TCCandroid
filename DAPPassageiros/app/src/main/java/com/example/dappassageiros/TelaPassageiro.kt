package com.example.dappassageiros

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dappassageiros.databinding.ActivityTelaPassageiroBinding

class TelaPassageiro : AppCompatActivity() {
    private lateinit var binding : ActivityTelaPassageiroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaPassageiroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.btnVoltar.setOnClickListener {
            finish()
        }
        binding.btnSalvar.setOnClickListener {
            irParaTelaMenu()
        }
    }
    private fun irParaTelaMenu(){
        val telaMenu = Intent(this, TelaInicialAluno::class.java)
        startActivity(telaMenu)
    }
}