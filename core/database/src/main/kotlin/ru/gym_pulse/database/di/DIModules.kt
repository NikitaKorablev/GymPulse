package ru.gym_pulse.database.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.gym_pulse.database.data.dao.ExerciseDao
import ru.gym_pulse.database.data.datasource.ExerciseSourceImpl
import ru.gym_pulse.database.domain.datasource.ExerciseSource
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
}