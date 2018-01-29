import org.junit.Assert
import org.junit.Test
import utils.getInput

/**
 * Created by sagar on 29/01/18.
 */
class Day05Test {

    @Test
    fun `part 01 sample test`() {
        Assert.assertEquals(5, Day05.part1(getInput("day05sample.txt")))
    }

    @Test
    fun `part 01 actual test`() {
        Assert.assertEquals(343364, Day05.part1(getInput("day05.txt")))
    }

}