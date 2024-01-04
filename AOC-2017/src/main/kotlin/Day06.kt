import utils.splitAtWhiteSpace
import utils.toIntList

/**
 * Created by sagar on 30/01/18.
 */
object Day06 {

    fun part1(input: String) = getRedistributionCount(input)

    fun part2(input: String) = getRedistributionCount(input, true)

    private fun getRedistributionCount(input: String, secondCycle: Boolean = false) : Int {

        var intList = input.splitAtWhiteSpace().toIntList()
        val seen = mutableSetOf<List<Int>>()

        var counter = 0
        var secondLoop = secondCycle

        while (!seen.contains(intList) || secondLoop) {

            if (seen.contains(intList)) {
                seen.clear()
                secondLoop = false
                counter = 0
            }

            seen.add(intList)

            intList = redistributeBlock(intList, intList.max() ?: 0)

            counter++

        }

        return counter

    }

    private fun redistributeBlock(intList: List<Int>, maxValue: Int) : List<Int> {

        val mutableIntList = intList.toMutableList()
        var steps = maxValue
        var maxIndex = intList.indexOf(maxValue)

        mutableIntList[maxIndex++] = 0

        while (steps != 0) {

            if (maxIndex == intList.size) {
                maxIndex = 0
            }

            mutableIntList[maxIndex++]++
            steps--

        }

        return mutableIntList

    }

}