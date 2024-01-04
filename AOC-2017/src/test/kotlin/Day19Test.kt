import utils.getInput
import kotlin.test.Test
import kotlin.test.assertEquals

class Day19Test {

    @Test
    fun `part 1 sample test`() {
        assertEquals("ABCDEFG", Day19.part1(getInput("day19sample.txt")))
    }

    @Test
    fun `part 1 actual test`() {
        assertEquals("GINOWKYXH", Day19.part1(getInput("day19.txt")))
    }

    @Test
    fun `part 2 sample test`() {
        assertEquals(46, Day19.part2(getInput("day19sample.txt")))
    }

    @Test
    fun `part 2 actual test`() {
        assertEquals(16636, Day19.part2(getInput("day19.txt")))
    }
}