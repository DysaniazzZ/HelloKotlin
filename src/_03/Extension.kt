package _03

/**
 * Created by dysania on 19/10/2017.
 */

// 3.4 扩展函数
// fun String.lastChar(): Char = this.get(this.length - 1)     // 这里的 String 为接收者类型，this 指示的为接收者对象
fun String.lastChar(): Char = get(length - 1)                  // 接收者对象成员可以不用 this 来访问

// 3.5 重写成员函数
open class View {
    open fun click() = println("I'm a view")
}

class Button : View() {
    override fun click() = println("I'm a button")
}

// 3.6 不能重写扩展函数
// 扩展函数并不是类的一部分，是声明在类之外的。
// 尽管基类和子类可以定义同名扩展函数，但是函数被调用时是由该变量的静态类型所决定的，而不是这个变量的运行时类型。
fun View.showOff() = println("I'm a view")

fun Button.showOff() = println("I'm a button")

// 3.7 声明一个扩展属性
val String.lastChar: Char
    get() = get(length - 1)

// 3.8 声明一个可变的扩展属性
var StringBuilder.lastChar: Char
    get() = get(length - 1)
    set(value: Char) = setCharAt(length - 1, value)