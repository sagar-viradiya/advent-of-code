import utils.splitAtComma
import utils.toIntList

object Day10 {

    fun part1(input: String, arraySize: Int = 256) : Int {

        val array = IntArray(arraySize, { it * 1 })

        val lengthList = input.splitAtComma().toIntList()

        var currentPosition = 0

        for (i in 0 until lengthList.size) {
            reverseSubArray(array, currentPosition, lengthList[i])
            currentPosition = (currentPosition + lengthList[i] + i) % array.size
        }

        return array[0] * array[1]

    }

    private fun reverseSubArray(array: IntArray, startIndex: Int, subArraySize: Int) {

        var startPosition = startIndex
        var endPosition = (startIndex + (subArraySize - 1)) % array.size

        var temp: Int

        for (i in 0 until subArraySize/2) {

            temp = array[startPosition]
            array[startPosition] = array[endPosition]
            array[endPosition] = temp

            startPosition = ++startPosition % array.size

            if (--endPosition <= -1) {
                endPosition = array.size - 1
            }
        }

    }

}