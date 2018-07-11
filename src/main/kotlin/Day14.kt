object Day14 {

    fun part1(input: String) = (0..127).sumBy { getBinaryKnotHash(Day10.part2("$input-$it"), true).length }

    fun part2(input: String): Int {
        val disk = getDisk(input)
        var regions = 0

        for (i in 0 until disk.size) {
            for (j in 0 until disk[i].size) {
                if (disk[i][j]) {
                    disk[i][j] = false
                    regions++
                    clearRegions(i, j, disk)
                }
            }
        }

        return regions
    }

    private fun getBinaryKnotHash(input: String, reduced: Boolean = false): String {
        val reducedBinaryKnotHash = StringBuffer()
        input.forEach { reducedBinaryKnotHash.append(if (reduced) getReducedBinary(it) else getBinary(it)) }
        return reducedBinaryKnotHash.toString()
    }

    private fun getDisk(input: String): List<MutableList<Boolean>> {
        return (0..127).map { getBinaryKnotHash(Day10.part2("$input-$it")) }
                       .map { it.map { it == '1' }.toMutableList() }
    }

    private fun clearRegions(row: Int, column: Int, disk: List<MutableList<Boolean>>) {

        if (row > 0 && disk[row - 1][column]) {
            disk[row - 1][column] = false
            clearRegions(row - 1, column, disk)
        }

        if (row < 127 && disk[row + 1][column]) {
            disk[row + 1][column] = false
            clearRegions(row + 1, column, disk)
        }

        if (column > 0 && disk[row][column - 1]) {
            disk[row][column - 1] = false
            clearRegions(row, column - 1, disk)
        }

        if (column < 127 && disk[row][column + 1]) {
            disk[row][column + 1] = false
            clearRegions(row, column + 1, disk)
        }

    }

    private fun getReducedBinary(input: Char) = when(input) {
        '0' -> ""
        '1', '2', '4', '8' -> "1"
        '3', '5', '6', '9', 'a', 'c' -> "11"
        '7', 'b', 'd', 'e' -> "111"
        'f' -> "1111"
        else -> throw IllegalStateException("Illegal hex value")
    }

    private fun getBinary(input: Char) = when(input) {
        '0' -> "0000"
        '1' -> "0001"
        '2' -> "0010"
        '3' -> "0011"
        '4' -> "0100"
        '5' -> "0101"
        '6' -> "0110"
        '7' -> "0111"
        '8' -> "1000"
        '9' -> "1001"
        'a' -> "1010"
        'b' -> "1011"
        'c' -> "1100"
        'd' -> "1101"
        'e' -> "1110"
        'f' -> "1111"
        else -> throw IllegalStateException("Illegal hex value")
    }

}