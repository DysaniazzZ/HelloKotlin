package _03

import _03.util.*
import java.lang.StringBuilder
import _03.lastChar
import _03.lastChar as last     //可以使用 as 关键字来修改导入的类或者函数名称，这样可以避免重名函数

/**
 * Created by dysania on 18/10/2017.
 */

fun main(args: Array<String>) {
    // 3.1 在 Kotlin 中创建集合
    val set = hashSetOf(1, 2, 3)
    val map = hashMapOf(1 to "one", 2 to "two", 3 to "three")
    val list = listOf(1, 2, 3)

    println(set.javaClass)
    println(map.javaClass)
    println(list.javaClass)

    println(list.first())
    println(list.max())

    println(list)
    println(joinToString(list, "; ", "(", ")"))
    println(joinToString(list, separator = "; ", prefix = "(", suffix = ")"))   // 命名参数的使用
    println(joinToString(list, ", ", "", ""))
    println(joinToString(list))
    println(joinToString(list, "; "))
    println(joinToString(list, suffix = "$", prefix = "@"))                     // 使用命名参数时可以任意顺序和只给定需要的参数

    println("Kotlin".last())

    println(list.joinToStringFinal())
    println(list.joinToStringFinal("; "))
    println(list.joinToStringFinal(suffix = "$", prefix = "@"))

    println(listOf("one", "two", "three").join())

    val view: View = Button()
    view.click()                // I'm a button
    view.showOff()              // I'm a view

    println("Kotlin".lastChar)
    val sb = StringBuilder("Kotlin?")
    sb.lastChar = '!'
    println(sb)

    // 展开运算符
    val newList = listOf("args", *args)
    println(newList)

    // 中缀调用
    infix fun Any.to(other: Any) = Pair(this, other)

    // 解构声明
    val (number, name) = 1 to "one"

    // 分割字符串
    var string = "12.345-6.A"
    println(string.split("\\.|-".toRegex()))
    println(string.split(".", "-"))
    println(string.split('.', '-'))     // 也可以指定字符参数

    string = "/User/dysania/kotlin-book/chapter.adoc"
    parsePath(string)
    parsePathWithRegex(string)

    printKotlinLogo()

    val price = """${'$'}99.0"""
    println(price)
}

// 3.9 使用 String 的扩展函数来解析文件路径
fun parsePath(path: String) {
    val directory = path.substringBeforeLast("/")
    val fullName = path.substringAfterLast("/")

    val fileName = fullName.substringBeforeLast(".")
    val extension = fullName.substringAfterLast(".")

    println("Dir: $directory, name: $fileName, ext: $extension")
}

// 3.10 使用正则表达式解析文件路径
fun parsePathWithRegex(path: String) {
    val regex = """(.+)/(.+)\.(.+)""".toRegex()
    val matchResult = regex.matchEntire(path)
    if (matchResult != null) {
        val (directory, fileName, extension) = matchResult.destructured
        println("Dir: $directory, name: $fileName, ext: $extension")
    }
}

fun printKotlinLogo() {
    val kotlinLogo = """.| //
                        .|//
                        .|/ \"""
    println(kotlinLogo.trimMargin("."))
}
