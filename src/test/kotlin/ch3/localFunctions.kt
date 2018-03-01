package ch3

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class LocalFunctionTest {

    @Test(expected=IllegalArgumentException::class)
    fun `Lanca exception utilizando local function`() {
        val user = User(10, "Leandro", "")

        saveUser(user)
    }

    @Test(expected=IllegalArgumentException::class)
    fun `Lanca exception utilizando local function que acessa parametros externos`() {
        val user = User(10, "Leandro", "")

        saveUserOuter(user)
    }
}

class User(val id: Int, val name: String, val address: String)

fun saveUser(user: User) {
    fun validate(user: User, value: String, fieldName: String) {
        if (value.isEmpty())
            throw IllegalArgumentException(
                    "Can't save user ${user.id}: empty $fieldName")
    }

    validate(user, user.name, "Name")
    validate(user, user.address, "Address")
}

fun saveUserOuter(user: User) {
    fun validate(value: String, fieldName: String) {
        if (value.isEmpty())
            throw IllegalArgumentException(
                    "Can't save user ${user.id}: empty $fieldName")
    }

    validate(user.name, "Name")
    validate(user.address, "Address")
}