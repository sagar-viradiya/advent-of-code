import utils.getInput
import kotlin.test.Test
import kotlin.test.assertEquals

class Day18Test {

    @Test
    fun `part 1 sample test`() {
        assertEquals(4, Day18.part1(getInput("day18sample.txt")))
    }

    @Test
    fun `part 1 actual test`() {
        assertEquals(7071, Day18.part1(getInput("day18.txt")))
    }

}