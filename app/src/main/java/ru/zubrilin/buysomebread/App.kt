package ru.zubrilin.buysomebread

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import ru.zubrilin.buysomebread.data.room.AbstractDataBaseDao
import ru.zubrilin.buysomebread.data.repository.DataBaseRoomRepository
import ru.zubrilin.buysomebread.presenter.MainActivity

class App: Application() {

    val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy {AbstractDataBaseDao.getDatabase(this, applicationScope)}
    val repository by lazy { DataBaseRoomRepository(database.getDao()) }
    lateinit var app_activity: MainActivity
}