package ch4

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class DeclaringTest {

    @Test
    fun `Cria um usuario utilizando a classe simples SimpleUser`() {
        val user = SimpleUser("lcleite")

        assertEquals("lcleite", user.nickname)
    }

    @Test
    fun `Cria um usuario utilizando o construtor primario de PrimaryUser`() {
        val user = PrimaryUser("lcleite")

        assertEquals("lcleite", user.nickname)
    }

    @Test
    fun `Cria um usuario padrao utilizando a classe DefaultUser`() {
        val user = DefaultUser()

        assertEquals("user", user.nickname)
    }

    @Test
    fun `Cria um usuario do Twitter utilizando a classe filha TwitterUser`() {
        val user = TwitterUser("lcleite")

        assertEquals("lcleite", user.nickname)
    }
}


// Simple class
class SimpleUser(val nickname: String)

// Primary constructor with one parameter
class PrimaryUser constructor(_nickname: String) {
    val nickname: String

    init { // Initializer block
        nickname = _nickname
    }
}

// Same as above
/*
class User(_nickname: String) {
    val nickname = _nickname
}
 */

class DefaultUser(val nickname: String = "user")

open class User(val nickname: String)
class TwitterUser(nickname: String) : User(nickname) { /*...*/ }

// Don’t declare multiple secondary constructors to overload and provide
// default values for arguments. Instead, specify default values directly
open class Account {
    constructor(user: User) {
// some code
    }
    constructor(user: User, attributes: List<String>) {
// some code
    }
}

class FacebookAccount : Account {
    constructor(user: User)
            : super(user) {
// ...
    }
    constructor(user: User, attributes: List<String>)
            : super(user, attributes) {
// ...
    }
}