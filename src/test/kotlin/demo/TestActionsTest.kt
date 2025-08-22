package demo

import org.junit.jupiter.api.Test
import utils.TestContext

class TestActionsTest {
    @Test
    fun test() {
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
                incrementViaReturn(5) // что интересно. Функция sumInt требовала void, но метод с возвращаемым значением тоже работает
                incrementOne() // и метод без параметров тоже работает. На этом моменте я перестал что-либо понимать
            }

            println("суммирование: $result")
        }
    }
}
