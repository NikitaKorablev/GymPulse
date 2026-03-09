package ru.gym_pulse.database.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ExerciseEntity(
    @PrimaryKey val id: Int,
    val name: String,
) {
    @PrimaryKey(autoGenerate = true)
    var ind: Int = 0
}
