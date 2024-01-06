import utils.getInput
import kotlin.test.Test
import kotlin.test.assertEquals

class Day01Test {

    @Test
    fun `day 1, part 1 sample`() {
        assertEquals(142, Day01.day01Part01(getInput("day-01-part-01-sample.txt")))
    }

    @Test
    fun `day 1, part 1`() {
        assertEquals(54940, Day01.day01Part01(getInput("day-01-part-01.txt")))
    }

    @Test
    fun `day 1, part 2 sample`() {
        assertEquals(281, Day01.day01Part02(getInput("day-01-part-02-sample.txt")))
    }

    @Test
    fun `day 1, part 2`() {
        assertEquals(54208, Day01.day01Part02(getInput("day-01-part-02.txt")))
    }
}