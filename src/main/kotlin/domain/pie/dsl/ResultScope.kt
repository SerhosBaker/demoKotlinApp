package com.example.demo.domain.pie.dsl

import junit.framework.TestCase.assertEquals

class ResultScope<out T>(private val value: T) {
    fun result(block: ResultScope<T>.() -> Unit): ResultScope<T> {
        ResultScope<T>(value).block()
        return this
    }

    private val size: Int get() = (value as? Collection<*>)?.size ?: error("Not a collection")

    fun size(block: (Int) -> Unit): ResultScope<T> {
        block(size)
        return this
    }

    fun isEqualTo(expected: @UnsafeVariance T): ResultScope<T> {
        assertEquals(expected, value)
        return this
    }
}
