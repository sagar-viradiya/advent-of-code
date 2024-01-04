import kotlin.test.Test
import kotlin.test.assertEquals

class Day14Test {

    @Test
    fun `part 1 sample test`() {
        assertEquals(8108, Day14.part1("flqrgnkx"))
    }

    @Test
    fun `part 1 actual test`() {
        assertEquals(8216, Day14.part1("nbysizxe"))
    }

    @Test
    fun `part 2 sample test`() {
        assertEquals(1242, Day14.part2("flqrgnkx"))
    }

    @Test
    fun `part 2 actual test`() {
        assertEquals(1139, Day14.part2("nbysizxe"))
    }
}