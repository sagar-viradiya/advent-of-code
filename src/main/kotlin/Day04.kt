import utils.splitAtNewLines
import utils.splitAtWhiteSpace

/**
 * Created by sagar on 25/01/18.
 */
object Day04 {

    fun part1(input: String) : Int {

        return input.splitAtNewLines().filter {
            val wordList = it.splitAtWhiteSpace()
            wordList.size == wordList.distinct().size

        }.count()

    }

}