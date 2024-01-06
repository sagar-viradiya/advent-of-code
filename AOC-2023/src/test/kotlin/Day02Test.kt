import org.junit.jupiter.api.Test
import utils.getInput
import kotlin.test.assertEquals

class Day02Test {

    @Test
    fun `test day 02 part 01 sample`() {
        assertEquals(8, Day02.part01(getInput("day-02-part-01-sample.txt")))
    }

    @Test
    fun `test day 02 part 01`() {
        println(Day02.part01(getInput("day-02-part-01.txt")))
    }

    @Test
    fun `test day 02 part 02 sample`() {
        assertEquals(2286, Day02.part02(getInput("day-02-part-02-sample.txt")))
    }

    @Test
    fun `test day 02 part 02`() {
        assertEquals(66363, Day02.part02(getInput("day-02-part-02.txt")))
    }
}