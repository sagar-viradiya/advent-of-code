import org.junit.Assert
import org.junit.Test
import utils.getInput

class Day18Test {

    @Test
    fun `part 1 sample test`() {
        Assert.assertEquals(4, Day18.part1(getInput("day18sample.txt")))
    }

    @Test
    fun `part 1 actual test`() {
        Assert.assertEquals(7071, Day18.part1(getInput("day18.txt")))
    }

}