package ru.gym_pulse.database.data.datasource

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.gym_pulse.database.data.dao.TrainingDao
import ru.gym_pulse.database.data.entities.TrainingEntity
import ru.gym_pulse.database.domain.datasource.TrainingSource
import ru.gym_pulse.database.model.Training
import javax.inject.Inject

class TrainingSourceImpl @Inject constructor(
    val trainingDao: TrainingDao
): TrainingSource {
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