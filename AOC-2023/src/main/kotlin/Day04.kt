import utils.*
import kotlin.math.pow

object Day04 {

    fun part01(input: String): Long {
        return input
            .splitAtNewLines()
            .map { card ->
                val numbers = card.splitAtColon()[1].trim().split("|")
                val winningNumbers = numbers[0].trim().splitAtWhiteSpace().toIntList()
                val cardNumbers = numbers[1].trim().splitAtWhiteSpace().toIntList()
                Pair(winningNumbers, cardNumbers)
            }.map { pair ->
                Pair<Map<Int, Int>, Map<Int, Int>>(
                    pair.first.groupingBy { it }.eachCount(),
                    pair.second.groupingBy { it }.eachCount()
                )
            }.sumOf { pair ->
                val numberOfMatches = pair.second.entries.sumOf { numberEntry ->
                    if (pair.first.contains(numberEntry.key)) {
                        numberEntry.value
                    } else 0
                }
                if (numberOfMatches > 0) {
                    2.0.pow((numberOfMatches - 1).toDouble()).toLong()
                } else {
                    0L
                }
            }
    }

    fun part02(input: String): Int {
        val cardWon = mutableMapOf<Int, Int>()

        input
            .splitAtNewLines()
            .map { card ->
                val numbers = card.splitAtColon()[1].trim().split("|")
                val winningNumbers = numbers[0].trim().splitAtWhiteSpace().toIntList()
                val cardNumbers = numbers[1].trim().splitAtWhiteSpace().toIntList()
                Pair(winningNumbers, cardNumbers)
            }.map { pair ->
                Pair<Map<Int, Int>, Map<Int, Int>>(
                    pair.first.groupingBy { it }.eachCount(),
                    pair.second.groupingBy { it }.eachCount()
                )
            }.forEachIndexed { index, pair ->
                val currentCards = cardWon.getOrPut(index + 1) {
                    1
                }
                val numberOfMatches = pair.second.entries.sumOf { numberEntry ->
                    if (pair.first.contains(numberEntry.key)) {
                        numberEntry.value
                    } else 0
                }

                repeat(numberOfMatches) { count ->
                   cardWon[index + 2 + count] = cardWon.getOrPut(index + 2 + count) { 1 } + currentCards
                }
            }

        return cardWon.entries.sumOf { it.value }
    }

}