package ru.zubrilin.buysomebread.presenter.main

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import ru.zubrilin.buysomebread.App
import ru.zubrilin.buysomebread.R
import ru.zubrilin.buysomebread.data.entities.Task
import ru.zubrilin.buysomebread.databinding.FragmentMainBinding
import ru.zubrilin.buysomebread.model.MainViewModel

class MainFragment : Fragment() {

    private var _binding:FragmentMainBinding? = null
    private val binding get() = _binding!!
    private val mainViewModel: MainViewModel by viewModels {
        MainViewModel.MainViewModelFactory((context?.applicationContext as App).repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mainAdapter = MainTaskAdapter()
        binding.rvTask.adapter = mainAdapter
        binding.rvTask.layoutManager = LinearLayoutManager(context)
        mainViewModel.allTask.observe(viewLifecycleOwner){
            it.let { mainAdapter.submitList(it) }
        }

        binding.btnAdd.setOnClickListener{
            findNavController().navigate(R.id.action_mainFragment_to_taskFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object{
        fun click(task: Task, context: Context){
            val bundle = Bundle()
            bundle.putSerializable("task", task)
            (context.applicationContext as App).app_activity
                .navController.navigate(R.id.action_mainFragment_to_taskFragment, bundle)
        }
    }

}