package ch3

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class InfixTest {

    /*
        Infix calls can be used with regular methods and extension functions that have one
        required parameter. To allow a function to be called using the infix notation, you
        need to mark it with the infix modifier.

        1.to("one") == 1 to "one"
     */

    @Test
    fun `Compara maneiras de chamar uma funcao infix`(){
        assertEquals(1.to("one"), 1 to "one")
    }

    @Test
    fun `Cria um Pair atraves da funcao infix com`() {
        val (x, y) = 1 com 10

        assertEquals(1, x)
        assertEquals(10, y)
    }

    @Test
    fun `Cria um Map utlizando um mapOf com infix proprio`(){
        val map = myMapOf(1 com "one", 2 com "two")

        assertTrue(mapOf(1 to "one", 2 to "two") == map)
    }
}

infix fun Any.com(other: Any) = Pair(this, other)

fun <K, V> myMapOf(vararg args: Pair<K, V>): Map<K, V> {
    val map = HashMap<K, V>()

    for(arg in args){
        map.put(arg.first, arg.second)
    }

    return map
}