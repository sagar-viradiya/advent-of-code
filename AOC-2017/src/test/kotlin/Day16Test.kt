import utils.getInput
import kotlin.test.Test
import kotlin.test.assertEquals

class Day16Test {

    @Test
    fun `part 1 sample test`() {
        assertEquals("baedc", Day16.part1(getInput("day16sample.txt"), "abcde"))
    }

    @Test
    fun `part 1 actual test`() {
        assertEquals("doeaimlbnpjchfkg", Day16.part1(getInput("day16.txt")))
    }

    @Test
    fun `part 2 sample test`() {
        assertEquals("ceadb", Day16.part2(getInput("day16sample.txt"), "abcde", 2))
    }

    @Test
    fun `part 2 actual test`() {
        assertEquals("agndefjhibklmocp", Day16.part2(getInput("day16.txt")))
    }
}