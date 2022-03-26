package edu.quintrix.donuts

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao

@Dao
interface DonutDao {
    @Insert
    suspend fun insert(donut:Donut)

    @Update
    suspend fun update(donut:Donut)

    @Delete
    suspend fun delete(donut:Donut)

    @Query("SELECT * FROM donut_table WHERE taskId = :taskId")
    fun get (taskId:Long): LiveData<Donut>

    @Query("SELECT * FROM donut_table ORDER BY taskId DESC")
    fun getAll() : LiveData<List<Donut>>
}