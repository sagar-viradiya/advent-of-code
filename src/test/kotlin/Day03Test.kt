import org.junit.Assert.*
import org.junit.Test

/**
 * Created by sagar on 19/01/18.
 */
class Day03Test {

    @Test
    fun `part 01 sample tests`() {

        assertEquals(0, Day03.part1(1))
        assertEquals(3, Day03.part1(12))
        assertEquals(2, Day03.part1(23))
        assertEquals(31, Day03.part1(1024))

    }

    @Test
    fun `part 01 actual test`() {
        assertEquals(552, Day03.part1(325489))
    }

    @Test
    fun `part 02 sample tests`() {

        assertEquals(4, Day03.part2(2))
        assertEquals(54, Day03.part2(26))
        assertEquals(122, Day03.part2(59))

    }

    @Test
    fun `part 02 actual test`() {
        assertEquals(330785, Day03.part2(325489))
    }
}