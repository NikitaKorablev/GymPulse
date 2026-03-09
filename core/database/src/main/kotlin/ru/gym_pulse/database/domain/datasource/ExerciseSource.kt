package ru.gym_pulse.database.domain.datasource

import ru.gym_pulse.database.model.Exercise

interface ExerciseSource {
    suspend fun getEx(id: Int): Exercise?
    suspend fun addEx(ex: Exercise)
}