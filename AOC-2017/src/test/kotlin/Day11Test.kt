import utils.getInput
import kotlin.test.Test
import kotlin.test.assertEquals

class Day11Test {

    @Test
    fun `part 01 sample tests`() {
        assertEquals(3, Day11.part1(getInput("day11sample01.txt")))
        assertEquals(0, Day11.part1(getInput("day11sample02.txt")))
        assertEquals(3, Day11.part1(getInput("day11sample03.txt")))
    }

    @Test
    fun `part 01 actual test`() {
        assertEquals(784, Day11.part1(getInput("day11.txt")))
    }

    @Test
    fun `part 02 actual test`() {
        assertEquals(1558, Day11.part2(getInput("day11.txt")))
    }

}