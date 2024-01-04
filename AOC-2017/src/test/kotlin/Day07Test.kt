import utils.getInput
import kotlin.test.Test
import kotlin.test.assertEquals

class Day07Test {

    @Test
    fun `part 01 sample test`() {
        assertEquals("tknk", Day07.part1(getInput("day07sample01.txt")))
        assertEquals("a", Day07.part1(getInput("day07sample02.txt")))
    }

    @Test
    fun  `part 01 actual test`() {
        assertEquals("fbgguv", Day07.part1(getInput("day07.txt")))
    }

    @Test
    fun `part 02 sample test`() {
        assertEquals(60, Day07.part2(getInput("day07sample01.txt")))
    }

    @Test
    fun `part 02 actual test`() {
        assertEquals(1864, Day07.part2(getInput("day07.txt")))
    }

}