package ru.gym_pulse.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.gym_pulse.data.repository.ExerciseRepositoryImpl
import ru.gym_pulse.data.repository.TrainingRepositoryImpl
import ru.gym_pulse.data.repository.WorkoutRepositoryImpl
import ru.gym_pulse.database.data.dao.ExerciseDao
import ru.gym_pulse.database.data.dao.TrainingDao
import ru.gym_pulse.database.data.dao.WorkoutDao
import ru.gym_pulse.domain.repository.ExerciseRepository
import ru.gym_pulse.domain.repository.TrainingRepository
import ru.gym_pulse.domain.repository.WorkoutRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DIModules {
    @Provides
    @Singleton
    fun provideExerciseSource(
        exerciseDao: ExerciseDao
    ): ExerciseRepository = ExerciseRepositoryImpl(
        exerciseDao
    )

    @Provides
    @Singleton
    fun provideTrainingSource(
        trainingDao: TrainingDao
    ): TrainingRepository = TrainingRepositoryImpl(
        trainingDao
    )

    @Provides
    @Singleton
    fun provideWorkoutSource(
        workoutDao: WorkoutDao
    ): WorkoutRepository = WorkoutRepositoryImpl(
        workoutDao
    )
}