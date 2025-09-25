package com.example.demo.domain.pie.dsl

interface Dsl {
    fun <T : Dsl, R : Any?> process(action: T.() -> R): R {
        return action(this as T)
    }
}
