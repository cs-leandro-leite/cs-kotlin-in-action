package ch2

import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class CustomAccessorTest{

    @Test
    fun `Verifica se o retangulo eh um quadrado utilizando um custom accessor`(){
        val retangulo = Rectangle(20, 20)

        assertTrue(retangulo.isSquare)
    }
}

class Rectangle(val height: Int, val width: Int) {
    val isSquare: Boolean
        get() {
            return height == width
        }
}