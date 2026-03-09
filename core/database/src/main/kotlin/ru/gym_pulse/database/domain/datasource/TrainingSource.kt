package ru.gym_pulse.database.domain.datasource

import ru.gym_pulse.database.model.Training

interface TrainingSource {
    suspend fun get(id: Int): Training?
    suspend fun add(training: Training)
}