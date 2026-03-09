package ru.gym_pulse.database.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(tableName = "trainings")
data class TrainingEntity(
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    val date: LocalDateTime = LocalDateTime.now()

    //TODO: hill points
)