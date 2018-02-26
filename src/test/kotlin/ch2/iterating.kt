package ch2

import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.util.*

@RunWith(JUnit4::class)
class IterationTest{

    @Test
    fun `Funcionamento do loop while`(){
        assertEquals(55, loopWhile())
    }

    fun loopWhile(): Int{
        var total = 0
        var i = 1

        while(i <= 10) {
            total += i
            i += 1
        }

        return total
    }

    @Test
    fun `Funcionamento do loop do-while`(){
        assertEquals( 55, loopDoWhile())
    }

    fun loopDoWhile(): Int{
        var total = 0
        var i = 1

        do{
            total += i
            i += 1
        } while(i <= 10)

        return total
    }

    @Test
    fun `Funcionamento do loop for simples`(){
        assertEquals(55, loopSimpleFor())
    }

    fun loopSimpleFor(): Int{
        var total = 0

        for(i in 1..10){
            total += i
        }

        return total
    }

    @Test
    fun `Funcionamento do loop for com downTo`(){
        assertEquals(55, loopDownToFor())
    }

    fun loopDownToFor(): Int{
        var total = 0

        for(i in 10 downTo 1 step 1){
            total += i
        }

        return total
    }

    @Test
    fun `Funcionamento do loop for simples com until`(){
        assertEquals(10, loopSimpleForUntil())
    }

    fun loopSimpleForUntil(): Int{
        var total = 0

        for(i in 1 until 5){ // for(i in 1..4)
            total += i
        }

        return total
    }

    @Test
    fun `Iterando em variaveis do tipo Map`(){
        assertEquals("[T, E, S, T]", loopForMap())
    }

    fun loopForMap(): String{
        val chars = ArrayList<Char>()
        val map = TreeMap<Int, Char>()

        map.put(1, 'T')
        map.put(2, 'E')
        map.put(3, 'S')
        map.put(4, 'T')

        for((key, value) in map){
            chars.add(value)
        }

        return chars.toString()
    }

    @Test
    fun `Iterando em variaveis do tipo List com indice`(){
        assertEquals(10, loopForList())
    }

    fun loopForList(): Int{
        var total = 0
        val numbers = arrayListOf(1, 2, 3, 4)

        for((index, element) in numbers.withIndex()){
            total += element
        }

        return total
    }

    @Test
    fun `Usando in para conferir valores em listas e intervalos`(){
        assertTrue(isLetter('q'))
        assertFalse(isLetter('9'))
        assertTrue(isNotDigit('x'))
        assertFalse(isNotDigit('0'))
    }

    fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'
    fun isNotDigit(c: Char) = c !in '0'..'9'

    @Test
    fun `Usando in junto com o comando when`(){
        assertEquals("It's a digit!", recognize('0'))
        assertEquals("It's a letter!", recognize('b'))
    }

    fun recognize(c: Char) = when (c) {
        in '0'..'9' -> "It's a digit!"
        in 'a'..'z', in 'A'..'Z' -> "It's a letter!"
        else -> "I don't know..."
    }

    @Test
    fun `Conferindo intervalos entre strings`(){
        assertTrue("Kotlin" in "Java".."Scala")
    }
}

