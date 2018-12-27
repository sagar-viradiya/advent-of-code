import org.junit.Assert
import org.junit.Test
import utils.getInput

class Day19Test {

    @Test
    fun `part 1 sample test`() {
        Assert.assertEquals("ABCDEFG", Day19.part1(getInput("day19sample.txt")))
    }

    @Test
    fun `part 1 actual test`() {
        Assert.assertEquals("GINOWKYXH", Day19.part1(getInput("day19.txt")))
    }
}