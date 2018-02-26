package ch2

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class FunctionTest{

    @Test
    fun `Chamada e retorno de funcao`(){
        assertEquals(4, soma(2,2))
    }


    fun soma(a: Int, b: Int): Int{
        return a + b
    }

    @Test
    fun `If como expressao`(){
        assertEquals(10, maior(1,10))
    }

    fun maior(a: Int, b: Int): Int {
        return if (a > b) a else b
    }

    @Test
    fun `If como expressao #2`(){
        assertEquals(1, menor(1,10))
    }

    fun menor(a: Int, b: Int): Int = if (a < b) a else b

    @Test
    fun `Variavel declarada fora do escopo da classe`(){
        assertEquals(20, variavelForaDaClasse)
    }
}

val variavelForaDaClasse = 20
