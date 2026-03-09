package ru.gym_pulse.database.data.datasource

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.gym_pulse.database.data.dao.WorkoutDao
import ru.gym_pulse.database.data.entities.WorkoutEntity
import ru.gym_pulse.database.domain.datasource.WorkoutSource
import ru.gym_pulse.database.model.Workout
import javax.inject.Inject

class WorkoutSourceImpl @Inject constructor(
    val workoutDao: WorkoutDao
) : WorkoutSource {
    override suspend fun get(id: Int): Workout?
    = withContext(Dispatchers.IO) {
        workoutDao.get(id)?.toDomain()
    }

    override suspend fun add(workout: Workout)
    = withContext(Dispatchers.IO) {
        workoutDao.add(workout.toEntity())
    }

    private fun WorkoutEntity.toDomain() = Workout(id, exNum, trainingNum)
    private fun Workout.toEntity() = WorkoutEntity(id, example, training)
}