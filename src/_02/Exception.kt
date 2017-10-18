package _02

import java.io.BufferedReader
import java.io.StringReader

/**
 * Created by dysania on 17/10/2017.
 */

fun main(args: Array<String>) {
//    val percentage = -1
//    if (percentage !in 0..100) {
//        throw IllegalArgumentException("A percentage value must be between 0 and 100: $percentage")
//    }

//    throwException(-11)

    val reader = BufferedReader(StringReader("not a number"))
//    println(readNumber(reader))
    readNumber(reader)
}

// Kotlin 中的异常
fun throwException(number: Int) =
        if (number in 1..100)
            number
        else
            throw IllegalArgumentException("A percentage value must be between 0 and 100: $number")

// 像 Java 中一样使用 try
//fun readNumber(reader: BufferedReader): Int? {
//    try {
//        val line = reader.readLine()
//        return Integer.parseInt(line)
//    } catch (e: NumberFormatException) {
//        return null
//    } finally {
//        reader.close()
//    }
//}

// 把 try 当做表达式使用
fun readNumber(reader: BufferedReader) {
    val number = try {
        Integer.parseInt(reader.readLine())
    } catch (e: NumberFormatException) {
//        return
        null
    }
    println(number)
}
