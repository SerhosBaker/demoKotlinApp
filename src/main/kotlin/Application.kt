package com.example.demo

import ru.tinkoff.kora.application.graph.KoraApplication
import ru.tinkoff.kora.common.KoraApp
import ru.tinkoff.kora.http.server.undertow.UndertowHttpServerModule

import ru.tinkoff.kora.config.hocon.HoconConfigModule
import ru.tinkoff.kora.database.jdbc.JdbcDatabaseModule

@KoraApp
interface Application :
    UndertowHttpServerModule,
    HoconConfigModule,
    JdbcDatabaseModule

fun main() {
    KoraApplication.run { ApplicationGraph.graph() }
}
