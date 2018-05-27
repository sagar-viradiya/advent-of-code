import utils.splitAtNewLines

object Day13 {

    fun part1(input: String) : Int {

        return parseInput(input).entries.sumBy { (depth, range) ->
            if (depth % ((range - 1) * 2) == 0) depth * range else 0
        }

    }

    private fun parseInput(input: String) : Map<Int, Int> {

        var temp: List<String>

        return input.splitAtNewLines().map {
            temp = it.split(":")
            temp[0].trim().toInt() to temp[1].trim().toInt()
        }.toMap()

    }
}