package com.example.demo.domain.pie

import com.example.demo.domain.pie.dto.MeetPie
import ru.tinkoff.kora.common.Component
import ru.tinkoff.kora.common.Mapping
import ru.tinkoff.kora.database.common.annotation.Query
import ru.tinkoff.kora.database.common.annotation.Repository
import ru.tinkoff.kora.database.jdbc.JdbcRepository
import ru.tinkoff.kora.database.jdbc.mapper.result.JdbcResultSetMapper
import java.sql.ResultSet
import java.sql.SQLException

@Repository
interface PieRepository : JdbcRepository {
    @Mapping(PieResultMapper::class)
    @Query("SELECT ordered_for FROM smarkov.pie WHERE ordered_for = :orderedFor")
    fun findPies(orderedFor: String): String
}

class PieResultMapper : JdbcResultSetMapper<String> {

    @Throws(SQLException::class)
    override fun apply(rs: ResultSet): String {
        return rs.getString("ordered_for")
    }
}
