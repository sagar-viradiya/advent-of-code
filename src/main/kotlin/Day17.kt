import java.util.*

object Day17 {

    fun part1(input: Int): Int {

        val circularBuffer = LinkedList<Int>()

        circularBuffer.add(0)
        circularBuffer.add(1)

        var currentPosition = 2

        for (i in 2 until 2018) {
            currentPosition = (currentPosition + input) % circularBuffer.size
            circularBuffer.add(currentPosition++, i)
        }

        return circularBuffer[currentPosition]

    }

}