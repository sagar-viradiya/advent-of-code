import org.junit.Assert
import org.junit.Test
import utils.getInput

class Day16Test {

    @Test
    fun `part 1 sample test`() {
        Assert.assertEquals("baedc", Day16.part1(getInput("day16sample.txt"), "abcde"))
    }

    @Test
    fun `part 1 actual test`() {
        Assert.assertEquals("doeaimlbnpjchfkg", Day16.part1(getInput("day16.txt")))
    }

    @Test
    fun `part 2 sample test`() {
        Assert.assertEquals("ceadb", Day16.part2(getInput("day16sample.txt"), "abcde", 2))
    }

    @Test
    fun `part 2 actual test`() {
        Assert.assertEquals("agndefjhibklmocp", Day16.part2(getInput("day16.txt")))
    }
}