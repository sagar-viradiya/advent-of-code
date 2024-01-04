import utils.splitAtNewLines

object Day13 {

    fun part1(input: String) : Int {

        return parseInput(input).entries.sumBy { (depth, range) ->
            if (depth % ((range - 1) * 2) == 0) depth * range else 0
        }

    }

    fun part2(input: String) : Int {

        val fireWallMap = parseInput(input)

        return generateSequence(0) { it + 1 }.filter { delay ->

            fireWallMap.entries.forEach { (depth, range) ->

                if ((depth + delay) % ((range - 1) * 2) == 0) {
                    return@filter false
                }

            }

            true

        }.first()

    }


    private fun parseInput(input: String) : Map<Int, Int> {

        var temp: List<String>

        return input.splitAtNewLines().map {
            temp = it.split(":")
            temp[0].trim().toInt() to temp[1].trim().toInt()
        }.toMap()

    }
}