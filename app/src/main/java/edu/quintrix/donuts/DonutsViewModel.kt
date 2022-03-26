package edu.quintrix.donuts
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
class DonutsViewModel(val dao: DonutDao):ViewModel() {
    var newTaskName = ""
    val tasks : LiveData<List<Donut>> = dao.getAll()
//    val tasksString = Transformations.map(tasks){
//            tasks->formatTasks((tasks))
//    }
//    fun formatTasks(tasks:List<Task>):String{
//        return tasks.fold(""){
//                str,item -> str + '\n' + convertToString(item)
//        }
//    }
//    fun convertToString(task:Task):String{
//        var str = "ID: ${task.taskId}"
//        str += '\n'+ "Name : ${task.taskName}"
//        str+= '\n' + "Complete : ${task.taskDone}" + '\n'
//        return str
//    }
    fun addDonuts(){
        viewModelScope.launch {
            val task = Donut()
            task.taskName = newTaskName
            dao.insert(task)
        }
    }
}