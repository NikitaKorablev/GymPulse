package ru.gym_pulse.database.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.gym_pulse.database.data.dao.ExerciseDao
import ru.gym_pulse.database.data.dao.TrainingDao
import ru.gym_pulse.database.data.dao.WorkoutDao
import ru.gym_pulse.database.data.datasource.ExerciseSourceImpl
import ru.gym_pulse.database.data.datasource.TrainingSourceImpl
import ru.gym_pulse.database.data.datasource.WorkoutSourceImpl
import ru.gym_pulse.database.domain.datasource.ExerciseSource
import ru.gym_pulse.database.domain.datasource.TrainingSource
import ru.gym_pulse.database.domain.datasource.WorkoutSource
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DIModules {
    @Provides
    @Singleton
    fun provideExerciseSource(
        exerciseDao: ExerciseDao
    ): ExerciseSource = ExerciseSourceImpl(
        exerciseDao
    )

    @Provides
    @Singleton
    fun provideTrainingSource(
        trainingDao: TrainingDao
    ): TrainingSource = TrainingSourceImpl(
        trainingDao
    )

    @Provides
    @Singleton
    fun provideWorkoutSource(
        workoutDao: WorkoutDao
    ): WorkoutSource = WorkoutSourceImpl(
        workoutDao
    )
}