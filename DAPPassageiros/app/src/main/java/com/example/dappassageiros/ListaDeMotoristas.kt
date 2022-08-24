package com.example.dappassageiros

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dappassageiros.databinding.ActivityListaDeMotoristasBinding

class ListaDeMotoristas : AppCompatActivity() {
    private lateinit var binding : ActivityListaDeMotoristasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaDeMotoristasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.btnVoltar.setOnClickListener {
            finish()
        }
    }
}