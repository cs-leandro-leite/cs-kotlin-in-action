package ch4

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class InterfaceTest {

    @Test
    fun `Retorna String implementando e sobrescrevendo metodo click de Clickable`() {
        val button = Button()

        assertEquals("I was clicked!", button.click())
    }

    @Test
    fun `Retorna String chamando o metodo padrao showOff de Clickable`() {
        val button = Button()

        assertEquals("I'm clickable!", button.showOff())
    }

    @Test
    fun `Retorna String chamando o metodo pai showOff de Focusable implementando Clickable e Focusable`() {
        val view = View()

        assertEquals("I'm focusable!", view.showOff())
    }

    @Test
    fun `Implementar uma interface com propriedade abstrata`(){
        val user = SubscribingUser("lcleite@gmail.com")

        assertEquals("lcleite", user.nickname)
    }
}

interface Clickable {
    fun click(): String
    fun showOff(): String = "I'm clickable!"
}

class Button : Clickable {
    //using the override modifier is mandatory in Kotlin
    override fun click(): String = "I was clicked!"
}

interface Focusable {
    fun setFocus(b: Boolean): String = "I ${if (b) "got" else "lost"} focus."
    fun showOff(): String = "I'm focusable!"
}

class View : Clickable, Focusable{
    override fun click(): String {
        return "I was clicked!"
    }

    override fun showOff(): String {
        return super<Focusable>.showOff()
    }

}

/*** 4.2.3 ***/

interface AbstractUser {
    val nickname: String
}

class PrivateUser(override val nickname: String) : AbstractUser

class SubscribingUser(val email: String) : AbstractUser {
    override val nickname: String
        get() = email.substringBefore('@')
}