import utils.splitAtNewLines

object Day01  {
    fun day01Part01(input: String): Int {
        return input.splitAtNewLines().sumOf {
            val firstDigit = it.first(Char::isDigit)
            val lastDigit = it.reversed().first(Char::isDigit)
            "$firstDigit$lastDigit".toInt()
        }
    }

    fun day01Part02(input: String): Int {
        val numbers = buildMap {
            listOf(
                1 to "one",
                2 to "two",
                3 to "three",
                4 to "four",
                5 to "five",
                6 to "six",
                7 to "seven",
                8 to "eight",
                9 to "nine",
            ).forEach { (number, name) ->
                put(number.toString(), number)
                put(name, number)
            }
        }

        return input.lines()
            .map { line ->
                val min = numbers.getValue(line.findAnyOf(numbers.keys)!!.second)
                val max = numbers.getValue(line.findLastAnyOf(numbers.keys)!!.second)
                "$min$max".toInt()
            }
            .fold(0, Int::plus)
    }
}
