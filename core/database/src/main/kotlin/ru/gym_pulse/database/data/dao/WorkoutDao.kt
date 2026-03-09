package ru.gym_pulse.database.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.gym_pulse.database.data.entities.WorkoutEntity

@Dao
interface WorkoutDao {
    @Query("Select * From workouts where id = :id")
    suspend fun get(id: Int): WorkoutEntity?

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun add(workout: WorkoutEntity)
}