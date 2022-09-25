package com.example.dapmotoristas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var edNome: EditText
    private lateinit var edEndereco: EditText
    private lateinit var btnAdd: Button
    private lateinit var btnView: Button
    private lateinit var btnUpdate: Button

    private lateinit var sqLiteHelper: SQLiteHelper
    private lateinit var recyclerView: RecyclerView
    private var adapter: MotoristaAdapter? = null
    private var mt:MotoristaModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        initRecyclerView()
        sqLiteHelper = SQLiteHelper(this)

        btnAdd.setOnClickListener { addMotorista() }
        btnView.setOnClickListener { getMotorista() }
        btnUpdate.setOnClickListener { updateMotorista() }


        adapter?.setOnClickItem {
            Toast.makeText(this,it.nome, Toast.LENGTH_SHORT).show()
            edNome.setText(it.nome)
            edEndereco.setText(it.endereco)
            mt = it
        }

        adapter?.setOnClickDeleteItem {
            deleteMotorista(it.id)
        }
    }

    private fun updateMotorista() {

        val nome = edNome.text.toString()
        val endereco = edEndereco.text.toString()

        if (nome == mt?.nome && endereco == mt?.endereco){
            Toast.makeText(this,"Registro não alterado...", Toast.LENGTH_SHORT).show()
            return
        }

        if (mt == null) return

        val mt = MotoristaModel(id = mt!!.id, nome = nome, endereco = endereco)
        val status = sqLiteHelper.updateMotorista(mt)
        if(status > -1) {
            clearEditText()
            getMotorista()
        } else {
            Toast.makeText(this, "Atualização falhou", Toast.LENGTH_SHORT).show()
        }

    }


    private fun getMotorista() {
        val mtList = sqLiteHelper.getAllMotoristas()
        Log.e("pppp", "${mtList.size}")

        adapter?.addItems(mtList)
    }

    private fun addMotorista() {
        val nome = edNome.text.toString()
        val endereco = edEndereco.text.toString()

        if (nome.isEmpty() || endereco.isEmpty()){
            Toast.makeText(this, "Por favor preencha os campos requiridos ", Toast.LENGTH_SHORT).show()
        } else {
            val mt = MotoristaModel(nome = nome, endereco = endereco)
            val status = sqLiteHelper.insertMotorista(mt)

            if (status > -1) {
                Toast.makeText(this,"Motorista adicionado...", Toast.LENGTH_SHORT).show()
                clearEditText()
                getMotorista()
            } else{
                Toast.makeText(this, "Cadastro não salvo.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun deleteMotorista(id:Int){

        val builder = AlertDialog.Builder(this)
        builder.setMessage("Tem certeza que deseja apagar?")
        builder.setCancelable(true)
        builder.setPositiveButton("Sim") { dialog, _ ->
            sqLiteHelper.deleteMotoristaById(id)
            getMotorista()
            dialog.dismiss()
        }
        builder.setNegativeButton("Não") { dialog, _ ->

            dialog.dismiss()
        }

        val alert = builder.create()
        alert.show()

    }




    private fun clearEditText() {
        edNome.setText("")
        edEndereco.setText("")
        edNome.requestFocus()
    }

    private fun initRecyclerView(){
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MotoristaAdapter()
        recyclerView.adapter = adapter

    }

    private fun initView() {
        edNome = findViewById(R.id.edNome)
        edEndereco = findViewById(R.id.edEndereco)
        btnAdd = findViewById(R.id.btnAdd)
        btnView = findViewById(R.id.btnVisu)
        btnUpdate = findViewById(R.id.btnAtualizar)
        recyclerView = findViewById(R.id.recyclerView)

    }


}