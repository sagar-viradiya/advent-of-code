import org.junit.Assert
import org.junit.Test
import utils.getInput

class Day12Test {

    @Test
    fun `part 1 sample test`() {
        Assert.assertEquals(6, Day12.part1(getInput("day12sample.txt")))
    }

    @Test
    fun `part 1 actual test`() {
        Assert.assertEquals(145, Day12.part1(getInput("day12.txt")))
    }

    @Test
    fun `part 2 sample test`() {
        Assert.assertEquals(2, Day12.part2(getInput("day12sample.txt")))
    }

    @Test
    fun `part 2 actual test`() {
        Assert.assertEquals(207, Day12.part2(getInput("day12.txt")))
    }
}