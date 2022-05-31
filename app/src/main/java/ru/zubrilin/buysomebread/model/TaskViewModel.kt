package ru.zubrilin.buysomebread.model

import androidx.lifecycle.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ru.zubrilin.buysomebread.data.DataBaseRepository
import ru.zubrilin.buysomebread.data.entities.Task
import java.lang.IllegalArgumentException

class TaskViewModel(private val repository: DataBaseRepository): ViewModel() {

    fun insert(task: Task) = viewModelScope.launch {
        repository.insert(task)
    }

    fun update(task: Task) = viewModelScope.launch {
        repository.update(task)
    }

    class TaskViewModelFactory(private val repository: DataBaseRepository): ViewModelProvider.Factory{
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(TaskViewModel::class.java)){
                @Suppress("UNCHECKED_CAST")
                return TaskViewModel(repository) as T
            }
            throw IllegalArgumentException("Неизвестный класс ViewModel")
        }

    }

}