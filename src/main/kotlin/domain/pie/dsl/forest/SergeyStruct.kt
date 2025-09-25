package com.example.demo.domain.pie.dsl.forest

class SergeyStruct {
    private val children: HashMap<String, Any> = hashMapOf<String, Any>()
    fun setChildren(s: String, value: Any) {
        children[s] = value
    }

    fun getChildren(): HashMap<String, Any> {
        return children
    }

    operator fun (() -> Pair<String, Any>).unaryPlus() {
        val pair = this.invoke()
        children.put(pair.first, pair.second)
    }

}

fun zontainer(actionMethod: SergeyStruct.() -> Unit): SergeyStruct {
    val zontainer = SergeyStruct()
    zontainer.actionMethod()
    return zontainer
}
