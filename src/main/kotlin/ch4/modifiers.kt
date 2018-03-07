package ch4

import java.io.Serializable

/*** 4.1.1 & 4.1.2 ***/

// This class is open: others can inherit from it.
open class RichButton : Clickable {

    // This function is final: you can’t override it in a subclass.
    fun disable() {}

    // This function is open: you may override it in a subclass.
    open fun animate() {}

    // This function overrides an open function and is open as well.
    override fun click() {}

    // Modifier “final” isn’t redundant here because “override” without “final” implies being open.
    final override fun showOff(){}
}

// If you omit a modifier, the declaration becomes public.
interface Clickable {
    fun click()
    fun showOff()
}

abstract class Animated {
    // This function is abstract: it doesn’t have an implementation and must be overridden in subclasses.
    abstract fun animate()
}

/*** 4.1.3 ***/

internal open class TalkativeButton : Clickable {
    override fun click() = println("Click!")
    override fun showOff() = println("I'm a button!")

    private fun yell() = println("Hey!")
    protected fun whisper() = println("Let's talk!")
}

/*
// Error: “public” member exposes its “internal” receiver type TalkativeButton
fun TalkativeButton.giveSpeech() {
    yell() //Error: cannot access “yell”: it is “private” in “TalkativeButton”
    whisper() //Error: cannot access “whisper”: it is “protected” in “TalkativeButton”
}
*/

/*** 4.1.4 ***/

interface State: Serializable

interface View {
    fun getCurrentState(): State
    fun restoreState(state: State) {}
}

class Button : View {
    override fun getCurrentState(): State = ButtonState()
    override fun restoreState(state: State) { /*...*/ }

    // A nested class in Kotlin with no explicit modifiers is the same as a static nested class in Java
    class ButtonState : State { /*...*/ }
}

// The syntax to reference an instance of an outer class in Kotlin also differs from Java.
// You write this@Outer to access the Outer class from the Inner class:
class Outer {
    inner class Inner {
        fun getOuterReference(): Outer = this@Outer
    }
}

/*** 4.1.5 ***/

//    Mark a base class as sealed and list all the possible subclasses as nested classes.
sealed class Expr {
    class Num(val value: Int) : Expr()
    class Sum(val left: Expr, val right: Expr) : Expr()
//    class Sub(val left: Expr, val right: Expr) : Expr()
}

// When you use when with sealed classes and add a new subclass, the when expression
// returning a value fails to compile, which points you to the code that must be changed
fun eval(e: Expr): Int =
        when (e) {
            is Expr.Num -> e.value
            is Expr.Sum -> eval(e.right) + eval(e.left)
//            is Expr.Sub -> eval(e.right) - eval(e.left)
        }

/*** 4.2.5 ***/

// The accessor’s visibility by default is the same as the property’s. But you can change
// this if you need to, by putting a visibility modifier before the get or set keyword.

class LengthCounter {
    var counter: Int = 0
        private set // You can’t change this property outside of the class.

    fun addWord(word: String) {
        counter += word.length
    }
}
