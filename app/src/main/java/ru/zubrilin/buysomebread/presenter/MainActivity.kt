package ru.zubrilin.buysomebread.presenter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import ru.zubrilin.buysomebread.App
import ru.zubrilin.buysomebread.R
import ru.zubrilin.buysomebread.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    val binding get() = _binding!!
    lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navController = Navigation.findNavController(this, R.id.navHost)
        (applicationContext as App).app_activity = this
            }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}