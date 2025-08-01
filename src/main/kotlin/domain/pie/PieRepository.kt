package com.example.demo.domain.pie

import com.example.demo.domain.pie.dto.MeetPie
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository
import java.sql.ResultSet
import java.time.LocalDateTime

@Repository
class PieRepository(private val jdbcTemplate: JdbcTemplate) {

    fun findPies(orderedFor: String): List<MeetPie> {
        val sql = "SELECT * FROM smarkov.pie WHERE ordered_for = ?"

        return try {
            jdbcTemplate.query(
                sql,
                { rs: ResultSet, rowNum: Int ->
                    MeetPie(rs.getInt("weight"), rs.getString("ordered_for"), LocalDateTime.now(), "1")
                },
                orderedFor
            )
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }
}