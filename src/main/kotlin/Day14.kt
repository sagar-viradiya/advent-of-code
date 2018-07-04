object Day14 {

    fun part1(input: String) = (0..127).sumBy { getReducedBinaryKnotHash(Day10.part2("$input-$it")).length }

    private fun getReducedBinaryKnotHash(input: String): String {
        val reducedBinaryKnotHash = StringBuffer()
        input.forEach { reducedBinaryKnotHash.append(getReducedBinary(it)) }
        return reducedBinaryKnotHash.toString()
    }

    private fun getReducedBinary(input: Char) = when(input) {
        '0' -> ""
        '1', '2', '4', '8' -> "1"
        '3', '5', '6', '9', 'a', 'c' -> "11"
        '7', 'b', 'd', 'e' -> "111"
        'f' -> "1111"
        else -> throw IllegalStateException("Illegal hex value")
    }

}