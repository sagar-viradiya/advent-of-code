import org.junit.Assert
import org.junit.Test
import utils.getInput

class Day09Test {

    @Test
    fun `part 1 sample tests`() {
        Assert.assertEquals(6, Day09.part1(getInput("day09sample.txt")))
        Assert.assertEquals(3, Day09.part1(getInput("day09sample01.txt")))
    }

    @Test
    fun `part 1 actual test`() {
        Assert.assertEquals(21037, Day09.part1(getInput("day09.txt")))
    }

    @Test
    fun `part 2 sample test`() {
        Assert.assertEquals(10, Day09.part2(getInput("day09sample02.txt")))
    }

    @Test
    fun `part 2 actual test`() {
        Assert.assertEquals(9495, Day09.part2(getInput("day09.txt")))
    }

}