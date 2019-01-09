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

}