import utils.splitAtComma
import kotlin.math.abs

object Day11 {

    fun part1(input: String): Int {

        return input
            .splitAtComma()
            .fold(HexCoordinates(), { hex, direction -> hex.move(direction) })
            .calculateDistanceFromOrigin()

    }

    data class HexCoordinates(private val x: Int = 0, private val y: Int = 0, private val z: Int = 0) {

        fun move(direction: String): HexCoordinates {

            return when (direction) {
                "n" -> copy(y = y + 1, z = z - 1)
                "ne" -> copy(x = x + 1, z = z - 1)
                "se" -> copy(x = x + 1, y = y - 1)
                "s" -> copy(z = z + 1, y = y - 1)
                "sw" -> copy(x = x - 1, z = z + 1)
                "nw" -> copy(x = x - 1, y = y + 1)
                else -> throw IllegalArgumentException("Unknown direction")
            }

        }

        fun calculateDistanceFromOrigin(): Int = (abs(x) + abs(y) + abs(z)) / 2

    }

}