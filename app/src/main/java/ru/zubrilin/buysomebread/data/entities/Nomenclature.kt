package ru.zubrilin.buysomebread.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "nomenclatures_table",
    foreignKeys = arrayOf(
        ForeignKey(entity = Category::class
            , parentColumns = arrayOf("id")
            , childColumns = arrayOf("category_id")
            , onDelete = ForeignKey.SET_NULL)
    ))
data class Nomenclature(
    @PrimaryKey(autoGenerate = true) val id:Int,
    @ColumnInfo val name:String,
    @ColumnInfo val category_id: Int
)
