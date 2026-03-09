package ru.gym_pulse.database.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.gym_pulse.database.data.entities.ExerciseEntity

@Dao
interface ExerciseDao {
    @Query("Select * From exerciseentity where id = :id")
    suspend fun getExercise(id: Int): ExerciseEntity?

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun addExercise(ex: ExerciseEntity)
}
