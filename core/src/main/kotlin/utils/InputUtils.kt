package utils

import java.util.regex.Pattern

/**
 * Created by sagar on 14/01/18.
 */


private val NEWLINE = Pattern.compile("\\r?\\n")
private val NEW_EMPTY_LINE = Pattern.compile("\\n\\n")
private val WHITESPACE = Pattern.compile("\\s+")
private val COMMA = Pattern.compile(",\\s*")
private val COLON = Pattern.compile(":\\s*")
private val SEMI_COLON = Pattern.compile(";\\s*")

fun String.splitAtNewLines() : List<String> {
    return trim().split(NEWLINE)
}

fun String.splitAtNewEmptyLines() : List<String> {
    return trim().split(NEW_EMPTY_LINE)
}

fun String.splitAtWhiteSpace() : List<String> {
    return trim().split(WHITESPACE)
}

fun String.splitAtComma(): List<String> {
    return trim().split(COMMA)
}

fun String.splitAtColon(): List<String> {
    return trim().split(COLON)
}

fun String.splitAtSemiColon(): List<String> {
    return trim().split(SEMI_COLON)
}

fun List<String>.toIntList() : List<Int> {
    return map { it.trim().toInt() }
}

fun List<String>.toIntArray() : IntArray {
    val array = IntArray(size)
    forEachIndexed { index, string -> array[index] = string.trim().toInt() }
    return array
}

fun String.toIntList() : List<Int> {
    return trim().map { it.toString().toInt() }
}

infix fun Int.inc(value: Int) = this + value
infix fun Int.dec(value: Int) = this - value

fun Int.toHexString() : String {
    val hex = Integer.toHexString(this)
    return if (hex.length == 1) "0$hex" else hex
}