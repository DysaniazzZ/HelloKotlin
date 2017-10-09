package _01

/**
 * Created by dysania on 09/10/2017.
 */

data class Person(val name: String, val age: Int? = null)

fun main(args: Array<String>) {
    val persons = listOf(Person("Ace"), Person("Luffy", 17))

    val oldest = persons.maxBy { it.age ?: 0 }
    println("The oldest is: $oldest")
}
