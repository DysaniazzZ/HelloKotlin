package _02

/**
 * Created by dysania on 16/10/2017.
 */

// 表达式类层次结构
interface Expr

class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

// 使用 if 层叠对表达式求值
fun evalWithJavaStyle(e: Expr): Int {
    if (e is Num) {
        val n = e as Num
        return n.value
    }
    if (e is Sum) {
        return evalWithJavaStyle(e.left) + evalWithJavaStyle(e.right)
    }
    throw IllegalArgumentException("Unknown Exception")
}

// 使用有返回值的 if 表达式
fun evalWithKotlinStyle1(e: Expr): Int =
        if (e is Num) {
            e.value
        } else if (e is Sum) {
            evalWithKotlinStyle1(e.left) + evalWithKotlinStyle1(e.right)
        } else {
            throw IllegalArgumentException("Unknown Exception")
        }

// 使用 when 代替 if 层叠
fun evalWithKotlinStyle2(e: Expr): Int =
        when (e) {
            is Num -> e.value
            is Sum -> evalWithKotlinStyle2(e.left) + evalWithKotlinStyle2(e.right)
            else -> throw IllegalArgumentException("Unknown Exception")
        }

// 使用分支中含有混合操作的 when （代码中最后的表达式就是结果）
fun evalWithLogging(e: Expr): Int =
        when (e) {
            is Num -> {
                println("num: ${e.value}")
                e.value
            }
            is Sum -> {
                val left = evalWithLogging(e.left)
                val right = evalWithLogging(e.right)
                println("sum: $left + $right")
                left + right
            }
            else -> throw IllegalArgumentException("Unknown Exception")
        }