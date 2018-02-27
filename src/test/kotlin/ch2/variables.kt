package ch2

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class VariableTest{

    @Test
    fun `Omitir ou nao o tipo da variavel na declaracao`(){
        val teste: String = "Teste"
//        val teste = "Teste" // também funciona

        assertEquals("Teste", teste)
    }

    @Test
    fun `Explicitar o tipo se a variavel nao possui inicializador`(){
//        val numero // erro
        val numero: Int

        numero = 17

        assertEquals(17, numero)
    }

    @Test
    fun `Use val para variaveis com referencias imutaveis`(){
        val numero = 30

//        numero = 15 // erro

        assertEquals(30, numero)
    }

    @Test
    fun `Use var para variaveis com referencias mutaveis`(){
        var numero = 30

        numero = 15

        assertEquals(15, numero)
    }

    @Test
    fun `Variaveis val e objetos`(){
        /*
            Note that, even though a val reference is itself immutable and can’t be changed, the
            object that it points to may be mutable.
         */
        val linguagens = arrayListOf("Java")

        linguagens.add("Kotlin")

        assertTrue(arrayListOf("Java", "Kotlin") == linguagens)
    }
}