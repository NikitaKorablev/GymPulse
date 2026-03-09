package ru.gym_pulse.database.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.gym_pulse.database.AppDatabase
import ru.gym_pulse.database.data.dao.ExerciseDao
import ru.gym_pulse.database.data.dao.TrainingDao
import ru.gym_pulse.database.data.dao.WorkoutDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {
    @Provides
    @Singleton
    fun provideExerciseDao(appDatabase: AppDatabase)
    : ExerciseDao = appDatabase.exerciseDao()

    @Provides
    @Singleton
    fun provideTrainingDao(appDatabase: AppDatabase)
    : TrainingDao = appDatabase.trainingDao()

    @Provides
    @Singleton
    fun provideWorkoutDao(appDatabase: AppDatabase)
    : WorkoutDao = appDatabase.workoutDao()
}