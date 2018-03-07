package ch4

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class DelegationUsingByTest {

    @Test
    fun `Utiliza metodos delegados e nao delegados`() {
        val set = CountingSet<Int>()

        set.add(1)
        set.add(2)
        set.add(3)

        assertTrue(set.objectsAdded == 3)

        set.clear()

        assertTrue(set.size == 0)
        assertFalse(set.objectsAdded == 0)
    }
}


// Delegates the MutableCollection implementation to innerSet
class CountingSet<T>(val innerSet: MutableCollection<T> = HashSet<T>()) : MutableCollection<T> by innerSet {
    var objectsAdded = 0


    // Methos above do not delegate, they provide a different implementation
    override fun add(element: T): Boolean {
        objectsAdded++
        return innerSet.add(element)
    }

    override fun addAll(elements: Collection<T>): Boolean {
        objectsAdded += elements.size
        return innerSet.addAll(elements)
    }
}