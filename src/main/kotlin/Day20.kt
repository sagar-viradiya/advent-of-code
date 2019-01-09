import utils.distance
import utils.plus
import utils.splitAtNewLines
import java.lang.IllegalStateException

object Day20 {

    data class Particle(val id: Int,
                        val position: Triple<Long, Long, Long>,
                        val velocity: Triple<Long, Long, Long>,
                        val acceleration: Triple<Long, Long, Long>) {
        fun update() = copy(velocity = velocity + acceleration, position = position + velocity + acceleration)
    }

    fun part1(input: String): Int {
        return parseInput(input).minBy { it.acceleration.distance() }?.id ?: throw IllegalStateException("Freak out!!")
    }

    private fun parseInput(input: String): List<Particle> {
        return input.splitAtNewLines().mapIndexed { index, s ->
            s.split("<", ">").let {
                Particle(index, parseInputLine(it[1]), parseInputLine(it[3]), parseInputLine(it[5]))
            }
        }
    }

    private fun parseInputLine(input: String): Triple<Long, Long, Long> {
        return input.split(",").map { it.trim().toLong() }.let { Triple(it[0], it[1], it[2]) }
    }

}