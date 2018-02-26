package ch2

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ClassTest{

    @Test
    fun `Cria uma pessoa com nome imutavel`(){
        val pessoa = Person("Leandro", 27)

//        pessoa.name = "Leonardo" // erro
        pessoa.age = 28 // ok, declarado como var

        assertEquals("Leandro", pessoa.name)
        assertEquals(28, pessoa.age)
    }

}

class Person(val name: String, var age: Int)

/* // Java
public final class Person {
    private final String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public final String getName() {
        return name;
    }

    public final int getAge() {
        return age;
    }

    public final void setAge(int age) {
        this.age = age;
    }
}
*/