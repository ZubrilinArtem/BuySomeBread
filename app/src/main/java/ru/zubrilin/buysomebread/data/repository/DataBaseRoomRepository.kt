package ru.zubrilin.buysomebread.data.repository

import kotlinx.coroutines.flow.Flow
import ru.zubrilin.buysomebread.data.DataBaseRepository
import ru.zubrilin.buysomebread.data.entities.Task
import ru.zubrilin.buysomebread.data.room.DataBaseDAO

class DataBaseRoomRepository(private val dataBaseDAO: DataBaseDAO): DataBaseRepository {

    override val allTasks: Flow<List<Task>>
        get() = dataBaseDAO.getAllTask()

    override suspend fun insert(task: Task) {
        dataBaseDAO.insert(task)
    }

    override suspend fun delete(task: Task) {
        dataBaseDAO.delete(task)
    }

    override suspend fun update(task: Task) {
        dataBaseDAO.update(task)
    }
}