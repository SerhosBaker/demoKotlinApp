package demo

import org.junit.jupiter.api.Test
import utils.TestContext

class TestActionsTest {
    @Test
    fun `test passing some actions as method input params`() {
        val context = TestContext()

        context.runTest {
            val result = concatenateStrings {
                append("Привет, ") // а вот и вызов и это лямбда. По факту передали готовый вызов класса Stringbuilder, возвращающий SB
                append("мир!")
            }

            println(result) // Вывод: Привет, мир!
        }

        context.runTest {
            val result = sumInts {
                increment(2)
                increment(3)
                increment(4)
                incrementViaReturn(5) // что интересно. Функция sumInts требовала void, но метод с возвращаемым значением Int тоже работает
                incrementOne() // и метод без параметров тоже можно передать в sumInts.
            }

            println("суммирование: $result")
        }
    }
}
