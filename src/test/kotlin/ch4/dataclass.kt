package ch4

import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class DataClassTest {

    @Test
    fun `Retorna false na comparacao de duas instancias de uma classe comum`() {
        val client1 = Client("Leandro","20098-000")
        val client2 = Client("Leandro","20098-000")

        assertFalse(client1 == client2)
    }

    @Test
    fun `Retorna true na comparacao de duas instancias de um data class`() {
        val client1 = DataClient("Leandro","20098-000")
        val client2 = DataClient("Leandro","20098-000")

        assertTrue(client1 == client2)
    }

    @Test
    fun `Testa o metodo copy`(){
        val client = DataClient("Leandro","20098-000")
        val clientCopy = client.copy(name = "Leonardo")

        assertEquals("Leonardo", clientCopy.name)
        assertEquals("20098-000", clientCopy.postalCode)
    }
}

class Client(val name: String, val postalCode: String)

// If you add the modifier data to your class, the necessary methods are automatically generated for you.
data class DataClient(val name: String, val postalCode: String)
/*
    Now you have a class that overrides all the standard Java methods:
    -> equals() for comparing instances
    -> hashCode() for using them as keys in hash-based containers such as HashMap
    -> toString() for generating string representations showing all the fields in declaration order

    And a copy method like this:
    fun copy(name: String = this.name, postalCode: Int = this.postalCode) = DataClient(name, postalCode)
 */