package com.example.dapmotoristas

import java.util.*

data class MotoristaModel(
    var id: Int = getAutoId(),
    var nome: String = "",
    var endereco: String = ""
) {
    companion object{
        fun getAutoId(): Int {
            val random = Random()
            return random.nextInt(100)
        }
    }
}