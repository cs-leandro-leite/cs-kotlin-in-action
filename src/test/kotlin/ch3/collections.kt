package ch3

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class CollectionTest {

    /*
        Kotlin uses the standard Java collection classes
     */

    @Test
    fun `Cria e inicializa um set`() {
        val set = hashSetOf(1, 7, 53)
        val otherSet = HashSet<Int>()
        otherSet.add(1)
        otherSet.add(7)
        otherSet.add(53)

        assertTrue(set == otherSet)
    }

    @Test
    fun `Cria e inicializa um list`() {
        val list = arrayListOf(1, 7, 53)
        val otherList = ArrayList<Int>()
        otherList.add(1)
        otherList.add(7)
        otherList.add(53)

        assertTrue(list == otherList)
    }

    @Test
    fun `Cria e inicializa um map`() {
        val map = hashMapOf(1 to "one", 7 to "seven", 53 to "fifty-three")
        val otherMap = HashMap<Int, String>()
        otherMap.put(1, "one")
        otherMap.put(7, "seven")
        otherMap.put(53, "fifty-three")

        assertTrue(map == otherMap)
    }

    @Test
    fun `Retorna facilmente o maior elemento de uma collection`(){
        val list = arrayListOf(1, 7, 53)
        val set = hashSetOf(1, 8, 64)
        val map = hashMapOf(1 to "one", 7 to "seven", 53 to "fifty-three")

        assertEquals(53, list.max())
        assertEquals(53, map.maxBy { it.key }?.key)
        assertEquals("seven", map.maxBy { it.value }?.value) //ordem alfabetica
        assertEquals(64, set.max())

        /*
            Obs.:
            val maxBy: Map.Entry<Int, String>? = map.maxBy { it.key }
            maxBy?.key
         */
    }
}