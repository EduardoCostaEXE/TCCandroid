package com.example.dapmotoristas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import com.example.dapmotoristas.databinding.ActivityTelaEditarBinding

class TelaEditar : AppCompatActivity() {
    private lateinit var binding: ActivityTelaEditarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaEditarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.btnSalvar.setOnClickListener {
            irParaTelaMenu()
        }
        binding.btnVoltar.setOnClickListener {

        }
    }
    private fun validacao() : Boolean {
        if(TextUtils.isEmpty(binding.editTextNomeUsuario.text)){
            binding.editTextNomeUsuario.setError("Nome é obrigatório")
            binding.editTextNomeUsuario.requestFocus()
            return false
        }
        if(TextUtils.isEmpty(binding.editTextLocalAbrangencia.text)){
            binding.editTextLocalAbrangencia.setError("Local é obrigatório")
            binding.editTextLocalAbrangencia.requestFocus()
            return false
        }
        if(TextUtils.isEmpty(binding.editTextNomeUniversidade.text)){
            binding.editTextNomeUniversidade.setError("Nome da Universidade é obrigatório")
            binding.editTextNomeUniversidade.requestFocus()
            return false
        }
        if(TextUtils.isEmpty(binding.editTextEndereco.text)){
            binding.editTextEndereco.setError("Endereço é obrigatório")
            binding.editTextEndereco.requestFocus()
            return false
        }
        if(TextUtils.isEmpty(binding.editTextMensalidade.text)){
            binding.editTextMensalidade.setError("Mensalidade é obrigatório")
            binding.editTextMensalidade.requestFocus()
            return false
        }
        if(TextUtils.isEmpty(binding.editTextHorarioSaida.text)){
            binding.editTextHorarioSaida.setError("Horário de saída é obrigatório")
            binding.editTextHorarioSaida.requestFocus()
            return false
        }
        if(TextUtils.isEmpty(binding.editHorarioRetorno.text)){
            binding.editHorarioRetorno.setError("Horário de retorno é obrigatório")
            binding.editHorarioRetorno.requestFocus()
            return false
        }
        if(TextUtils.isEmpty(binding.editTextPlacaVeiculo.text)){
            binding.editTextPlacaVeiculo.setError("Placa do veículo é obrigatório")
            binding.editTextPlacaVeiculo.requestFocus()
            return false
        }
        if(TextUtils.isEmpty(binding.editTextVagas.text)){
            binding.editTextVagas.setError("Número de vagas é obrigatório")
            binding.editTextVagas.requestFocus()
            return false
        }
        return true
    }
    private fun irParaTelaMenu(){
        if(validacao()) {
            val telaMenu = Intent(this, TelaInicialMoto::class.java)
            startActivity(telaMenu)
        }
    }
}