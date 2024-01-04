object Day15 {

    private const val  MULTIPLICATION_FACTOR_A = 16807
    private const val  MULTIPLICATION_FACTOR_B = 48271
    private const val  DIVISION_FACTOR = 2147483647


    fun part1(startA: Long, startB: Long): Int {

        return getGenerator(startA, MULTIPLICATION_FACTOR_A)
                .zip(getGenerator(startB, MULTIPLICATION_FACTOR_B))
                .take(40000000)
                .filter { it.first == it.second }
                .count()
    }

    fun part2(startA: Long, startB: Long): Int {

        return getGenerator(startA, MULTIPLICATION_FACTOR_A, 4)
                .zip(getGenerator(startB, MULTIPLICATION_FACTOR_B, 8))
                .take(5000000)
                .filter { it.first == it.second }
                .count()
    }

    private fun getGenerator(start: Long, multiplicationFactor: Int, multiple: Int = 1): Sequence<Short> {

        return sequence {
            var previous = start
            while (true) {
                previous = (previous * multiplicationFactor) % DIVISION_FACTOR
                if (multiple == 1 || previous % multiple == 0L) {
                    yield(previous.toShort())
                }
            }
        }
    }

}