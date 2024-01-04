package utils

import kotlin.math.absoluteValue

operator fun Triple<Long, Long, Long>.plus(triple: Triple<Long, Long, Long>): Triple<Long, Long, Long> {
    return Triple(first + triple.first, second + triple.second, third + triple.third)
}

fun Triple<Long, Long, Long>.distance(): Long {
    return first.absoluteValue + second.absoluteValue + third.absoluteValue
}