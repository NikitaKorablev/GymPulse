package ru.gym_pulse.database.data.datasource

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.gym_pulse.database.data.dao.ExerciseDao
import ru.gym_pulse.database.data.entities.ExerciseEntity
import ru.gym_pulse.database.domain.datasource.ExerciseSource
import ru.gym_pulse.database.model.Exercise
import javax.inject.Inject

class ExerciseSourceImpl @Inject constructor(
    val exerciseDao: ExerciseDao
): ExerciseSource {
    override suspend fun getEx(id: Int): Exercise?
    = withContext(Dispatchers.IO) {
        exerciseDao.getExercise(id)?.toDomain()
    }

    override suspend fun addEx(ex: Exercise)
    = withContext(Dispatchers.IO) {
        exerciseDao.addExercise(ex.toEntity())
    }

    private fun ExerciseEntity.toDomain() = Exercise(id, name)
    private fun Exercise.toEntity() = ExerciseEntity(id, name)
}