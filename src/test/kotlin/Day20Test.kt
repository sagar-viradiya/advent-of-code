import org.junit.Assert
import org.junit.Test
import utils.getInput

class Day20Test {

    @Test
    fun `part 1 sample test`() {
        Assert.assertEquals(0, Day20.part1(getInput("day20sample.txt")))
    }

    @Test
    fun `part 1 actual test`() {
        Assert.assertEquals(144, Day20.part1(getInput("day20.txt")))
    }

    @Test
    fun `part 2 sample test`() {
        Assert.assertEquals(1, Day20.part2(getInput("day20sample02.txt")))
    }

    @Test
    fun `part 2 actual test`() {
        Assert.assertEquals(477, Day20.part2(getInput("day20.txt")))
    }

}