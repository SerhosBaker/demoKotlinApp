package com.example.demo.domain.pie.mapping

import com.example.demo.domain.pie.dto.PieDto
import ru.tinkoff.kora.common.Context
import ru.tinkoff.kora.http.common.body.HttpBody
import ru.tinkoff.kora.http.server.common.HttpServerRequest
import ru.tinkoff.kora.http.server.common.HttpServerResponse
import ru.tinkoff.kora.http.server.common.handler.HttpServerResponseMapper

class PieResponseMapper : HttpServerResponseMapper<List<PieDto>> {
    override fun apply(ctx: Context?, request: HttpServerRequest?, result: List<PieDto>?): HttpServerResponse {
        val body = result?.joinToString("\n") { it.toString() }
        return HttpServerResponse.of(200, HttpBody.plaintext(body));
    }
}
