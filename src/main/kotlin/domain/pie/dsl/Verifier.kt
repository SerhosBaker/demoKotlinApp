package com.example.demo.domain.pie.dsl

class Verifier<WhenT> : Dsl {
    private var givenAction: (() -> Unit)? = null
    private var whenAction: (() -> WhenT?)? = null
    private var thenAction: ((WhenT?) -> Unit)? = null

    fun given(block: () -> Unit): Verifier<WhenT> {
        givenAction = block
        return this
    }

    fun whenEx(block: () -> WhenT?): Verifier<WhenT> {
        whenAction = block
        return this
    }

    fun then(block: ResultScope<WhenT?>.() -> Unit): Verifier<WhenT> {
        thenAction = {
            val scope = ResultScope<WhenT?>(it)
            scope.block()
        }
        return this
    }

    fun run() = process<Verifier<WhenT>, Unit> {
        givenAction?.invoke()
        val whenResult = whenAction?.invoke()
        thenAction?.invoke(whenResult)
    }
}

fun <WhenT> test(block: Verifier<WhenT>.() -> Unit) {
    val verifier = Verifier<WhenT>()
    verifier.block()
    verifier.run()
}
