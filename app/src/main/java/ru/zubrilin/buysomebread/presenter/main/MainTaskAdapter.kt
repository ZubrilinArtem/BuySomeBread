package ru.zubrilin.buysomebread.presenter.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.zubrilin.buysomebread.R
import ru.zubrilin.buysomebread.data.entities.Task
import ru.zubrilin.buysomebread.databinding.TaskItemBinding

class MainTaskAdapter: ListAdapter<Task, MainTaskAdapter.TaskViewHolder>(TaskComparator()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder.create(parent)
    }

    override fun getItemCount(): Int {
        return currentList.size
    }

    override fun onViewAttachedToWindow(holder: TaskViewHolder) {

        super.onViewAttachedToWindow(holder)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    class TaskViewHolder(view: View): RecyclerView.ViewHolder(view){

        private val binding = TaskItemBinding.bind(view)

        fun bind(task: Task) = with(binding){
            tvName.text = task.name
            tvCount.text = "0"
            tvCountComplete.text = "0"
        }

        companion object {
            fun create(parent: ViewGroup): TaskViewHolder{
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.task_item, parent, false)
                return TaskViewHolder(view)
            }
        }
    }

    class TaskComparator: DiffUtil.ItemCallback<Task>(){
        override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean {
            return oldItem.id == newItem.id
        }

    }

}