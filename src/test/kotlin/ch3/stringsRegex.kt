package ch3

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class StringRegexTest {

    @Test
    fun `Quebra strings usando split`() {
        assertTrue(arrayListOf("12", "345", "6", "A") == "12.345-6.A".split(".", "-"))
    }

    @Test
    fun `Quebra path de um arquivo utilizando regex`(){
        val filePath = "/home/user/Pictures/pic.jpg"
        val values = parsePath(filePath)

        assertEquals("/home/user/Pictures", values[0])
        assertEquals("pic", values[1])
        assertEquals("jpg", values[2])
    }

    @Test
    fun `String tripla para declarar strings de forma mais limpa`(){
        val path = """C:\Users\yole\kotlin-book"""

        assertEquals("C:\\Users\\yole\\kotlin-book", path)
    }

    @Test
    fun `String tripla para arte ASCII`(){
        val kotlinLogo = """| //
                           .|//
                           .|/ \"""
        println(kotlinLogo.trimMargin("."))
    }
}

/*
    The regular expression is written in a triple-quoted string. In such a string, you don’t need to escape
    any characters, including the backslash, so you can encode the dot symbol with \. rather than \\
 */
fun parsePath(path: String): List<String> {
    val regex = """(.+)/(.+)\.(.+)""".toRegex()
    val matchResult: MatchResult? = regex.matchEntire(path)

    matchResult?.let {
        return arrayListOf(it.destructured.component1(), it.destructured.component2(), it.destructured.component3())
    }

    return arrayListOf()
}