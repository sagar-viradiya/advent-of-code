import org.junit.Assert
import org.junit.Test

class Day14Test {

    @Test
    fun `part 1 sample test`() {
        Assert.assertEquals(8108, Day14.part1("flqrgnkx"))
    }

    @Test
    fun `part 1 actual test`() {
        Assert.assertEquals(8216, Day14.part1("nbysizxe"))
    }

    @Test
    fun `part 2 sample test`() {
        Assert.assertEquals(1242, Day14.part2("flqrgnkx"))
    }

    @Test
    fun `part 2 actual test`() {
        Assert.assertEquals(1139, Day14.part2("nbysizxe"))
    }
}