import utils.*

const val RED_BALLS = 12
const val BLUE_BALLS = 14
const val GREEN_BALLS = 13

object Day02 {
    fun part01(input: String): Int {
        val games = input.splitAtNewLines()

        return games.mapIndexed { index, s ->
            Pair(index, s.splitAtColon()[1])
        }.map { sets ->
            val isPossible = sets.first + 1
            sets.second.splitAtSemiColon().forEach outer@{ set ->
                set.splitAtComma().forEach { balls ->
                    val semiSet = balls.splitAtWhiteSpace()
                    val number = semiSet[0].toInt()
                    val requiredNumber = when (semiSet[1]) {
                        "red" -> RED_BALLS
                        "blue" -> BLUE_BALLS
                        "green" -> GREEN_BALLS
                        else -> throw IllegalStateException("Freak out!")
                    }
                    if (requiredNumber < number) {
                        return@map 0
                    }
                }
            }
            isPossible
        }.sum()
    }

    fun part02(input: String): Int {
        val games = input.splitAtNewLines()

        return games.map { game ->
            game.splitAtColon()[1]
        }.sumOf { sets ->
            var reqRed = 0
            var reqBlue = 0
            var reqGreen = 0
            sets.splitAtSemiColon().forEach outer@{ set ->
                set.splitAtComma().forEach { balls ->
                    val semiSet = balls.splitAtWhiteSpace()
                    val actualNumber = semiSet[0].toInt()
                    when (semiSet[1]) {
                        "red" -> if (reqRed < actualNumber) {
                            reqRed = actualNumber
                        }

                        "blue" -> if (reqBlue < actualNumber) {
                            reqBlue = actualNumber
                        }

                        "green" -> if (reqGreen < actualNumber) {
                            reqGreen = actualNumber
                        }

                        else -> throw IllegalStateException("Freak out!")
                    }
                }
            }
            reqRed * reqBlue * reqGreen
        }
    }
}