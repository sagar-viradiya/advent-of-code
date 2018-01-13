import com.google.common.base.Charsets
import com.google.common.io.Resources
import org.junit.Assert.*
import org.junit.Test

/**
 * Created by sagar on 13/01/18.
 */
class Day01Test {


    @Test
    fun `part 01 sample tests`() {
        assertEquals(3, Day01.part1("1122"))
        assertEquals(4, Day01.part1("1111"))
    }

    @Test
    fun `part1 actual input test`() {
        assertEquals(1203, Day01.part1(Resources.toString(Resources.getResource("day01.txt"), Charsets.UTF_8)))
    }

    @Test
    fun `part 02 sample tests`() {
        assertEquals(6, Day01.part2("1212"))
        assertEquals(0, Day01.part2("1221"))
    }

    @Test
    fun `part2 actual input test`() {
        assertEquals(1146, Day01.part2(Resources.toString(Resources.getResource("day01.txt"), Charsets.UTF_8)))
    }

}