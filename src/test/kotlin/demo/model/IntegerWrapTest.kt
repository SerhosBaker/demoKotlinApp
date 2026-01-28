package demo.model

class IntegerWrapTest(private var value: Int) {

    fun increment(param: Int): IntegerWrapTest {
        value += param
        return this
    }

    fun incrementViaReturn(param: Int): Int {
        value += param
        return value
    }
    fun incrementOne(): IntegerWrapTest {
        value += 1
        return this
    }

    fun getValue(): Int {
        return value
    }
}
