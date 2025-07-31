package com.example.demo.domain.pie.dto

import java.time.LocalDateTime

data class MeetPie(
    val weight: Int,
    val orderedFor: String,
    val bakedAt: LocalDateTime = LocalDateTime.now()
)
