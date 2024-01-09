import utils.splitAtNewLines
import kotlin.math.pow

enum class Move(val direction: Pair<Int, Int>) {
    LEFT(Pair(0, -1)),
    RIGHT(Pair(0, 1)),
    UP(Pair(-1, 0)),
    DOWN(Pair(1, 0)),
    TOP_LEFT(Pair(-1, -1)),
    TOP_RIGHT(Pair(-1, 1)),
    BOTTOM_LEFT(Pair(1, -1)),
    BOTTOM_RIGHT(Pair(1, 1))
}

object Day03 {
    fun part01(input: String): Int {
        val enginSchematic = input.splitAtNewLines().map { it.toCharArray() }
        var partSum = 0
        for (i in enginSchematic.indices) {
            var j = 0
            while (j < enginSchematic[i].size) {
                if (enginSchematic[i][j].isDigit() && isPartNumber(enginSchematic, Pair(i, j))) {
                    var digit = enginSchematic[i][j].digitToInt()
                    var leftMostIndex = j
                    var rightMostIndex = j
                    while (leftMostIndex - 1 >= 0 && enginSchematic[i][leftMostIndex - 1].isDigit()) {
                        digit +=  (10.0.pow(j - --leftMostIndex)).toInt() * enginSchematic[i][leftMostIndex].digitToInt()
                    }
                    while (rightMostIndex + 1 < enginSchematic[i].size && enginSchematic[i][rightMostIndex + 1].isDigit()) {
                        digit = (digit * 10) + enginSchematic[i][++rightMostIndex].digitToInt()
                    }
                    j = rightMostIndex + 1
                    partSum += digit
                } else {
                    j++
                }
            }
        }
        return partSum
    }

    fun part02(input: String): Long {
        val enginSchematic = input.splitAtNewLines().map { it.toCharArray() }
        var gearRatio = 0L
        var i = 0
        while (i < enginSchematic.size) {
            var j = 0
            while (j < enginSchematic[i].size) {
                if (enginSchematic[i][j] == '*') {
                    val parts = getPartsAdjacentToGear(enginSchematic, Pair(i, j))
                    if (parts.first != -1 && parts.second != -1) {
                        gearRatio += parts.first * parts.second
                    }
                }
                j++
            }
            i++
        }
        return gearRatio
    }

    private fun getPartsAdjacentToGear(enginSchematic: List<CharArray>, gearCoordinates: Pair<Int, Int>): Pair<Int, Int> {
        var firstPart = -1
        var secondPart = -1
        val defaultParts = Pair(-1, -1)
        val visitedDirection = hashSetOf<Move>()

        Move.entries.forEach { move ->
            if (!visitedDirection.contains(move)) {
                visitedDirection.add(move)
                val moveX = gearCoordinates.second + move.direction.second
                val moveY = gearCoordinates.first + move.direction.first
                if (moveX in 0..<enginSchematic[gearCoordinates.first].size
                    && moveY in enginSchematic.indices
                    && enginSchematic[moveY][moveX].isDigit()
                ) {
                    if (firstPart != -1 && secondPart != -1) return defaultParts

                    var leftmostIndex = moveX
                    var rightmostIndex = moveX

                    var digit = enginSchematic[moveY][moveX].digitToInt()
                    while (leftmostIndex - 1 >= 0 && enginSchematic[moveY][leftmostIndex - 1].isDigit()) {
                        digit +=  (10.0.pow(moveX - (--leftmostIndex))).toInt() * enginSchematic[moveY][leftmostIndex].digitToInt()
                        if (move == Move.UP) {
                            visitedDirection.add(Move.TOP_LEFT)
                        } else if (move == Move.DOWN) {
                            visitedDirection.add(Move.BOTTOM_LEFT)
                        }
                    }

                    while (rightmostIndex + 1 < enginSchematic[moveY].size && enginSchematic[moveY][rightmostIndex + 1].isDigit()) {
                        digit = (digit * 10) + enginSchematic[moveY][++rightmostIndex].digitToInt()
                        if (move == Move.UP) {
                            visitedDirection.add(Move.TOP_RIGHT)
                        } else if (move == Move.DOWN) {
                            visitedDirection.add(Move.BOTTOM_RIGHT)
                        }
                    }

                    if (firstPart == -1) {
                        firstPart = digit
                    } else if (secondPart == -1) {
                        secondPart = digit
                    }
                }
            }
        }
        return Pair(firstPart, secondPart)
    }

    private fun isPartNumber(enginSchematic: List<CharArray>, coordinates: Pair<Int, Int>): Boolean {
        Move.entries.forEach { move ->
            val moveX = coordinates.second + move.direction.second
            val moveY = coordinates.first + move.direction.first

            if (moveX in 0..<enginSchematic[coordinates.first].size
                && moveY in enginSchematic.indices
                && (enginSchematic[moveY][moveX] != '.' && !enginSchematic[moveY][moveX].isDigit())
            ) {
                return true
            }
        }
        return false
    }
}