package com.example.dapmotoristas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListaAlunosAdapter (var listaAlunos : MutableList<AlunoModel> = ArrayList())
    : RecyclerView.Adapter<ListaAlunosAdapter.ListaAlunosViewHolder>(){

    class ListaAlunosViewHolder (view : View) : RecyclerView.ViewHolder(view){
        val nome: TextView = itemView.findViewById(R.id.nome_lista_card)
        val endereco: TextView = itemView.findViewById(R.id.endereco_lista_card)
        val instituicao: TextView = itemView.findViewById(R.id.instituicao_lista_card)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaAlunosViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_card_aluno,parent,false)
        return ListaAlunosViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListaAlunosViewHolder, position: Int) {
        val aluno = listaAlunos[position]
        holder.nome.text = aluno.nome
        holder.endereco.text = aluno.endereco
        holder.instituicao.text = aluno.instituicao
    }

    override fun getItemCount() = listaAlunos.size

}