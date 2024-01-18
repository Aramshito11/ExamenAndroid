package com.example.examenandroid.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.examenandroid.model.Alumne

@Database(
    entities = [Alumne::class],
    version = 1,
    exportSchema = false
)
abstract class AlumnesDatabase : RoomDatabase() {
    abstract fun daoAlumnes(): DAOAlumnes

    companion object{
        @Volatile
        private var INSTANCE: AlumnesDatabase?=null

        fun getDatabase(context: Context): AlumnesDatabase {
            if (INSTANCE == null){
                synchronized(this){
                    INSTANCE = buildDatabase(context)
                }
            }
            return INSTANCE!!
        }

        private fun buildDatabase(context: Context): AlumnesDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                AlumnesDatabase::class.java,
                "alumne_database"
            ).build()
        }
    }
}