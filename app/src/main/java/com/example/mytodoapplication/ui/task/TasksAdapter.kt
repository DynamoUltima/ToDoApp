package com.example.mytodoapplication.ui.task

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mytodoapplication.data.Task
import com.example.mytodoapplication.databinding.ItemTaskBinding

class TasksAdapter:ListAdapter<Task,TasksAdapter.TasksViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TasksViewHolder {
        TODO("Not yet implemented")
        val binding= ItemTaskBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return TasksViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TasksViewHolder, position: Int) {
        TODO("Not yet implemented")
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }

    class TasksViewHolder(private val binding: ItemTaskBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(task: Task){
            binding.apply {
                checkboxCompleted.isChecked =task.completed
                textViewName.text= task.name
                textViewName.paint.isStrikeThruText =task.completed
                labelPriority.isVisible= task.important
            }

        }
    }

    class DiffCallback:DiffUtil.ItemCallback<Task>(){
        override fun areItemsTheSame(oldItem: Task, newItem: Task)= oldItem.id==newItem.id

        override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean {
            TODO("Not yet implemented")
            return  oldItem ==newItem
        }
    }
}