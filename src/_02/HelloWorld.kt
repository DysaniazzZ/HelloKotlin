package _02

/**
 * Created by dysania on 09/10/2017.
 */

fun main(args: Array<String>) {
    // Kotlin 的 "Hello World"
    println("Hello World")

    println(max(1, 2))

    // 使用字符串模板
//    val name = if (args.isNotEmpty()) args[0] else "Kotlin"
//    println("Hello $name")
    println("Hello ${if (args.isNotEmpty()) args[0] else "Kotlin"}")

    val person = Person("William", false)
    println(person.name)
    println(person.isMarried)

//    println(Rectangle(10, 10).isSquare)
    val rectangle = createRandomRectangle()
    println("width is ${rectangle.width}\nheight is ${rectangle.height}\nis rectangle? ${rectangle.isSquare}")

    println(Color.BLUE.rgb())
    println(getMnemonic(Color.VIOLET))
    println(getWarmth(Color.ORANGE))
    println(mix(Color.GREEN, Color.RED))
    println(mixOptimized(Color.VIOLET, Color.BLUE))

    println(evalWithJavaStyle(Sum(Sum(Num(1), Num(2)), Num(3))))
    println(evalWithKotlinStyle1(Sum(Sum(Num(1), Num(2)), Num(3))))
    println(evalWithKotlinStyle2(Sum(Sum(Num(1), Num(2)), Num(3))))
    println(evalWithLogging(Sum(Sum(Num(1), Num(2)), Num(3))))
}

//fun max(a: Int, b: Int): Int {
//    return if (a > b) a else b
//}

//fun max(a: Int, b: Int): Int = if (a > b) a else b

fun max(a: Int, b: Int) = if (a > b) a else b