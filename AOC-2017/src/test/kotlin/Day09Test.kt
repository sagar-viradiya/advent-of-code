import utils.getInput
import kotlin.test.Test
import kotlin.test.assertEquals

class Day09Test {

    @Test
    fun `part 1 sample tests`() {
        assertEquals(6, Day09.part1(getInput("day09sample.txt")))
        assertEquals(3, Day09.part1(getInput("day09sample01.txt")))
    }

    @Test
    fun `part 1 actual test`() {
        assertEquals(21037, Day09.part1(getInput("day09.txt")))
    }

    @Test
    fun `part 2 sample test`() {
        assertEquals(10, Day09.part2(getInput("day09sample02.txt")))
    }

    @Test
    fun `part 2 actual test`() {
        assertEquals(9495, Day09.part2(getInput("day09.txt")))
    }

}