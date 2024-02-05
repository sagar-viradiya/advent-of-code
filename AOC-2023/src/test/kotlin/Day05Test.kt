import org.junit.jupiter.api.Test
import utils.getInput
import kotlin.test.assertEquals

class Day05Test {


    @Test
    fun `part 01 sample test`() {
        assertEquals(35, Day05.part01(getInput("day-05-part-01-sample.txt")))
    }

    @Test
    fun `part 01 test`() {
        assertEquals(322500873, Day05.part01(getInput("day-05-part-01.txt")))
    }

    @Test
    fun `part 02 sample test`() {
        assertEquals(46, Day05.part02(getInput("day-05-part-01-sample.txt")))
    }

    @Test
    fun `part 02 test`() {
        assertEquals(108956227, Day05.part02(getInput("day-05-part-02.txt")))
    }
}