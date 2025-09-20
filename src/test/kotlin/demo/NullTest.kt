package demo

import org.junit.jupiter.api.Test

class NullTest {

    @Test
    fun test() {
        actionIfNotNull(null)
    }

    private fun testNull(nullableString: String?) {
        if (nullableString == null) {
            println("Строка равна null")
        } else {
            println("Строка длинной ${nullableString.length}")
        }
    }

    private fun getValue(nullableString: String?) {
        println(nullableString?.length) // здесь если переменная равна null, то будет напечатано null, а не ошибка
        println(nullableString?.length ?: 0) // это elvis оператор. Позволяет задать значение, если выражение слева равно null

    }
    private fun getValueUnhealthy(nullableString: String?) {
        println(nullableString!!.length) // здесь если переменная равна null, то вызовется NPE
    }

    private fun actionIfNotNull(nullableString: String?){
        nullableString?.let {
            println("Имя: $it.length")
        }
    }

    private fun safeCast(){
        val nullableString: Any = "Hello"
        val str: String? = nullableString as? String // если приведение не удается, то возвращается null
        val int: Int? = nullableString as? Int // тут как раз будет null
    }
}
