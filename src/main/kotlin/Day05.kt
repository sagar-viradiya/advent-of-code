import utils.splitAtNewLines
import utils.toIntList

/**
 * Created by sagar on 29/01/18.
 */
object Day05 {

    fun part1(input: String) = getJumpCount(input.splitAtNewLines().toIntList().toIntArray())

    fun part2(input: String) = getJumpCount(input.splitAtNewLines().toIntList().toIntArray(), true)

    private fun getJumpCount(inputList: IntArray, isPartTwo: Boolean = false) : Int {

        var pointer = 0
        var counter = 0

        while (pointer < inputList.size) {

            pointer += if (isPartTwo && inputList[pointer] > 2) inputList[pointer]-- else inputList[pointer]++
            counter++

        }

        return counter
    }

}