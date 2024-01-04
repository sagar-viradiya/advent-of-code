import utils.splitAtComma

object Day16 {

    fun part1(danceMoves: String, input: String = "abcdefghijklmnop"): String {

        val programs = StringBuffer(input)
        var danceMoveType: DanceMoveType

        for (danceMove in danceMoves.splitAtComma()) {

            danceMoveType = getDanceMoveType(danceMove)
            when(danceMoveType) {
                is DanceMoveType.Spin -> {
                    val splitAt = programs.length - danceMoveType.spins
                    val firstPart = programs.substring(0 until splitAt)
                    programs.replace(0, splitAt, "")
                    programs.append(firstPart)
                }
                is DanceMoveType.Exchange -> {
                    val programA = programs[danceMoveType.positionA]
                    val programB = programs[danceMoveType.positionB]
                    programs.replace(danceMoveType.positionA, danceMoveType.positionA + 1, programB.toString())
                    programs.replace(danceMoveType.positionB, danceMoveType.positionB + 1, programA.toString())
                }
                is DanceMoveType.Partner -> {
                    val positionA = programs.indexOf(danceMoveType.programA)
                    val positionB = programs.indexOf(danceMoveType.programB)
                    programs.replace(positionA, positionA + 1, danceMoveType.programB.toString())
                    programs.replace(positionB, positionB + 1, danceMoveType.programA.toString())
                }
            }
        }

        return programs.toString()
    }


    /**
     * Old solution using caching to reduce computation.
     * Not optimise as it is iterating 1 billion times!
     * */
    /*fun part2(danceMoves: String, input: String = "abcdefghijklmnop", danceRepeat: Long = 1000000000): String {

        var _input = input
        val danceMapping = mutableMapOf<String, String>()

        for (i in 0 until danceRepeat) {

            if (danceMapping[_input] == null) {
                danceMapping[_input] = part1(danceMoves, _input)
            }
            _input = danceMapping[_input]!!

        }

        return _input

    }*/

    /**
     * Original solution was to iterate 1 billion times! and cache the result of dance sequence.
     *
     * This solution is optimised as it has much less iterations.
     * Copied form https://github.com/dlew/aoc-2017/blob/answers/src/main/kotlin/Day16.kt
     * */
    fun part2(danceMoves: String, input: String = "abcdefghijklmnop", danceRepeat: Int = 1000000000): String {

        var _input = input
        for (i in 0 until danceRepeat % findCycleLength(danceMoves, input)) {
            _input = part1(danceMoves, _input)
        }
        return _input

    }

    private fun findCycleLength(danceMoves: String, input: String): Int {
        var _input = input
        val seen = mutableSetOf<String>()
        var length = 0
        while (_input !in seen) {
            seen.add(_input)
            _input = part1(danceMoves, _input)
            length++
        }

        return length
    }

    private fun getDanceMoveType(input: String): DanceMoveType {
        return when(input[0]) {
            's' -> DanceMoveType.Spin(input.substring(1).toInt())
            'x' -> {
                val exchangeIndices = input.substring(1).split("/")
                DanceMoveType.Exchange(exchangeIndices[0].toInt(), exchangeIndices[1].toInt())
            }
            'p' -> {
                DanceMoveType.Partner(input[1], input[3])
            }
            else -> throw IllegalArgumentException("Invalid dance move")
        }
    }

    sealed class DanceMoveType {
        class Spin(val spins: Int): DanceMoveType()
        class Exchange(val positionA: Int, val positionB: Int): DanceMoveType()
        class Partner(val programA: Char, val programB: Char): DanceMoveType()
    }
}