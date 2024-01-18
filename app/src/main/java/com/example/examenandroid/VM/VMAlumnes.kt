package com.example.examenandroid.VM

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.examenandroid.model.Alumne
import com.example.examenandroid.repositori.Repositori

class VMAlumnes : ViewModel(){

    fun afegirMoble(context: Context, nom: String, grup: String, nota: Int){
        var alumneVM=Alumne(nom, grup, nota)

        Repositori.insertAlumne(context, alumneVM)
    }
}