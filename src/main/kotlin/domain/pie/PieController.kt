package com.example.demo.domain.pie

import com.example.demo.domain.pie.dto.MeetPie
import com.example.demo.domain.pie.mapping.PieResponseMapper
import io.netty.handler.codec.http.HttpMethod
import ru.tinkoff.kora.common.Component
import ru.tinkoff.kora.common.Mapping
import ru.tinkoff.kora.http.common.HttpMethod.GET
import ru.tinkoff.kora.http.common.HttpMethod.POST
import ru.tinkoff.kora.http.common.annotation.HttpRoute
import ru.tinkoff.kora.http.common.annotation.Path
import ru.tinkoff.kora.http.common.annotation.Query
import ru.tinkoff.kora.http.server.common.annotation.HttpController
import java.time.LocalDateTime

@Component
@HttpController
class PieController(private val pieRepository: PieRepository) {

    // Hello world веб приложения. Контроллер работает, отдает принятые параметры в ответе
    @HttpRoute(method = GET, path = "/pies/meet")
    fun getPie(@Query weight: Int, @Query orderedFor: String): String {
        return MeetPie(weight = weight, orderedFor = orderedFor, bakedAt = LocalDateTime.now(), id = "1").toString();
    }

    // Проверка работы с БД
    @Mapping(PieResponseMapper::class)
    @HttpRoute(method = GET, path = "/pies/all/{orderedFor}")
    fun getPies(@Path("orderedFor") orderedFor: String): List<String> {
        return pieRepository.findPies(orderedFor)
    }
}
