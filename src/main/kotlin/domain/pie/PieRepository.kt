package com.example.demo.domain.pie

import com.example.demo.domain.pie.dto.PieDto
import ru.tinkoff.kora.common.Mapping
import ru.tinkoff.kora.database.common.annotation.Query
import ru.tinkoff.kora.database.common.annotation.Repository
import ru.tinkoff.kora.database.jdbc.JdbcRepository
import ru.tinkoff.kora.database.jdbc.mapper.result.JdbcRowMapper
import java.sql.ResultSet
import java.sql.SQLException

@Repository
interface PieRepository : JdbcRepository {
    @Mapping(PieResultMapper::class)
    @Query("SELECT weight, ordered_for FROM smarkov.pie WHERE ordered_for = :orderedFor")
    fun findPies(orderedFor: String): List<PieDto>
}

class PieResultMapper : JdbcRowMapper<PieDto> {

    @Throws(SQLException::class)
    override fun apply(rs: ResultSet): PieDto {
        return PieDto(weight = rs.getInt("weight"), orderedFor = rs.getString("ordered_for"))
    }
}
