package ru.gym_pulse.domain.repository

import ru.gym_pulse.domain.model.Workout

interface WorkoutRepository {
    suspend fun get(id: Int): Workout?
    suspend fun add(workout: Workout)
}