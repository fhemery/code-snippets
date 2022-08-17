package katas.fibonacci

import org.junit.jupiter.api.Test

internal class NaiveFibonacciTest {
    @Test
    fun `should grant 100% coverage`() {
        val fibo = NaiveFibonacci()
        fibo.compute(1)
        fibo.compute(2)
    }
}