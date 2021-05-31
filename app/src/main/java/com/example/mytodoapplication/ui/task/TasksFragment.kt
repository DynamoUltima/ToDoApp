package com.example.mytodoapplication.ui.task

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.mytodoapplication.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TasksFragment: Fragment(R.layout.fragments_tasks) {
    private  val viewModel :TasksViewModel by viewModels()
}