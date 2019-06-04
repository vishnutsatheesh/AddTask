package com.test.addtask.viewmodel


import android.app.DatePickerDialog
import android.content.Context
import android.text.format.DateUtils
import android.widget.Toast
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.test.addtask.BR
import com.test.addtask.db.entity.Assignee
import com.test.addtask.db.entity.Attachement
import com.test.addtask.db.entity.Task
import java.text.DateFormat
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class AddTaskViewModel : ViewModel() {

    var context: Context? = null
    lateinit var task: ObservableField<Task>

    lateinit var assignees: ArrayList<Assignee>
    lateinit var task_attachements: List<Attachement>
    lateinit var optional_attachements: List<Attachement>

    lateinit var objTask:Task

    fun init(_context: Context) {
        context = _context
        task = ObservableField()

        assignees= ArrayList<Assignee>()
        task_attachements= ArrayList<Attachement>()
        optional_attachements= ArrayList<Attachement>()
        objTask=Task("Examm","","",assignees,"","",task_attachements,optional_attachements)
        notifyTask()
    }
    fun notifyTask()
    {
        task.set(objTask)

    }

    fun selectDate() {
        val calendar = GregorianCalendar()
        calendar.timeInMillis = System.currentTimeMillis()
        val mdiDialog = DatePickerDialog(
            context,
            DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                Toast.makeText(
                    context,
                    "$year $monthOfYear $dayOfMonth", Toast.LENGTH_LONG
                ).show()

                val numberFormat = DecimalFormat("##00")

                val string_date="${numberFormat.format(dayOfMonth)} ${numberFormat.format(monthOfYear+1)} $year"

                objTask.date=string_date
                objTask.title="dddddd"
                notifyTask()

//                selected_date.set(when(DateUtils.isToday(date.time))
//                {
//                    true->"Today"
//                    else-> "$string_date"
//                })

            }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)
        )
        mdiDialog.show()

    }
}
