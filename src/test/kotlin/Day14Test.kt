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
}