import utils.splitAtNewLines
import utils.splitAtWhiteSpace
import utils.toIntList

/**
 * Created by sagar on 14/01/18.
 */
object Day02 {

    fun part1(input: String) : Int {

        var intList: List<Int>

        return input.splitAtNewLines().sumBy {
            intList = it.splitAtWhiteSpace().toIntList()
            intList.max()!! - intList.min()!!
        }

    }

    fun part2(input: String) : Int {

        var intList: List<Int>

        return input.splitAtNewLines().sumBy {
            intList = it.splitAtWhiteSpace().toIntList()
            for (i in 0 until intList.size) {
                for (j in i + 1 until intList.size) {
                    if(intList[i] % intList[j] == 0) {
                        return@sumBy intList[i]/intList[j]
                    } else if(intList[j] % intList[i] == 0) {
                        return@sumBy  intList[j]/intList[i]
                    }
                }
            }

            0
        }
    }

}