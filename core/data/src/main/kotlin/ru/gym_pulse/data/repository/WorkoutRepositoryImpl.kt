package ru.gym_pulse.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.gym_pulse.database.data.dao.WorkoutDao
import ru.gym_pulse.database.data.entities.WorkoutEntity
import ru.gym_pulse.domain.model.Workout
import ru.gym_pulse.domain.repository.WorkoutRepository
import javax.inject.Inject

class WorkoutRepositoryImpl @Inject constructor(
    val workoutDao: WorkoutDao
) : WorkoutRepository {
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