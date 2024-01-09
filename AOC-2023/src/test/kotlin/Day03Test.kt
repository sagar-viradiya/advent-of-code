import org.junit.jupiter.api.Test
import utils.getInput
import kotlin.test.assertEquals

class Day03Test {
    @Test
    fun `part 01 sample test`() {
        assertEquals(4361, Day03.part01(getInput("day-03-part-01-sample.txt")))
    }

    @Test
    fun `part 01 test`() {
        assertEquals(554003, Day03.part01(getInput("day-03-part-01.txt")))
    }

    @Test
    fun `part 02 sample test`() {
        assertEquals(467835, Day03.part02(getInput("day-03-part-01-sample.txt")))
    }

    @Test
    fun `part 02 test`() {
        assertEquals(87263515, Day03.part02(getInput("day-03-part-02.txt")))
    }
}