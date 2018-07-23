import utils.splitAtComma

object Day16 {

    fun part1(danceMoves: String, input: String = "abcdefghijklmnop"): String {

        val programs = StringBuffer(input)
        var danceMoveType: DanceMoveType

        for (danceMove in danceMoves.splitAtComma()) {

            danceMoveType = getDanceMoveType(danceMove)
            when(danceMoveType) {
                is DanceMoveType.Spin -> {
                    val splitAt = input.length - danceMoveType.spins
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