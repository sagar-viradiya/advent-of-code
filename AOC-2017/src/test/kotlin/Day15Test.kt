import kotlin.test.Test
import kotlin.test.assertEquals

class Day15Test {

    @Test
    fun `part 1 sample test`() {
        assertEquals(588, Day15.part1(65, 8921))
    }

    @Test
    fun `part 1 actual test`() {
        assertEquals(631, Day15.part1(873, 583))
    }

    @Test
    fun `part 2 sample test`() {
        assertEquals(309, Day15.part2(65, 8921))
    }

    @Test
    fun `part 2 actual test`() {
        assertEquals(279, Day15.part2(873, 583))
    }

}