package ru.zubrilin.buysomebread.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.CoroutineScope
import ru.zubrilin.buysomebread.data.entities.Category
import ru.zubrilin.buysomebread.data.entities.Item
import ru.zubrilin.buysomebread.data.entities.Nomenclature
import ru.zubrilin.buysomebread.data.entities.Task

@Database(
    entities = [Task::class, Category::class, Nomenclature::class, Item::class],
    version = 5,
    exportSchema = false
)
abstract class AbstractDataBaseDao : RoomDatabase() {

    abstract fun getDao(): DataBaseDAO

    //singleTon pattern
    companion object {
        private var INSTANCE: AbstractDataBaseDao? = null

        fun getDatabase(context: Context, scope: CoroutineScope): AbstractDataBaseDao {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AbstractDataBaseDao::class.java,
                    "buy_some_bread"
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                instance
            }
        }
    }

}