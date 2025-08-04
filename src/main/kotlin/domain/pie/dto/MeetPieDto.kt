package com.example.demo.domain.pie.dto

import java.time.LocalDateTime

data class MeetPieDto(
    val bakedAt: LocalDateTime = LocalDateTime.now(),
    override val weight: Int,
    override val orderedFor: String
) : PieDto(weight, orderedFor)
