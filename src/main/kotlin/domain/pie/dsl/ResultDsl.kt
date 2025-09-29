package com.example.demo.domain.pie.dsl

class ResultDsl<Out> private constructor(
    private val result: Out?,
    private val then: (Out?) -> Unit
) {
    fun isNotNull(message: String = "Result must not be null") {
        then(requireNotNull(result) {
            message
        })
    }

    fun size(block: Int.() -> Unit) {
        isNotNull()
        val size = (result as? Collection<*>)?.size
            ?: throw IllegalStateException("Result is not a Collection")

        size.block()
    }

    companion object {
        fun <Out> forResult(result: Out?, then: (Out?) -> Unit): ResultDsl<Out> {
            return ResultDsl(result, then)
        }
    }
}
