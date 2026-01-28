package com.example.demo.domain.pie

import com.example.demo.domain.pie.dto.MeetPieDto
import com.example.demo.domain.pie.dto.PieDto
import com.example.demo.domain.pie.mapping.PieResponseMapper
import ru.tinkoff.kora.common.Component
import ru.tinkoff.kora.common.Mapping
import ru.tinkoff.kora.http.common.HttpMethod.GET
import ru.tinkoff.kora.http.common.annotation.HttpRoute
import ru.tinkoff.kora.http.common.annotation.Path
import ru.tinkoff.kora.http.common.annotation.Query
import ru.tinkoff.kora.http.server.common.annotation.HttpController
import java.time.LocalDateTime

@Component
@HttpController
class PieController(private val pieRepository: PieRepository) {

    // Hello world веб приложения. Контроллер работает, в ответе отдает параметры запроса, зеркалит
    @HttpRoute(method = GET, path = "/pies/meet")
    fun getPie(@Query weight: Int, @Query orderedFor: String): String {
        return MeetPieDto(weight = weight, orderedFor = orderedFor, bakedAt = LocalDateTime.now()).toString();
    }

    // Проверяет работу с БД
    @Mapping(PieResponseMapper::class)
    @HttpRoute(method = GET, path = "/pies/all/{orderedFor}")
    fun getPies(@Path("orderedFor") orderedFor: String): List<PieDto> {
        return pieRepository.findPies(orderedFor)
    }
}
