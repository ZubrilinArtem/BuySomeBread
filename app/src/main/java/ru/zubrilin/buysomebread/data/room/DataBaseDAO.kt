package ru.zubrilin.buysomebread.data.room

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import ru.zubrilin.buysomebread.data.entities.Task

@Dao
interface DataBaseDAO {

    @Query("SELECT * FROM task_table")
    fun getAllTask(): Flow<List<Task>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(task: Task)

    @Delete
    suspend fun delete(task: Task)

}