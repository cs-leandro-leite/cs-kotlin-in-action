package ch2

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4


@RunWith(JUnit4::class)
class ExceptionTest{
    /*
        Kotlin doesn’t differentiate between checked and unchecked exceptions.
        You don’t specify the exceptions thrown by a function, and you may or may not handle any exceptions
     */

    @Test(expected = IllegalArgumentException::class)
    fun `Lanca uma excecao para uma porcentagem invalida`(){
        checkPercentage(-10)
    }

    fun checkPercentage(value: Int): Int{
        if (value !in 0..100)
            throw IllegalArgumentException("A percentage value must be between 0 and 100!")

        return value
    }

    @Test()
    fun `Excecao como parte de outras expressoes`(){
        assertEquals(10, checkPercentageExpression(10))
    }

    fun checkPercentageExpression(value: Int): Int{
        val percentage =
            if (value in 0..100) value
            else throw IllegalArgumentException("A percentage value must be between 0 and 100!")

        return percentage
    }

    @Test
    fun `Divisao utilizando try-catch`(){
        try{
            divideWithException(10, 0)
        }
        catch (e: IllegalArgumentException){
            print(e.message)
        }
        finally {
            assertEquals(5, divideWithException(10, 2))
        }
    }

    fun divideWithException(a: Int, b: Int): Int{
        if (b == 0)
            throw IllegalArgumentException("Dividing by zero!")

        return a / b
    }

    /*
        If the execution of a try code block behaves normally, the last expression in the block is the result.
        If an exception is caught, the last expression in a corresponding catch block is the result.
     */
    @Test
    fun `Usando try-catch como expressao`(){
        val resultado = try{
            divideWithException(20, 2)
        } catch (e: IllegalArgumentException){
            return
        }

        assertEquals(10, resultado)
    }
}