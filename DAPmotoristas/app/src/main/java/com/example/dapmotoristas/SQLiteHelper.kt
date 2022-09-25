package com.example.dapmotoristas

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.lang.Exception

class SQLiteHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object{
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "passageiro.db"
        private const val TBL_PASSAGEIROS = "tbl_passageiros"
        private const val ID = "id"
        private const val NOME = "nome"
        private const val ENDERECO = "endereco"
    }
    override fun onCreate(db: SQLiteDatabase?) {
        val createTblPassageiro = ("CREATE TABLE " + TBL_PASSAGEIROS + "(" + ID + " INTEGER PRIMARY KEY," + NOME + " TEXT," + ENDERECO + " TEXT" + ")")
        db?.execSQL(createTblPassageiro)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TBL_PASSAGEIROS")
        onCreate(db)
    }

    fun insertMotorista(mt: MotoristaModel): Long {
        val db = this.writableDatabase

        val contentValues = ContentValues()
        contentValues.put(ID, mt.id)
        contentValues.put(NOME, mt.nome)
        contentValues.put(ENDERECO, mt.endereco)

        val success = db.insert(TBL_PASSAGEIROS, null, contentValues)
        db.close()
        return success
    }

    @SuppressLint("Range")
    fun getAllMotoristas(): ArrayList<MotoristaModel> {
        val mtList: ArrayList<MotoristaModel> = ArrayList()
        val selectQuery = "SELECT * FROM $TBL_PASSAGEIROS"
        val db = this.readableDatabase

        val cursor: Cursor?

        try {
            cursor = db.rawQuery(selectQuery, null)
        } catch (e: Exception){
            e.printStackTrace()
            db.execSQL(selectQuery)
            return ArrayList()
        }

        var id: Int
        var nome: String
        var endereco: String

        if (cursor.moveToFirst()){
            do {
                id = cursor.getInt(cursor.getColumnIndex("id"))
                nome = cursor.getString(cursor.getColumnIndex("nome"))
                endereco = cursor.getString(cursor.getColumnIndex("endereco"))

                val mt = MotoristaModel(id = id, nome = nome, endereco = endereco)
                mtList.add(mt)
            } while(cursor.moveToNext())
        }

        return mtList
    }
    fun updateMotorista(mt: MotoristaModel): Int {
        val db = this.writableDatabase

        val contentValues = ContentValues()
        contentValues.put(ID, mt.id)
        contentValues.put(NOME, mt.nome)
        contentValues.put(ENDERECO, mt.endereco)

        val success = db.update(TBL_PASSAGEIROS, contentValues, "id=" + mt.id, null)
        db.close()
        return success
    }

    fun deleteMotoristaById(id:Int): Int{
        val db = this.writableDatabase

        val contentValues = ContentValues()
        contentValues.put(ID, id)

        val success = db.delete(TBL_PASSAGEIROS, "id=$id", null)
        db.close()
        return success
    }

}