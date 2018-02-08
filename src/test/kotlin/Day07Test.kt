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

}