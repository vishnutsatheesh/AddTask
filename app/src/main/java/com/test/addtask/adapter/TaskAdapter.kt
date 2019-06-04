
package com.test.addtask.adapter

import android.view.LayoutInflater
import android.widget.TextView
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.test.addtask.R
import com.test.addtask.db.entity.Task

class TaskAdapter : RecyclerView.Adapter<TaskAdapter.NoteHolder>() {
    private var tasks: List<Task> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.task_item, parent, false)
        return NoteHolder(itemView)
    }

    override fun onBindViewHolder(holder: NoteHolder, position: Int) {
        val currentNote = tasks[position]
        holder.textViewTitle.text = currentNote.title
        holder.textViewDescription.text = currentNote.taskplace
    }

    override fun getItemCount(): Int {
        return tasks.size
    }

    fun setNotes(tasks: List<Task>) {
        this.tasks = tasks
        notifyDataSetChanged()
    }

    inner class NoteHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textViewTitle: TextView = itemView.findViewById(R.id.text_view_title)
        var textViewDescription: TextView = itemView.findViewById(R.id.text_view_description)

    }
}