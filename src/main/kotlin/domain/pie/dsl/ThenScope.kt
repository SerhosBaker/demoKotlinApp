package com.example.demo.domain.pie.dsl

class ThenScope<T> internal constructor(private val result: T?) {
    infix fun result(block: ResultScope<T>.() -> Unit) {
        ResultScope(result).block()
    }
}
