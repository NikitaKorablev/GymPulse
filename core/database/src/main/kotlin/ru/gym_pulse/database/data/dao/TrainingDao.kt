package ru.gym_pulse.database.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.gym_pulse.database.data.entities.TrainingEntity

@Dao
interface TrainingDao {
    @Query("Select * From trainings where id = :id")
    suspend fun get(id: Int): TrainingEntity?

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun add(training: TrainingEntity)
}