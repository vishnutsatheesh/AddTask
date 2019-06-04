package com.test.addtask.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.test.addtask.db.converter.GithubTypeConverters


@Entity(tableName = "task_table")
data class Task(

    var title: String,

    var type: String,

    var status: String,

    val assignees: List<Assignee>,

    var date: String,

    var taskplace: String,

    var task_attachements: List<Attachement>,

    var optional_attachements: List<Attachement>

) {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

}