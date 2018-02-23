import org.junit.Assert
import org.junit.Test
import utils.getInput

class Day08Test {

    @Test
    fun `part 01 sample test`() {
        Assert.assertEquals(1, Day08.part1(getInput("day08sample.txt")))
    }

    @Test
    fun `part 01 actual test`() {
        Assert.assertEquals(6061, Day08.part1(getInput("day08.txt")))
    }

}