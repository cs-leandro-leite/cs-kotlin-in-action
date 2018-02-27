package ch3

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

import ch3.getLastChar
import ch3.join
import ch3.View
import ch3.Button
import ch3.showOff
import ch3.lastChar

@RunWith(JUnit4::class)
class ExtensionTest {

    /*
        Conceptually, an extension function is a simple thing:
        it’s a function that can be called as a member of a class but is defined outside of it
     */

    @Test
    fun `Utiliza extension function`() {
        assertEquals('n', "Kotlin".getLastChar())
    }

    @Test
    fun `Utiliza funcoes utils como extension function`(){
        val list = arrayListOf(1, 2, 3)

        assertEquals("1, 2, 3", list.join())
        assertEquals("[1, 2, 3]", list.join(prefix = "[", postfix = "]"))
    }

    @Test
    fun `Nao eh possivel sobrescrever extension functions`(){
        val view: View = Button()

        assertEquals("I'm a view!", view.showOff())
    }

    @Test
    fun `Utiliza get e set de uma extension property`(){
        val language = StringBuilder("Kotlin!")

        assertEquals('!', language.lastChar)

        language.lastChar = '?'

        assertEquals('?', language.lastChar)
    }
}

