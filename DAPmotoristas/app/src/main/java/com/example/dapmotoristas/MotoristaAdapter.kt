package com.example.dapmotoristas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MotoristaAdapter : RecyclerView.Adapter<MotoristaAdapter.MotoristaViewHolder>() {

    private var mtList: ArrayList<MotoristaModel> = ArrayList()
    private var onClickItem: ((MotoristaModel) -> Unit)? =null
    private var onClickDeleteItem: ((MotoristaModel) -> Unit)? =null

    fun addItems(items: ArrayList<MotoristaModel>) {
        this.mtList = items
        notifyDataSetChanged()
    }

    fun setOnClickItem(callback: (MotoristaModel) -> Unit) {
        this.onClickItem = callback
    }

    fun setOnClickDeleteItem(callback: (MotoristaModel) -> Unit) {
        this.onClickDeleteItem = callback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MotoristaViewHolder (
        LayoutInflater.from(parent.context).inflate(R.layout.card_mt, parent, false)
    )


    override fun onBindViewHolder(holder: MotoristaViewHolder, position: Int) {
        val mt = mtList[position]
        holder.bindView(mt)
        holder.itemView.setOnClickListener { onClickItem?.invoke(mt)}
        holder.btnDelete.setOnClickListener { onClickDeleteItem?.invoke(mt) }
    }


    override fun getItemCount(): Int {
        return mtList.size
    }

    class MotoristaViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        private var id = view.findViewById<TextView>(R.id.tvId)
        private var nome = view.findViewById<TextView>(R.id.tvNome)
        private var endereco = view.findViewById<TextView>(R.id.tvEndereco)
        var btnDelete = view.findViewById<Button>(R.id.btnDelete)

        fun bindView(mt: MotoristaModel){
            id.text = mt.id.toString()
            nome.text = mt.nome
            endereco.text = mt.endereco
        }

    }


}