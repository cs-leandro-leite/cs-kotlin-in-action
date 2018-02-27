package ch3

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.junit.Assert.assertEquals

import ch3.joinToString
import ch3.LANGUAGE

@RunWith(JUnit4::class)
class NoStaticUtilTest {

    @Test
    fun `Chama funcao normalmente utilizando import`() {
        val list = arrayListOf(1, 2, 3)

        assertEquals("1, 2, 3", joinToString(list))
    }

    @Test
    fun `Utiliza constantes normalmente com import`(){
        assertEquals("Kotlin", LANGUAGE)
    }
}