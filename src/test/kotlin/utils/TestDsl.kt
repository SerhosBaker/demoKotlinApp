package utils

import demo.model.IntegerWrap

class TestDsl {
    fun concatenateStrings(action: StringBuilder.() -> Unit): String {
        val sb = StringBuilder()
        sb.action()
        return sb.toString()
    }

    fun sumInts(action: IntegerWrap.() -> Unit): Int { // расширяем класс IntegerWrap. Но принимаем методы лишь заданной сигнатуры
        val id = IntegerWrap(0)
        id.action()
        return id.getValue()
    }
}
