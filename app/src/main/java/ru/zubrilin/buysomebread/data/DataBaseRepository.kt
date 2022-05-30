package ru.zubrilin.buysomebread.data

import kotlinx.coroutines.flow.Flow
import ru.zubrilin.buysomebread.data.entities.Task


interface DataBaseRepository {

    val allTasks:Flow<List<Task>>

    suspend fun insert(task: Task)

    suspend fun delete(task: Task)

    suspend fun update()

}