package demo.domain.pie.dsl.forest

import com.example.demo.domain.pie.dsl.forest.SergeyStruct
import com.example.demo.domain.pie.dsl.forest.Struct
import com.example.demo.domain.pie.dsl.forest.struct
import com.example.demo.domain.pie.dsl.forest.zontainer
import org.junit.jupiter.api.Test
import java.util.HashMap

class ForestRunner {
    @Test
    fun testZontainer() {
        val sergey = SergeyStruct()

        zontainer {
            sergey.setChildren("field1", 1)
            sergey.setChildren("field2", 2)
        }

        val v: HashMap<String, Any> = sergey.getChildren();
        val intV = v.get("field2")
        println(intV)

        zontainer(actionMethod = fun SergeyStruct.() {
            sergey.setChildren("name", "Vasya")
            sergey.setChildren("germanName", "Otto")
        })

        println(sergey.getChildren().get("name"))
    }

    @Test
    fun test() {
        val struct =
            struct {
                +{ "field1" to 1 }
                +{ "field2" to arrayOf(1, 2, 3) }
                +{
                    "field3" to struct {
                        +{ "field1.1" to 11 }
                    }
                }
            }

        val value = struct["field1"] // 1
        println(struct["field1"]) // 1
        println(struct["field2"]) // [1, 2, 3]
        println(struct["field3"]) // inner struct

        val struct2 = struct(
            "field1" to 1,
            "field2" to 2,
            "field3" to struct(
                "field1.1" to 11
            )
        )

        val struct3: Struct = struct {
            this.s("field1" to 1)
            s("field2" to arrayOf(1, 2, 3))
            s("field3" to struct {
                s("field3.1" to 31)
            })
        }

        val v = struct3.get("field3") as Struct
        println(v.getChildren().get("field3.1"))

        val struct4: SergeyStruct = zontainer {
            setChildren("field1", 1)
            +{
                "field2" to zontainer {
                    +{ "field2.1" to 21 }
                }
            }
            +{ "field3" to 3 }
        }

        println(struct4.getChildren())
    }
}
