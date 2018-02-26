package ch2

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class StringTemplateTest{

    @Test
    fun `Exemplo basico de string template`(){
        val world = "World"
        val helloWorld = "Hello ${world}!"
//        val helloWorld = "Hello $world!" // nesse caso, {} é opcional

        assertEquals("Hello World!", helloWorld)
    }

    @Test
    fun `Exemplo de string template utilizando expressao`(){
        val a = 10
        val b = 5
        val comparacao = "$a é ${if (a > b) "maior" else "menor"} que $b"

        assertEquals("10 é maior que 5", comparacao)
    }
}