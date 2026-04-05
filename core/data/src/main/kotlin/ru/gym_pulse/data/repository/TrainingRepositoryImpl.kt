package ru.gym_pulse.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.gym_pulse.database.data.dao.TrainingDao
import ru.gym_pulse.database.data.entities.TrainingEntity
import ru.gym_pulse.domain.model.Training
import ru.gym_pulse.domain.repository.TrainingRepository
import javax.inject.Inject

class TrainingRepositoryImpl @Inject constructor(
    val trainingDao: TrainingDao
): TrainingRepository {
    override suspend fun get(id: Int): Training?
    = withContext(Dispatchers.IO) {
        trainingDao.get(id)?.toDomain()
    }

    override suspend fun add(training: Training)
    = withContext(Dispatchers.IO) {
        trainingDao.add(training.toEntity())
    }

    private fun Training.toEntity() = TrainingEntity(id, date)
    private fun TrainingEntity.toDomain() = Training(id, date)
}