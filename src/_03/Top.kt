package _03

/**
 * Created by dysania on 19/10/2017.
 */

// 3.3 顶层属性
var opCount = 0
const val UNIX_LINE_SEPARATOR = "\n"    // 相当于 Java 中的 public static final

// 3.3 顶层函数
fun performOperation() {
    println("Operation perform ${opCount++} times")
}