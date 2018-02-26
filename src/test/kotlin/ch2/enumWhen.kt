package ch2

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

import ch2.Color.* //permite escrever apenas  RED em vez de Color.RED

@RunWith(JUnit4::class)
class EnumWhenTest{

    @Test
    fun `Compara rgb hexadecimal do enum RgbColor`(){
        assertEquals("ff0000", java.lang.Integer.toHexString(RgbColor.RED.rgb()))
    }

    @Test
    fun `Recebe o nome da cor utilizando when como o switch do Java`(){
        assertEquals(getColorName(Color.BLUE), "Blue")
    }

    fun getColorName(color: Color): String{
        when (color) {
            Color.RED -> return "Red"
            Color.ORANGE -> return "Orange"
            Color.YELLOW -> return "Yellow"
            Color.GREEN -> return "Green"
            Color.BLUE -> return "Blue"
            Color.INDIGO -> return "Indigo"
            Color.VIOLET -> return "Violet"
        }

        return "None"
    }

    @Test
    fun `Recebe o nome da cor utilizando when como expressao`(){
        assertEquals("Blue", getColorNameExp(Color.BLUE))
    }

    fun getColorNameExp(color: Color) = when (color) {
        Color.RED -> "Red"
        Color.ORANGE -> "Orange"
        Color.YELLOW -> "Yellow"
        Color.GREEN -> "Green"
        Color.BLUE -> "Blue"
        Color.INDIGO -> "Indigo"
        Color.VIOLET -> "Violet"
        else -> "None"
    }

    @Test
    fun `Combinando opcoes na expressao when`(){
        assertEquals("neutral", getWarmth(Color.GREEN))
    }

    fun getWarmth(color: Color) = when(color) {
        Color.RED, Color.ORANGE, Color.YELLOW -> "warm"
        Color.GREEN -> "neutral"
        Color.BLUE, Color.INDIGO, Color.VIOLET -> "cold"
        else -> "none"
    }

    @Test
    fun `Mistura cores utilizando when com objetos`(){
        assertEquals(GREEN, mix(YELLOW, BLUE))
    }

    /*
        The when construct in Kotlin is more powerful than Java’s switch . Unlike switch ,
        which requires you to use constants (enum constants, strings, or number literals) as
        branch conditions, when allows any objects
     */
    fun mix(c1: Color, c2: Color) =
            when (setOf(c1, c2)) {
                setOf(RED, YELLOW) -> ORANGE
                setOf(YELLOW, BLUE) -> GREEN
                setOf(BLUE, VIOLET) -> INDIGO
                else -> throw Exception("Dirty color")
            }

}

enum class Color {
    RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET
}

enum class RgbColor(val r: Int, val g: Int, val b: Int) {
    RED(255, 0, 0),
    ORANGE(255, 165, 0),
    YELLOW(255, 255, 0),
    GREEN(0, 255, 0),
    BLUE(0, 0, 255),
    INDIGO(75, 0, 130),
    VIOLET(238, 130, 238); //ponto-e-vigula necessario

    fun rgb() = (r * 256 + g) * 256 + b
}