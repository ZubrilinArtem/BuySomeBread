package ru.zubrilin.buysomebread.model

import androidx.lifecycle.*
import ru.zubrilin.buysomebread.data.DataBaseRepository
import ru.zubrilin.buysomebread.data.entities.Task
import java.lang.IllegalArgumentException

class MainViewModel(repository: DataBaseRepository): ViewModel() {

    val allTask: LiveData<List<Task>> = repository.allTasks.asLiveData()

    class MainViewModelFactory(private val repository: DataBaseRepository): ViewModelProvider.Factory{
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(MainViewModel::class.java)){
                @Suppress("UNCHECKED_CAST")
                return MainViewModel(repository) as T
            }
            throw IllegalArgumentException("Неизвестный класс ViewModel")
        }

    }

}