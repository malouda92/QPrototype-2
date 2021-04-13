package com.ramalomi.qprototype.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "reponse")
class Reponse(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "value_reponse") val valueReponse: String?,
    @ColumnInfo(name = "date_reponse") val dateReponse: String?,
    @ColumnInfo(name = "comment") val comment: String?
)