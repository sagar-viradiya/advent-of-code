import org.junit.Assert
import org.junit.Test
import utils.getInput

class Day10Test {

    @Test
    fun `part 1 sample test`() {
        Assert.assertEquals(12, Day10.part1(getInput("Day10sample.txt"), 5))
    }

    @Test
    fun `part 2 actual test`() {
        Assert.assertEquals(29240, Day10.part1(getInput("Day10.txt")))
    }

}