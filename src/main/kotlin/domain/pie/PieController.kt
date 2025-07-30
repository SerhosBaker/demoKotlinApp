package com.example.demo.domain.pie

import com.example.demo.domain.pie.dto.MeetPie
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
@RequestMapping("/pies")
class PieController {

    @GetMapping("/meet")
    fun getPie(@RequestParam weight: Int, @RequestParam orderedFor: String): MeetPie {
        return MeetPie(weight = 100, orderedFor = "Me", bakedAt = LocalDateTime.now())
    }
}
