import utils.splitAtNewLines
import utils.toIntList

/**
 * Created by sagar on 29/01/18.
 */
object Day05 {

    fun part1(input: String) : Int {

        val inputList = input.splitAtNewLines().toIntList().toMutableList()

        var pointer = 0
        var counter = 0

        while (pointer < inputList.size) {
            pointer += inputList[pointer]++
            counter++
        }

        return counter

    }

}