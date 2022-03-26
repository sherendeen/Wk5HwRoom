package edu.quintrix.donuts

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "donut_table")
data class Donut(
    @PrimaryKey(autoGenerate = true)
    var taskId:Long = 0L,
    @ColumnInfo(name = "donut_name")
    var taskName:String ="",

    @ColumnInfo(name = "donut_done")
    var taskDone : Boolean = false
)