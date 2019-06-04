package com.test.addtask.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.test.addtask.db.entity.Assignee
import com.test.addtask.db.entity.Task

@Dao
interface TaskDao {

    @Insert
    fun insert(task: Task)

    @Query("DELETE FROM task_table")
    fun deleteAllNotes()

    @Query("SELECT * FROM task_table ")
    fun getAllNotes(): LiveData<List<Task>>


}