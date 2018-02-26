package ch2

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class SmartCastTest{
    /*
     In Kotlin, the compiler does this job for
     you. If you check the variable for a certain type, you don’t need to cast it afterward;
     you can use it as having the type you checked for. In effect, the compiler performs the
     cast for you, and we call it a smart cast.
  */

    @Test
    fun `Verifica o funcionamento da funcao eval`(){
        assertEquals(7, eval(Sum(Sum(Num(1), Num(2)), Num (4))))
    }

    @Test
    fun `Mostra o funcionamento do smart cast`(){
        val e: Expr = Num(10)

//        e.value = 20 // erro

        if(e is Num)
            assertEquals(10, e.value)
    }

    @Test
    fun `When utilizando smart cast`(){
        assertEquals(10, evalWithWhen(Sum(Sum(Num(4), Num(2)), Num (4))))
    }

    fun evalWithWhen(e: Expr): Int = when(e) {
        is Num -> e.value
        is Sum -> eval(e.right) + eval(e.left)
        else -> throw IllegalArgumentException("Unknown expression")
    }
}

interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

fun eval(e: Expr): Int {
    if (e is Num) {
        return e.value
    }
    if (e is Sum) {
        return eval(e.right) + eval(e.left)
    }
    throw IllegalArgumentException("Unknown expression")
}
