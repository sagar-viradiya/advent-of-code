import org.junit.Assert
import org.junit.Test
import utils.getInput

/**
 * Created by sagar on 25/01/18.
 */
class Day04Test {

    @Test
    fun `part 01 sample test`() {
        Assert.assertEquals(2, Day04.part1(getInput("day04sample.txt")))
    }

    @Test
    fun `part 01 actual test`() {
        Assert.assertEquals(455, Day04.part1(getInput("day04.txt")))
    }

    @Test
    fun `part 02 sample test`() {
        Assert.assertEquals(3, Day04.part2(getInput("day04sample2.txt")))
    }

    @Test
    fun `part 02 actual test`() {
        Assert.assertEquals(186, Day04.part2(getInput("day04.txt")))
    }
}