package com.test.addtask.db



import android.content.Context
import android.os.AsyncTask
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.test.addtask.db.converter.GithubTypeConverters
import com.test.addtask.db.dao.TaskDao
import com.test.addtask.db.entity.Task


@Database(entities = [Task::class], version = 1)
@TypeConverters(GithubTypeConverters::class)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun noteDao(): TaskDao


    companion object {
        private var instance: NoteDatabase? = null

        fun getInstance(context: Context): NoteDatabase? {
            if (instance == null) {
                synchronized(NoteDatabase::class) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        NoteDatabase::class.java, "task_database"
                    )
                        .fallbackToDestructiveMigration()
                        .addCallback(roomCallback)
                        .build()
                }
            }
            return instance
        }

        fun destroyInstance() {
            instance = null
        }

        private val roomCallback = object : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                PopulateDbAsyncTask(instance)
                    .execute()
            }
        }

    }
    class PopulateDbAsyncTask(db: NoteDatabase?) : AsyncTask<Unit, Unit, Unit>() {
        private val noteDao = db?.noteDao()

        override fun doInBackground(vararg p0: Unit?) {
//            noteDao?.insert(Task("Title 1", "description 1"))
//            noteDao?.insert(Task("Title 2", "description 2"))
//            noteDao?.insert(Task("Title 3", "description 3"))
        }
    }

}