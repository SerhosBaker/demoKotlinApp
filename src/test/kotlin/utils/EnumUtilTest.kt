package com.example.demo.utils

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.within
import org.junit.jupiter.api.Test
import utils.enum.RoundingStatusDto
import utils.enum.RoundingStatusDto.PENDING
import java.time.Instant
import java.time.ZonedDateTime
import java.time.temporal.ChronoUnit

class EnumUtilTest {

    @Test
    fun `when_getRoundingStatusDtoFromString_then_returnCorrectEnum`() {
        val givenStatusString = "PENDING"
        val givenStatusEnum: RoundingStatusDto = PENDING

        val actualStatusEnum: RoundingStatusDto = EnumUtil.getRoundingStatusDtoFromString(givenStatusString)

        assert(actualStatusEnum == givenStatusEnum)
        assert(PENDING.name.equals(givenStatusString))
        assert(PENDING.toString().equals(givenStatusString))

        println(Instant.now())
    }

    @Test
    fun `test DateTime assertions`(){
        val zonedDateTime: ZonedDateTime = ZonedDateTime.parse("2000-01-01T00:00:00Z")

        assertThat(zonedDateTime).isCloseTo(zonedDateTime.plusHours(1), within(90, ChronoUnit.MINUTES))
    }
}
