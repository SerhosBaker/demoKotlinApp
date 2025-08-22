package demo.model

class IntegerWrap(private var value: Int) {

    fun increment(param: Int): IntegerWrap {
        value += param
        return this
    }

    fun incrementViaReturn(param: Int): Int {
        value += param
        return value
    }
    fun incrementOne(): IntegerWrap {
        value += 1
        return this
    }

    fun getValue(): Int {
        return value
    }
}
