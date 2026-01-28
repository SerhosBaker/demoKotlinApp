package demo.domain.pie.dsl.forest

import com.example.demo.domain.pie.PieController
import com.example.demo.domain.pie.PieRepository
import com.example.demo.domain.pie.dsl.test
import com.example.demo.domain.pie.dto.PieDto
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*


class PieVerificationTest {

    private var pieRepository: PieRepository = mock(PieRepository::class.java)
    private var pieController = PieController(pieRepository)

    @Test
    fun `look then result isEqualTo`() {
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

    @Test
    fun `look then result size isEqualTo`() {
        test {
            given {
                val givenPies = listOf(
                    PieDto(weight = 100, orderedFor = "Sergey"),
                    PieDto(weight = 200, orderedFor = "Sergey")
                )
                `when`(pieRepository.findPies("Sergey")).thenReturn(givenPies)
            }
            whenEx {
                pieController.getPies("Sergey")
            }
            then {
                result {
                    size {
                        isEqualTo(2)
                    }
                }
            }
        }
    }
}
