package demo.domain.pie.dsl.forest

import com.example.demo.domain.pie.PieController
import com.example.demo.domain.pie.PieRepository
import com.example.demo.domain.pie.dsl.test
import com.example.demo.domain.pie.dto.PieDto
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.Mockito

import kotlin.test.assertEquals


class PieVerificationTest {

    private var pieRepository: PieRepository = Mockito.mock(PieRepository::class.java)
    private var pieController = PieController(pieRepository)

    @Test
    fun `should add two numbers`() {
        test {
            given {
                println("Given: preparing data")
            }
            whenEx {
                2 + 2
            }
            then { result ->
                assertEquals(4, result)
                println("Then: result is $result")
            }
        }
    }

    @Test
    fun `should return pies`() {
        test {
            given {
                val givenPies = listOf(
                    PieDto(weight = 100, orderedFor = "Sergey"),
                    PieDto(weight = 200, orderedFor = "Sergey")
                )
                Mockito.`when`(pieRepository.findPies("Sergey")).thenReturn(givenPies)
            }
            whenEx {
                pieController.getPies("Sergey")
            }
            then { result ->
                val pies = result as? List<PieDto>
                    ?: throw AssertionError("Result is not List<PieDto>")

                assertEquals(2, pies.size)
                println("Then: result is $pies")
            }
        }
    }
}
