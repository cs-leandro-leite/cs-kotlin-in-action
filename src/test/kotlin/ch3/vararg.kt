package ch3

import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class VarArgTest {

    @Test
    fun `Cria lista utilizando funcao com vararg`() {
        val list = myListOf(1, 2, 3)

        assertTrue(listOf(1, 2, 3) == list)
    }

    fun <T>myListOf(vararg args: T): List<T> {
        val list = ArrayList<T>()

        for(arg in args){
            list.add(arg)
        }

        return list
    }
}

