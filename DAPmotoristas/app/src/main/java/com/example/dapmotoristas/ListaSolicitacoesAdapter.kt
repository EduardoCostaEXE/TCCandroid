package com.example.dapmotoristas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListaSolicitacoesAdapter(var passageiros : MutableList<AlunoModel> = ArrayList())
    : RecyclerView.Adapter<ListaSolicitacoesAdapter.PassageiroViewHolder>(){

    class PassageiroViewHolder (view : View) : RecyclerView.ViewHolder(view) {
        val nome : TextView = itemView.findViewById(R.id.nome_card)
        val endereco : TextView = itemView.findViewById(R.id.endereco_card)
        val instituicao : TextView = itemView.findViewById(R.id.instituicao_card)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PassageiroViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_card_lista,parent,false)
        return PassageiroViewHolder(view)
    }

    override fun onBindViewHolder(holder: PassageiroViewHolder, position: Int) {
        val passageiro = passageiros[position]
        holder.nome.text = passageiro.nome
        holder.endereco.text = passageiro.endereco
        holder.instituicao.text = passageiro.instituicao
    }

    override fun getItemCount() = passageiros.size
}