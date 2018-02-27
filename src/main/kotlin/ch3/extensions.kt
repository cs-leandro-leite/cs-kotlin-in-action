package ch3

import ch3.joinToString

/*
    When you define an extension function, it doesn’t automatically become available
    across your entire project. Instead, it needs to be imported, just like any other class or function
 */

fun String.getLastChar(): Char = this[this.length - 1]



fun Collection<Any>.join(separator: String = ", ", prefix: String = "", postfix: String = "")
        = joinToString(separator, prefix, postfix)



open class View
class Button : View()

fun View.showOff(): String { return "I'm a view!" }
fun Button.showOff(): String { return "I'm a button!" }



var StringBuilder.lastChar: Char
    get() = this[length - 1]
    set(value: Char) {
        this.setCharAt(length - 1, value)
    }