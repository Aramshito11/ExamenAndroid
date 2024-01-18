package com.example.examenandroid.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.examenandroid.model.Alumne

@Dao
interface DAOAlumnes {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun addAlumne(alumne: Alumne)

    @Query("SELECT * FROM Alumns WHERE id = :identificador ORDER BY id DESC")
    fun getOneAlumne(identificador:Int): LiveData<List<Alumne>>

    @Query("SELECT * FROM Alumns ORDER BY id DESC")
    fun getAllAlumnes(): LiveData<List<Alumne>>

    @Query("SELECT * FROM Alumns WHERE Note >= 5 ORDER BY id DESC")
    fun getAprovats(): LiveData<List<Alumne>>

    @Query("SELECT * FROM Alumns WHERE Note < 5 ORDER BY id DESC")
    fun getSuspes(): LiveData<List<Alumne>>
}