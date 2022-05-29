package ru.zubrilin.buysomebread.data

import androidx.lifecycle.LiveData
import ru.zubrilin.buysomebread.model.Task

interface DataBaseRepository {

    val allTasks:LiveData<List<Task>>

    suspend fun insert(task: Task)

    suspend fun delete(task: Task)

    suspend fun update()

}