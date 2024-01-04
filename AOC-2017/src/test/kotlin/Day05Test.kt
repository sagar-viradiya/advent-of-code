import utils.getInput
import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * Created by sagar on 29/01/18.
 */
class Day05Test {

    @Test
    fun `part 01 sample test`() {
        assertEquals(5, Day05.part1(getInput("day05sample.txt")))
    }

    @Test
    fun `part 01 actual test`() {
        assertEquals(343364, Day05.part1(getInput("day05.txt")))
    }

    @Test
    fun `part 02 sample test`() {
        assertEquals(10, Day05.part2(getInput("day05sample.txt")))
    }

    @Test
    fun `part 02 actual test`() {
        assertEquals(25071947, Day05.part2(getInput("day05.txt")))
    }

}