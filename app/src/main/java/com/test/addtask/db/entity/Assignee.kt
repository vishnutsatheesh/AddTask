package com.test.addtask.db.entity

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey


data class Assignee(

    var name: String,

    var image: String,

    var isSelected: Boolean

)