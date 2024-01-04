import utils.getInput
import kotlin.test.Test
import kotlin.test.assertEquals

class Day12Test {

    @Test
    fun `part 1 sample test`() {
        assertEquals(6, Day12.part1(getInput("day12sample.txt")))
    }

    @Test
    fun `part 1 actual test`() {
        assertEquals(145, Day12.part1(getInput("day12.txt")))
    }

    @Test
    fun `part 2 sample test`() {
        assertEquals(2, Day12.part2(getInput("day12sample.txt")))
    }

    @Test
    fun `part 2 actual test`() {
        assertEquals(207, Day12.part2(getInput("day12.txt")))
    }
}