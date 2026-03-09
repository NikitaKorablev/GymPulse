package ru.gym_pulse.database

import androidx.room.Database
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import ru.gym_pulse.database.data.dao.ExerciseDao
import ru.gym_pulse.database.data.dao.TrainingDao
import ru.gym_pulse.database.data.dao.WorkoutDao
import ru.gym_pulse.database.data.entities.ExerciseEntity
import ru.gym_pulse.database.data.entities.TrainingEntity
import ru.gym_pulse.database.data.entities.WorkoutEntity

@Database(
    version = 1,
    entities = [
        ExerciseEntity::class,
        TrainingEntity::class,
        WorkoutEntity::class,
    ]
)
@TypeConverters(Converters::class)
abstract class AppDatabase {
    abstract fun exerciseDao(): ExerciseDao
    abstract fun trainingDao(): TrainingDao
    abstract fun workoutDao(): WorkoutDao
}