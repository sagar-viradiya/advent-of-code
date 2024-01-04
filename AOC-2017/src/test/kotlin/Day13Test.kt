import utils.getInput
import kotlin.test.Test
import kotlin.test.assertEquals

class Day13Test {

    @Test
    fun `part 1 sample test`() {
        assertEquals(24, Day13.part1(getInput("day13sample.txt")))
    }

    @Test
    fun `part 1 actual test`() {
        assertEquals(1300, Day13.part1(getInput("day13.txt")))
    }

    @Test
    fun `part 2 sample test`() {
        assertEquals(10, Day13.part2(getInput("day13sample.txt")))
    }

    @Test
    fun `part 2 actual test`() {
        assertEquals(3870382, Day13.part2(getInput("day13.txt")))
    }
}