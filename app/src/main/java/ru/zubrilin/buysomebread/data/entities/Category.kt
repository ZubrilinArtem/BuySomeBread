package ru.zubrilin.buysomebread.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "categories_table")
data class Category(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo val name: String,
    @ColumnInfo val color: Int,
)
