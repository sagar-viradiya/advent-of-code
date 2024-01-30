import utils.getInput
import kotlin.test.Test
import kotlin.test.assertEquals


class  Day04Test {
    @Test
    fun `day 04 sample test`() {
        assertEquals(13, Day04.part01(getInput("day-04-part-01-sample.txt")))
    }

    @Test
    fun `day 04 part 01 test`() {
        assertEquals(25004, Day04.part01(getInput("day-04-part-01.txt")))
    }

    @Test
    fun `day 04 part 02 sample test`() {
        assertEquals(30, Day04.part02(getInput("day-04-part-02-sample.txt")))
    }

    @Test
    fun `day 04 part 02 test`() {
        assertEquals(14427616, Day04.part02(getInput("day-04-part-02.txt")))
    }
}