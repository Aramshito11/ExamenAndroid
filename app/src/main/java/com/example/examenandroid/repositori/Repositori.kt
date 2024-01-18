package com.example.examenandroid.repositori

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.examenandroid.database.AlumnesDatabase
import com.example.examenandroid.model.Alumne
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Repositori {

    companion object{
        var alumneDatabase: AlumnesDatabase? = null

        var alumne: LiveData<List<Alumne>>? = null

        fun  initializeDB(context: Context): AlumnesDatabase {
            return AlumnesDatabase.getDatabase(context)
        }

        fun insertAlumne(context: Context, alumne: Alumne) {
            alumneDatabase = initializeDB(context)

            CoroutineScope(Dispatchers.IO).launch {
                alumneDatabase!!.daoAlumnes().addAlumne(alumne)
            }
        }


        fun getOneAlumne(context: Context, alumne: Int): LiveData<List<Alumne>> {

            alumneDatabase = initializeDB(context)

            return alumneDatabase!!.daoAlumnes().getOneAlumne(alumne)
        }

        fun getAllAlumnes(context: Context): LiveData<List<Alumne>> {

            alumneDatabase = initializeDB(context)

            return alumneDatabase!!.daoAlumnes().getAllAlumnes()
        }

        fun getAprovats(context: Context): LiveData<List<Alumne>> {

            alumneDatabase = initializeDB(context)

            return alumneDatabase!!.daoAlumnes().getAprovats()
        }

        fun getSuspes(context: Context): LiveData<List<Alumne>> {

            alumneDatabase = initializeDB(context)

            return alumneDatabase!!.daoAlumnes().getSuspes()
        }
    }
}