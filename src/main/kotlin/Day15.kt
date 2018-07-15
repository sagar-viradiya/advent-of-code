import kotlin.coroutines.experimental.buildSequence

object Day15 {

    private const val  MULTIPLICATION_FACTOR_A = 16807
    private const val  MULTIPLICATION_FACTOR_B = 48271
    private const val  DIVISION_FACTOR = 2147483647


    fun part1(startA: Long, startB: Long): Int {
        var previousA = startA
        var previousB = startB

        return buildSequence {

            while (true) {
                previousA = (previousA * MULTIPLICATION_FACTOR_A) % DIVISION_FACTOR
                previousB = (previousB * MULTIPLICATION_FACTOR_B) % DIVISION_FACTOR
                yield(Pair(previousA.toShort(), previousB.toShort()))
            }

        }
        .take(40000000)
        .filter { it.first == it.second }
        .count()

    }

}