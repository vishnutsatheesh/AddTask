package com.test.addtask.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.test.addtask.R
import com.test.addtask.adapter.TaskAdapter
import com.test.addtask.db.entity.Task
import com.test.addtask.viewmodel.TaskViewModel


class MainActivity : AppCompatActivity() {
    private val ADD_NOTE_REQUEST = 1
    private lateinit var taskViewModel: TaskViewModel
    private val adapter = TaskAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
//        buttonAddNote.setOnClickListener {
//            startActivityForResult(
//                Intent(this, AddTaskActivity::class.java),
//                ADD_NOTE_REQUEST
//            )
//        }
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter

        taskViewModel = ViewModelProviders.of(this).get(TaskViewModel::class.java)
        taskViewModel.getAllNotes().observe(this,
            Observer<List<Task>> { t -> adapter.setNotes(t!!) })
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.add_task_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            R.id.save_note -> {
                startActivity(Intent(this, AddTaskActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == ADD_NOTE_REQUEST && resultCode == Activity.RESULT_OK) {
//            val newTask = Task(
//                data!!.getStringExtra(AddTaskActivity.EXTRA_TITLE),
//                data.getStringExtra(AddTaskActivity.EXTRA_DESCRIPTION))
//            taskViewModel.insert(newTask)

            Toast.makeText(this, "Task saved!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Task not saved!", Toast.LENGTH_SHORT).show()
        }


    }
}