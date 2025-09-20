package utils

class TestContext {
    fun runTest(block: TestDsl.() -> Unit) {
        val dsl = TestDsl()
        block(dsl)
    }
}
