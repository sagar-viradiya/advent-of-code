import kotlin.test.Test
import kotlin.test.assertEquals

class Day17Test {

    @Test
    fun `part 1 sample test`() {
        assertEquals(638, Day17.part1(3))
    }

    @Test
    fun `part 1 actual test`() {
        assertEquals(1642, Day17.part1(301))
    }

    @Test
    fun `part 2 actual test`() {
        assertEquals(33601318, Day17.part2(301))
    }

}