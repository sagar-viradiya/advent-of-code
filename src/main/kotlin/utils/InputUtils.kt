package utils

import java.util.regex.Pattern

/**
 * Created by sagar on 14/01/18.
 */


private val NEWLINE = Pattern.compile("\\r?\\n")
private val WHITESPACE = Pattern.compile("\\s+")

fun String.splitAtNewLines() : List<String> {
    return trim().split(NEWLINE)
}

fun String.splitAtWhiteSpace() : List<String> {
    return trim().split(WHITESPACE)
}

fun List<String>.toIntList() : List<Int> {
    return map { it.trim().toInt() }
}

fun String.toIntList() : List<Int> {
    return trim().map { it.toString().toInt() }
}