package _02

import _02.Color.*

/**
 * Created by dysania on 16/10/2017.
 */

// 使用 when 来选择正确的枚举值
fun getMnemonic(color: Color) =
        when (color) {
            Color.RED -> "Richard"
            Color.ORANGE -> "Of"
            Color.YELLOW -> "York"
            Color.GREEN -> "Gave"
            Color.BLUE -> "Battle"
            Color.INDIGO -> "In"
            Color.VIOLET -> "Vain"
        }

// 在一个 when 分支上合并多个选项，导入枚举常量后不用限定词就可以访问
fun getWarmth(color: Color) =
        when (color) {
            RED, ORANGE, YELLOW -> "warm"
            GREEN -> "neutral"
            BLUE, INDIGO, VIOLET -> "cold"
        }

// 在 when 分支中使用不同的对象
fun mix(c1: Color, c2: Color) =
        when (setOf(c1, c2)) {
            setOf(Color.RED, Color.GREEN) -> Color.YELLOW
            setOf(Color.RED, Color.YELLOW) -> Color.ORANGE
            setOf(Color.BLUE, Color.VIOLET) -> Color.INDIGO
            else -> throw Exception("Dirty color")
        }

// 不带参数的 when
fun mixOptimized(c1: Color, c2: Color) =
        when {  // 不带参数的 when，不会创建额外的 set 对象，效率更高
            (c1 == Color.RED && c2 == Color.GREEN) || (c1 == Color.GREEN && c2 == Color.RED) -> Color.YELLOW
            (c1 == Color.RED && c2 == Color.YELLOW) || (c1 == Color.YELLOW && c2 == Color.RED) -> Color.ORANGE
            (c1 == Color.BLUE && c2 == Color.VIOLET) || (c1 == Color.VIOLET && c2 == Color.BLUE) -> Color.INDIGO
            else -> throw Exception("Dirty color")
        }