package com.example.demo.domain.pie.dsl

import org.junit.Assert.assertEquals

class ResultScope<T>(private val value: T?) {

    companion object {
        private const val EQUALITY_ASSERT_MESSAGE = "Expected %s but was %s"

        fun <T> assert(value: T, block: ResultScope<T>.() -> Unit) {
            ResultScope(value).block()
        }
    }

    val size: Int get() = (value as? Collection<*>)?.size ?: error("Value is not a collection")

    fun size(block: Int.() -> Unit): ResultScope<T> {
        size.block()
        return this
    }

    fun isEqualTo(expected: Any?) {
        if (value != expected) {
            throw AssertionError("Expected $expected but got $value")
        }
    }

    fun isNotEqualTo(expected: Any?) {
        if (value == expected) {
            throw AssertionError("Expected that value $value is not equal to $expected")
        }
    }

    fun result(block: () -> Unit): ResultScope<T> {
        block.invoke()
        return this
    }
}
