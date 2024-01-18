package com.example.examenandroid.VM

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.examenandroid.model.Alumne
import com.example.examenandroid.repositori.Repositori

class VMGrup:ViewModel() {
    lateinit var alumne : LiveData<List<Alumne>>

    fun obtenirAlumnes(context: Context){
        alumne = Repositori.getAllAlumnes(context)
    }

    fun obterirUnAlumne(context: Context, id: Int){
        alumne = Repositori.getOneAlumne(context, id)
    }

    fun obtenirAprovats(context: Context){
        alumne = Repositori.getAprovats(context)
    }

    fun obtenirSuspesos(context: Context){
        alumne = Repositori.getSuspes(context)
    }
}