import utils.splitAtComma
import utils.toHexString
import utils.toIntArray


object Day10 {

    private var skipSize = 0
    private var currentPosition = 0

    fun part1(input: String, arraySize: Int = 256) : Int {

        val array = IntArray(arraySize, { it * 1 })

        val lengthList = input.splitAtComma().toIntArray()

        skipSize = 0
        currentPosition = 0

        knotHash(array, lengthList)

        return array[0] * array[1]

    }

    fun part2(input: String) : String {

        val array = IntArray(256, { it * 1 })

        val inputArray = processInput(input)

        skipSize = 0
        currentPosition = 0


        for (i in 0..63) {
            knotHash(array, inputArray)
        }

        val knotHash = StringBuffer("")

        for (j in 0..255 step 16) {
            knotHash.append(xorArray(array.sliceArray(j..j+15)).toHexString())
        }

        return knotHash.toString()

    }

    private fun xorArray(array: IntArray) : Int = array.reduce { acc, i -> acc xor i }

    private fun processInput(input: String) : IntArray {

        val array = IntArray(input.trim().length + 5)

        input.forEachIndexed { index, char ->
            array[index] = char.toInt()
        }

        var arraySize = array.size

        array[--arraySize] = 23
        array[--arraySize] = 47
        array[--arraySize] = 73
        array[--arraySize] = 31
        array[--arraySize] = 17

        return array

    }

    private fun knotHash(array: IntArray, inputArray: IntArray) {

        for (i in 0 until inputArray.size) {
            reverseSubArray(array, currentPosition, inputArray[i])
            currentPosition = (currentPosition + inputArray[i] + skipSize++) % array.size
        }

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