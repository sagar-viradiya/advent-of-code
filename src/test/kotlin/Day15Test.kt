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

}