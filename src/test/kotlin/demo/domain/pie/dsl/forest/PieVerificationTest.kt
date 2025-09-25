package demo.domain.pie.dsl.forest

import com.example.demo.domain.pie.PieController
import com.example.demo.domain.pie.PieRepository
import com.example.demo.domain.pie.dsl.test
import com.example.demo.domain.pie.dto.PieDto
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.Mockito

import kotlin.test.assertEquals
import kotlin.test.assertNotNull


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
            then { pies: List<PieDto>? ->
                assertNotNull(pies)
                val size = pies.size
                assertEquals(2, size)
                println("Then: result is $pies")
            }
        }
    }
}
