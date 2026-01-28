package demo.domain.pie.dsl.forest

import com.example.demo.domain.pie.PieController
import com.example.demo.domain.pie.PieRepository
import com.example.demo.domain.pie.dsl.test
import com.example.demo.domain.pie.dto.PieDto
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*

import kotlin.test.assertEquals


class PieVerificationTest {

//    private var pieRepository: PieRepository = mock(PieRepository::class.java)
//    private var pieController = PieController(pieRepository)

    @Test
    fun `should add two numbers`() {
        test {
            given {
                println("Given: preparing data")
            }
            whenEx {
                2 + 2
            }
            then {
                result {
                    isEqualTo(4)
                }
            }
        }
    }

//    @Test
//    fun `should return pies`() {
//        test {
//            given {
//                val givenPies = listOf(
//                    PieDto(weight = 100, orderedFor = "Sergey"),
//                    PieDto(weight = 200, orderedFor = "Sergey")
//                )
//                `when`(pieRepository.findPies("Sergey")).thenReturn(givenPies)
//            }
//            whenEx {
//                pieController.getPies("Sergey")
//            }
//            then {
//                result {
//                    size {
//                        assertEquals(2, it)
//                    }
//                }
//            }
//        }
//    }
}
