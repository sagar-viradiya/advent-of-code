import java.util.*

object Day17 {

    fun part1(input: Int): Int {

        val circularBuffer = LinkedList<Int>()

        circularBuffer.add(0)
        circularBuffer.add(1)

        var currentPosition = 2

        for (i in 2..2017) {
            currentPosition = (currentPosition + input) % i
            if (currentPosition == 0) {
                currentPosition = i + 1
                circularBuffer.add(i)
            } else {
                circularBuffer.add(currentPosition++, i)
            }

        }

        return circularBuffer[currentPosition]

    }

    fun part2(input: Int): Int {

        var currentPosition = 2
        var _1stPosition = 1

        for (i in 2..50000000) {
            currentPosition = (currentPosition + input) % i
            if (currentPosition == 0) currentPosition = i

            if (currentPosition++ == 1) {
                _1stPosition = i
            }
        }

        return _1stPosition
    }

}