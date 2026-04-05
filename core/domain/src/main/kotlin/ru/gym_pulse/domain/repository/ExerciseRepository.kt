package ru.gym_pulse.domain.repository

import ru.gym_pulse.domain.model.Exercise

interface ExerciseRepository {
    suspend fun getEx(id: Int): Exercise?
    suspend fun addEx(ex: Exercise)
}