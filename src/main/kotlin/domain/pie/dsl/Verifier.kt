package com.example.demo.domain.pie.dsl

object Verifier : Dsl {
    private var givenAction: (() -> Unit)? = null
    private var whenAction: (() -> Any?)? = null
    private var thenAction: ((Any?) -> Unit)? = null

    fun given(block: () -> Unit):Verifier {
        givenAction = block
        return this
    }
    fun whenEx(block: () -> Any?): Verifier {
        whenAction = block
        return this
    }
    fun then(block: (Any?) -> Unit): Verifier {
        thenAction = block
        return this
    }
    fun run(){
        val result = process<Verifier, Unit>{
            givenAction?.invoke()
            val whenResult = whenAction?.invoke()
            thenAction?.invoke(whenResult)
        }
    }
}

fun test(block: Verifier.() -> Unit){
    val verifier = Verifier
    verifier.block()
    verifier.run()
}
