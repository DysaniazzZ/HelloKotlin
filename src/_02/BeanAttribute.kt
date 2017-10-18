// 把类和函数的声明放在包中
package _02

import java.util.*

/**
 * Created by dysania on 09/10/2017.
 */

// 在类中声明可变属性
class Person(
        val name: String,
        var isMarried: Boolean
)

class Rectangle(val width: Int, val height: Int) {
//    val isSquare: Boolean
//        get() {
//            return width == height
//        }
    val isSquare: Boolean
        get() = width == height
}

// 自定义访问器
fun createRandomRectangle(): Rectangle {
    val random = Random()
    return Rectangle(random.nextInt(), random.nextInt())
}
