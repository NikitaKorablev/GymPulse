package ru.gym_pulse.domain.repository

import ru.gym_pulse.domain.model.Training

interface TrainingRepository {
    suspend fun get(id: Int): Training?
    suspend fun add(training: Training)
}