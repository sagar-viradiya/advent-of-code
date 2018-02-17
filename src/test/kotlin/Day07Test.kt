import org.junit.Assert
import org.junit.Test
import utils.getInput

class Day07Test {

    @Test
    fun `part 01 sample test`() {
        Assert.assertEquals("tknk", Day07.part1(getInput("day07sample01.txt")))
        Assert.assertEquals("a", Day07.part1(getInput("day07sample02.txt")))
    }

    @Test
    fun  `part 01 actual test`() {
        Assert.assertEquals("fbgguv", Day07.part1(getInput("day07.txt")))
    }

    @Test
    fun `part 02 sample test`() {
        Assert.assertEquals(60, Day07.part2(getInput("day07sample01.txt")))
    }

    @Test
    fun `part 02 actual test`() {
        Assert.assertEquals(1864, Day07.part2(getInput("day07.txt")))
    }

}