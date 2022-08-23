package com.example.dappassageiros

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar
import com.example.dappassageiros.databinding.ActivityTelaPassageiroFinalBinding

class TelaPassageiroFinal : AppCompatActivity() {
    private lateinit var binding : ActivityTelaPassageiroFinalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaPassageiroFinalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.btnVoltar.setOnClickListener {
            finish()
        }
        binding.btnEditar.setOnClickListener {
            irParaTelaEditar()
        }
    }
    private fun irParaTelaEditar(){
        val telaEditar = Intent(this, TelaPassageiro::class.java)
        startActivity(telaEditar)
    }
}