import org.junit.Assert
import org.junit.Test
import utils.getInput

class Day11Test {

    @Test
    fun `part 01 sample tests`() {
        Assert.assertEquals(3, Day11.part1(getInput("day11sample01.txt")))
        Assert.assertEquals(0, Day11.part1(getInput("day11sample02.txt")))
        Assert.assertEquals(3, Day11.part1(getInput("day11sample03.txt")))
    }

    @Test
    fun `part 01 actual test`() {
        Assert.assertEquals(784, Day11.part1(getInput("day11.txt")))
    }

}