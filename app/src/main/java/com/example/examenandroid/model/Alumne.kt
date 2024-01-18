package com.example.examenandroid.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Alumns")
data class Alumne(
    @ColumnInfo(name = "Name")
    var name: String,
    @ColumnInfo(name = "Group")
    var group: String,
    @ColumnInfo(name = "Note")
    var note: Int
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}