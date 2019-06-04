package com.test.addtask

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import com.test.addtask.db.NoteDatabase
import com.test.addtask.db.dao.TaskDao
import com.test.addtask.db.entity.Task


class TaskRepository(application: Application) {

    private var noteDao: TaskDao

    private var allNotes: LiveData<List<Task>>

    init {
        val database: NoteDatabase = NoteDatabase.getInstance(
            application.applicationContext
        )!!
        noteDao = database.noteDao()
        allNotes = noteDao.getAllNotes()
    }

    fun insert(task: Task) {
        val insertNoteAsyncTask = InsertNoteAsyncTask(noteDao).execute(task)
    }

    fun deleteAllNotes() {
        val deleteAllNotesAsyncTask = DeleteAllNotesAsyncTask(
            noteDao
        ).execute()
    }

    fun getAllNotes(): LiveData<List<Task>> {
        return allNotes
    }

    private class InsertNoteAsyncTask(noteDao: TaskDao) : AsyncTask<Task, Unit, Unit>() {
        val noteDao = noteDao

        override fun doInBackground(vararg p0: Task?) {
            noteDao.insert(p0[0]!!)
        }
    }


    private class DeleteAllNotesAsyncTask(val noteDao: TaskDao) : AsyncTask<Unit, Unit, Unit>() {

        override fun doInBackground(vararg p0: Unit?) {
            noteDao.deleteAllNotes()
        }
    }

}