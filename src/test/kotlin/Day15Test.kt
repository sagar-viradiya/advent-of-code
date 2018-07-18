import org.junit.Assert
import org.junit.Test

class Day15Test {

    @Test
    fun `part 1 sample test`() {
        Assert.assertEquals(588, Day15.part1(65, 8921))
    }

    @Test
    fun `part 1 actual test`() {
        Assert.assertEquals(631, Day15.part1(873, 583))
    }

    @Test
    fun `part 2 sample test`() {
        Assert.assertEquals(309, Day15.part2(65, 8921))
    }

    @Test
    fun `part 2 actual test`() {
        Assert.assertEquals(279, Day15.part2(873, 583))
    }

}