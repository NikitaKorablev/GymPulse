package ru.gym_pulse.database.domain.datasource

import ru.gym_pulse.database.model.Workout

interface WorkoutSource {
    suspend fun get(id: Int): Workout?
    suspend fun add(workout: Workout)
}