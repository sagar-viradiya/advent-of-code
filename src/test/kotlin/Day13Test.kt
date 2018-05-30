import org.junit.Assert
import org.junit.Test
import utils.getInput

class Day13Test {

    @Test
    fun `part 1 sample test`() {
        Assert.assertEquals(24, Day13.part1(getInput("day13sample.txt")))
    }

    @Test
    fun `part 1 actual test`() {
        Assert.assertEquals(1300, Day13.part1(getInput("day13.txt")))
    }

    @Test
    fun `part 2 sample test`() {
        Assert.assertEquals(10, Day13.part2(getInput("day13sample.txt")))
    }

    @Test
    fun `part 2 actual test`() {
        Assert.assertEquals(3870382, Day13.part2(getInput("day13.txt")))
    }
}