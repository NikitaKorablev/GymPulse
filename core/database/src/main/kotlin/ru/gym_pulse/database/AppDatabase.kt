package ru.gym_pulse.database

import androidx.room.Database
import ru.gym_pulse.database.data.dao.ExerciseDao
import ru.gym_pulse.database.data.entities.ExerciseEntity

@Database(
    version = 1,
    entities = [
        ExerciseEntity::class,
    ]
)
abstract class AppDatabase {
    abstract fun exerciseDao(): ExerciseDao
}