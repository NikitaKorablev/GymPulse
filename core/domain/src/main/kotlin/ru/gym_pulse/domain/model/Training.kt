package ru.gym_pulse.domain.model

import java.time.LocalDateTime

data class Training(
    val id: Int = 0,
    val date: LocalDateTime = LocalDateTime.now(),
)
