package com.example.dapmotoristas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dapmotoristas.databinding.ActivityListagemAlunosBinding

class ListagemAlunos : AppCompatActivity() {
    private lateinit var binding : ActivityListagemAlunosBinding
    private lateinit var recyclerView : RecyclerView
    private lateinit var listaAlunosAdapter : ListaAlunosAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListagemAlunosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        binding.btnVoltar.setOnClickListener {
            finish()
        }

        recyclerView = findViewById(R.id.recyclerview_lista_alunos)
        recyclerView.hasFixedSize()
        recyclerView.layoutManager = LinearLayoutManager(this)

        var listaAlunos = listaAlunos()

        listaAlunosAdapter = ListaAlunosAdapter(listaAlunos)

        val adapter : ListaAlunosAdapter = ListaAlunosAdapter()
        recyclerView.adapter = listaAlunosAdapter

        /*  val passageiros = passageiros()

        passageiroAdapter = PassageiroAdapter(passageiros)

        val adapter : PassageiroAdapter = PassageiroAdapter()
        recyclerView.adapter = passageiroAdapter
    }*/
    }

    private fun listaAlunos(): MutableList<AlunoModel> {
        var passageirosModel : MutableList<AlunoModel> = ArrayList()

        passageirosModel.add(AlunoModel("Ana","rua 1", "Unip", true, true, true, true,true))
        passageirosModel.add(AlunoModel("José","rua 2", "Unip",true, true, true, true,true))
        passageirosModel.add(AlunoModel("João","rua 3", "Unip",true, true, true, true,true))
        passageirosModel.add(AlunoModel("Maria","rua 4", "Unip",true, true, true, true,true))
        passageirosModel.add(AlunoModel("Pedro","rua 5", "Unip",true, true, true, true,true))
        passageirosModel.add(AlunoModel("Felipe","rua 6", "Unip",true, true, true, true,true))
        passageirosModel.add(AlunoModel("Carol","rua 7", "Unip",true, true, true, true,true))
        passageirosModel.add(AlunoModel("Rafael","rua 8", "Unip",true, true, true, true,true))
        passageirosModel.add(AlunoModel("Marcia","rua 9", "Unip",true, true, true, true,true))



        return  passageirosModel
    }
}