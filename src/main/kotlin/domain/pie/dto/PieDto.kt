package com.example.demo.domain.pie.dto

open class PieDto(
    open val weight: Int,
    open val orderedFor: String
) {
    @Override
    override fun toString(): String = "$weight - $orderedFor"
}
