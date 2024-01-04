import utils.getInput
import kotlin.test.Test
import kotlin.test.assertEquals

class Day20Test {

    @Test
    fun `part 1 sample test`() {
        assertEquals(0, Day20.part1(getInput("day20sample.txt")))
    }

    @Test
    fun `part 1 actual test`() {
        assertEquals(144, Day20.part1(getInput("day20.txt")))
    }

    @Test
    fun `part 2 sample test`() {
        assertEquals(1, Day20.part2(getInput("day20sample02.txt")))
    }

    @Test
    fun `part 2 actual test`() {
        assertEquals(477, Day20.part2(getInput("day20.txt")))
    }

}