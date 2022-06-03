package ru.zubrilin.buysomebread.presenter.main

import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
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


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

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

        binding.bottomAppBar.setOnMenuItemClickListener(this::onMenuClick)

    }

    private fun onMenuClick(menuItem: MenuItem): Boolean{
        when (menuItem.itemId){
            R.id.settings -> {
                Toast.makeText(context, "settings", Toast.LENGTH_SHORT).show()
            }
        }
        return true
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object{
        fun click(task: Task, context: Context){
            (context.applicationContext as App).app_activity
                .navController.navigate(MainFragmentDirections.actionMainFragmentToTaskFragment(task))
        }
    }

}