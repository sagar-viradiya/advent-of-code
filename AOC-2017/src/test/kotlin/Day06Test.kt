import utils.getInput
import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * Created by sagar on 30/01/18.
 */
class Day06Test {

    @Test
    fun `part 01 sample test`() {
        assertEquals(5, Day06.part1(getInput("day06sample.txt")))
    }

    @Test
    fun `part 01 actual test`() {
        assertEquals(12841, Day06.part1(getInput("day06.txt")))
    }

    @Test
    fun `part 02 sample test`() {
        assertEquals(4, Day06.part2(getInput("day06sample.txt")))
    }

    @Test
    fun `part 02 actual test`() {
        assertEquals(8038, Day06.part2(getInput("day06.txt")))
    }

}