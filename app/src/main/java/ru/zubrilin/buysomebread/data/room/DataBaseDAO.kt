package ru.zubrilin.buysomebread.data.room

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import ru.zubrilin.buysomebread.data.entities.Task

@Dao
interface DataBaseDAO {

    @Query("SELECT task_table.id, task_table.name, COUNT(items_table.id) as 'count' FROM task_table LEFT JOIN items_table ON task_table.id = items_table.task_id")
    fun getAllTask(): Flow<List<Task>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(task: Task)

    @Delete
    suspend fun delete(task: Task)

    @Update
    suspend fun update(task: Task)

}