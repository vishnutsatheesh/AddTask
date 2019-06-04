package com.test.addtask.db.entity

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import java.io.File


data class Attachement(
    var path: String,

    @Ignore
    var file: File

)