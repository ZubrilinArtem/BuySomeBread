package ru.zubrilin.buysomebread.presenter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import ru.zubrilin.buysomebread.App
import ru.zubrilin.buysomebread.R
import ru.zubrilin.buysomebread.databinding.FragmentTaskBinding
import ru.zubrilin.buysomebread.data.entities.Task
import ru.zubrilin.buysomebread.model.TaskViewModel

class TaskFragment : Fragment() {

    private val viewModel: TaskViewModel by viewModels {
        TaskViewModel.TaskViewModelFactory((context?.applicationContext as App).repository)
    }

    private var _binding: FragmentTaskBinding? = null
    private val binding get() = _binding!!
    private var task: Task? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTaskBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        task = arguments?.getSerializable("task") as Task
        binding.btnSave.setOnClickListener{onClickSave()}
    }

    override fun onStart() {
        super.onStart()

        if (task != null){
            binding.editName.setText(task?.name)
        }

    }

    private fun onClickSave(){
        if (task != null){
            viewModel.update(Task(id = task!!.id, name = binding.editName.text.toString()))
        }else{
            viewModel.insert(Task(name = binding.editName.text.toString()))
        }
        findNavController().navigate(R.id.action_taskFragment_to_mainFragment)
    }



    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

}