package katas.fibonacci

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class FibonacciTests {
    lateinit var fibonacci: Fibonacci

    @BeforeEach
    fun setup() {
        fibonacci = Fibonacci()
    }

    @Test
    fun `should return 1 for input 0`() {
        assertEquals(1, fibonacci.getValue(0))
    }

    @Test
    fun `should return 1 for input 1`() {
        assertEquals(1, fibonacci.getValue(1))
    }

    @Test
    fun `should return 2 for input 2`() {
        assertEquals(2, fibonacci.getValue(2))
    }

    @Test
    fun `should return 3 for input 3`() {
        assertEquals(3, fibonacci.getValue(3))
    }

    @Test
    fun `should return 5 for input 4`() {
        assertEquals(5, fibonacci.getValue(4))
    }

    @Test
    fun `should return something for input 800`() {
        assertEquals(1089953762, fibonacci.getValue(800))
    }
}