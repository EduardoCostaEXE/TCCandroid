package com.example.dappassageiros

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dappassageiros.databinding.ActivityAcompanharTrajetoBinding

class AcompanharTrajeto : AppCompatActivity() {
    private lateinit var binding : ActivityAcompanharTrajetoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAcompanharTrajetoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.btnVoltar.setOnClickListener {
            finish()
        }
    }
}