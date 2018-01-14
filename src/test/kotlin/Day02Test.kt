import org.junit.Assert.*
import org.junit.Test
import utils.getInput

/**
 * Created by sagar on 14/01/18.
 */
class Day02Test {

    @Test
    fun `part 01 sample test`() {
        assertEquals(18, Day02.part1(getInput("day02sample01.txt")))
    }

    @Test
    fun `part 01 actual test`() {
        assertEquals(44216, Day02.part1(getInput("day02.txt")))
    }

    @Test
    fun `part 02 sample test`() {
        assertEquals(9, Day02.part2(getInput("day02sample02.txt")))
    }

    @Test
    fun `part 02 actual test`() {
        assertEquals(320, Day02.part2(getInput("day02.txt")))
    }

}