// 修改编译后生成的 Java 文件的类名
@file:JvmName("Util")

package _03.util

/**
 * Created by dysania on 19/10/2017.
 */

// 3.2 声明带默认参数值的 joinToString()
fun <T> joinToString(collection: Collection<T>, separator: String = ", ", prefix: String = "", suffix: String = ""): String {
    val result = StringBuffer(prefix)

    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }

    result.append(suffix)
    return result.toString()
}


// 3.4 为 Collection<T> 声明一个扩展函数
fun <T> Collection<T>.joinToStringFinal(separator: String = ", ", prefix: String = "", suffix: String = ""): String {
    val result = StringBuffer(prefix)

    for ((index, element) in this.withIndex()) {
        if (index > 0) {
            result.append(separator)
        }
        result.append(element)
    }

    result.append(suffix)
    return result.toString()
}

// 3.4 固定类型的扩展函数
fun Collection<String>.join(separator: String = ", ", prefix: String = "", suffix: String = "") = joinToStringFinal(separator, prefix, suffix)