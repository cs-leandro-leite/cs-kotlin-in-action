package ch4

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class BackfieldTest {

    @Test
    fun `Printa e seta o backfield da propriedade address da classe Person`() {
        val person = Person("Leandro")

        person.address = "Rio de Janeiro"
        person.address = "São Paulo"

        assertEquals("São Paulo", person.address)
    }
}

class Person(val name: String) {
    var address: String = "unspecified"
        set(value: String) {
            println("""Address was changed for $name: "$field" -> "$value".""".trimIndent())
            field = value
        }
}