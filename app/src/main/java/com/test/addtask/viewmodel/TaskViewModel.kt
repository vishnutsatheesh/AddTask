
package com.test.addtask.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.test.addtask.TaskRepository
import com.test.addtask.db.entity.Task


class TaskViewModel(application: Application) : AndroidViewModel(application) {

    private var repository: TaskRepository =
        TaskRepository(application)

    private var allNotes: LiveData<List<Task>> = repository.getAllNotes()

    fun insert(task: Task) {
        repository.insert(task)
    }

    fun deleteAllNotes() {
        repository.deleteAllNotes()
    }

    fun getAllNotes(): LiveData<List<Task>> {
        return allNotes
    }
}