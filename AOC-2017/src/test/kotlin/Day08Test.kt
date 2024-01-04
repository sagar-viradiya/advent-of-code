import utils.getInput
import kotlin.test.Test
import kotlin.test.assertEquals

class Day08Test {

    @Test
    fun `part 01 sample test`() {
        assertEquals(1, Day08.part1(getInput("day08sample.txt")))
    }

    @Test
    fun `part 01 actual test`() {
        assertEquals(6061, Day08.part1(getInput("day08.txt")))
    }

    @Test
    fun `part 02 sample test`() {
        assertEquals(10, Day08.part2(getInput("day08sample.txt")))
    }

    @Test
    fun `part 02 actual test`() {
        assertEquals(6696, Day08.part2(getInput("day08.txt")))
    }

}