package com.test.addtask.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.test.addtask.R
import com.test.addtask.databinding.ActivityAddTaskBindingImpl
import com.test.addtask.viewmodel.AddTaskViewModel
import kotlinx.android.synthetic.main.activity_add_task.*





class AddTaskActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_TITLE = "com.test.addtask.EXTRA_TITLE"
        const val EXTRA_DESCRIPTION = "com.test.addtask.EXTRA_DESCRIPTION"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding:ActivityAddTaskBindingImpl = DataBindingUtil.setContentView(
            this,
            R.layout.activity_add_task
        )
        val addTaskViewModel = AddTaskViewModel()
        addTaskViewModel.init(this)
        binding.addtaskViewModel=addTaskViewModel
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.add_task_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            R.id.save_note -> {
                saveNote()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun saveNote() {
//        if (edit_text_title.text.toString().trim().isBlank() || edit_text_description.text.toString().trim().isBlank()) {
//            Toast.makeText(this, "Can not insert empty note!", Toast.LENGTH_SHORT).show()
//            return
//        }
//
//        val data = Intent().apply {
//            putExtra(EXTRA_TITLE, edit_text_title.text.toString())
//            putExtra(EXTRA_DESCRIPTION, edit_text_description.text.toString())
//        }
//
//        setResult(Activity.RESULT_OK, data)
        finish()
    }
}
