package utils

import demo.model.IntegerWrapTest

class TestDsl {
    fun concatenateStrings(action: StringBuilder.() -> Unit): String {
        val sb = StringBuilder()
        sb.action()
        return sb.toString()
    }

    fun sumInts(action: IntegerWrapTest.() -> Unit): Int { // расширяем класс IntegerWrap. Но принимаем методы лишь заданной сигнатуры
        val id = IntegerWrapTest(0)
        id.action()
        return id.getValue()
    }
}
