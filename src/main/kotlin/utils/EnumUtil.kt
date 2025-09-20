package com.example.demo.utils

import utils.enum.RoundingStatusDto

class EnumUtil {
    companion object {
        fun getRoundingStatusDtoFromString(status: String): RoundingStatusDto {
            return when (status) {
                "PENDING" -> RoundingStatusDto.PENDING
                "FAILED" -> RoundingStatusDto.FAILED
                "FINISHED" -> RoundingStatusDto.FINISHED
                else -> throw IllegalArgumentException("Invalid status: $status")
            }
        }
    }
}
