package ru.zubrilin.buysomebread.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "items_table", foreignKeys = (arrayOf(
        ForeignKey(
            entity = Nomenclature::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("nomenclature_id"),
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Task::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("task_id"),
            onDelete = ForeignKey.CASCADE
        )
    )
            )
)
data class Item(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo val nomenclature_id: Int,
    @ColumnInfo val task_id: Int
)
