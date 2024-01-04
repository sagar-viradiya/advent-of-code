import utils.getInput
import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * Created by sagar on 25/01/18.
 */
class Day04Test {

    @Test
    fun `part 01 sample test`() {
        assertEquals(2, Day04.part1(getInput("day04sample.txt")))
    }

    @Test
    fun `part 01 actual test`() {
        assertEquals(455, Day04.part1(getInput("day04.txt")))
    }

    @Test
    fun `part 02 sample test`() {
        assertEquals(3, Day04.part2(getInput("day04sample2.txt")))
    }

    @Test
    fun `part 02 actual test`() {
        assertEquals(186, Day04.part2(getInput("day04.txt")))
    }
}