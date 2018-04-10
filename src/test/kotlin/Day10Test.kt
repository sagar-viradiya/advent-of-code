import org.junit.Assert
import org.junit.Test
import utils.getInput

class Day10Test {

    @Test
    fun `part 1 sample test`() {
        Assert.assertEquals(12, Day10.part1(getInput("day10sample.txt"), 5))
    }

    @Test
    fun `part 1 actual test`() {
        Assert.assertEquals(29240, Day10.part1(getInput("day10.txt")))
    }

    @Test
    fun `part 2 sample tests`() {
        Assert.assertEquals("a2582a3a0e66e6e86e3812dcb672a272", Day10.part2(""))
        Assert.assertEquals("33efeb34ea91902bb2f59c9920caa6cd", Day10.part2("AoC 2017"))
        Assert.assertEquals("3efbe78a8d82f29979031a4aa0b16a9d", Day10.part2("1,2,3"))
    }

    @Test
    fun `part 2 actual test`() {
        Assert.assertEquals("4db3799145278dc9f73dcdbc680bd53d", Day10.part2(getInput("day10.txt")))
    }

}