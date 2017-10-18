package _02

import java.util.*

/**
 * Created by dysania on 17/10/2017.
 */

fun main(args: Array<String>) {
    // 使用 when 实现 Fizz-Buzz 游戏
    for (i in 1..100) {
        println(fizzBuzz(i))
    }

    println("-------------------------------------")

    // 迭代带步长的区间
    for (i in 100 downTo 1 step 2) {
        println(fizzBuzz(i))
    }

    println("-------------------------------------")

    // 初始化并迭代 map
    val binaryReps = TreeMap<Char, String>()

    for (c in 'A'..'F') {
        val binary = Integer.toBinaryString(c.toInt())
        binaryReps[c] = binary
    }

    for ((letter, binary) in binaryReps) {
        println("$letter = $binary")
    }

    println("-------------------------------------")

    // 在迭代集合的同时追踪当前项的下标
    val list = arrayListOf("10", "11", "1001")
    for ((index, element) in list.withIndex()) {
        println("$index: $element")
    }

    println("-------------------------------------")

    println(isLetter('q'))
    println(isNotDigit('1'))

    println("-------------------------------------")

    println(recognize('￥'))

    println("-------------------------------------")

    println("Kotlin" in "Java".."Scala")            // true：结果和 "Java" <= "Kotlin" && "Kotlin" <= "Scala" 一样
    println("Kotlin" in setOf("Java", "Scala"))     // false：这个集合不包含字符串 "Kotlin"
}

fun fizzBuzz(i: Int) =
        when {
            i % 15 == 0 -> "FizzBuzz"
            i % 3 == 0 -> "Fizz"
            i % 5 == 0 -> "Buzz"
            else -> "$i"
        }

// 使用 in 检查区间的成员
fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'

fun isNotDigit(c: Char) = c !in '0'..'9'

// 用 in 检查作为 when 分支
fun recognize(c: Char) =
        when (c) {
            in 'a'..'z' -> "It's a letter."
            in '0'..'9' -> "It's a digit."
            else -> "I don't know."
        }