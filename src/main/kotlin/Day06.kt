import utils.splitAtWhiteSpace
import utils.toIntList

/**
 * Created by sagar on 30/01/18.
 */
object Day06 {

    fun part1(input: String) : Int {

        val intList = input.splitAtWhiteSpace().toIntList().toMutableList()
        val seen = mutableSetOf<List<Int>>()

        var maxIndex: Int
        var maxValue: Int
        var counter = 0

        while (!seen.contains(intList)) {

            seen.add(intList)

            maxValue = intList.max() ?: 0
            maxIndex = intList.indexOf(maxValue)
            intList[maxIndex++] = 0


            while (maxValue != 0) {

                if (maxIndex == intList.size) {
                    maxIndex = 0
                }

                intList[maxIndex++]++
                maxValue--

            }

            counter++

        }

        return counter

    }

}