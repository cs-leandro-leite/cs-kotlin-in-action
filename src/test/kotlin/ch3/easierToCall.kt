package ch3

import junit.framework.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class EasierToCallTest {

    @Test
    fun `Chama a funcao normalmente`() {
        val list = arrayListOf(1, 2, 3)

        assertEquals("1, 2, 3", joinToString(list, ", ", "", ""))
    }

    @Test
    fun `Chama a funcao utilizando valor default para todos os parametros`() {
        val list = arrayListOf(1, 2, 3)

        assertEquals("1, 2, 3", joinToString(list))
    }

    @Test
    fun `Chama a funcao passando apenas alguns parametros`() {
        val list = arrayListOf(1, 2, 3)

        assertEquals("1; 2; 3", joinToString(list, "; "))
    }

    @Test
    fun `Chama a funcao utilizando parametros nomeados`() {
        val list = arrayListOf(1, 2, 3)

        assertEquals("[1; 2; 3]", joinToString(list, separator = "; ", prefix = "[", postfix = "]"))
    }

    @Test
    fun `Chama a funcao utilizando parametros nomeados fora de ordem`() {
        val list = arrayListOf(1, 2, 3)

        assertEquals("[1; 2; 3]", joinToString(list, prefix = "[", separator = "; ", postfix = "]"))
    }

    fun <T> joinToString(collection: Collection<T>,
                         separator: String = ", ", prefix: String = "", postfix: String = ""): String {
        val result = StringBuilder(prefix)

        for ((index, element) in collection.withIndex()) {
            if (index > 0) result.append(separator)
            result.append(element)
        }

        result.append(postfix)

        return result.toString()
    }
}