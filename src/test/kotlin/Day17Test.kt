import org.junit.Assert
import org.junit.Test

class Day17Test {

    @Test
    fun `part 1 sample test`() {
        Assert.assertEquals(638, Day17.part1(3))
    }

    @Test
    fun `part 1 actual test`() {
        Assert.assertEquals(1642, Day17.part1(301))
    }

    @Test
    fun `part 2 actual test`() {
        Assert.assertEquals(33601318, Day17.part2(301))
    }

}