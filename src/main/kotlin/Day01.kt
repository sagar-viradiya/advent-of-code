/**
 * Created by sagar on 06/01/18.
 */

object Day01 {

    fun part1(input: String) : Int {

        val digitSequence = input.trim().map { it.toString().toInt() }.toMutableList()
        digitSequence.add(digitSequence[0])

        return (0..digitSequence.size-2)
                .filter { digitSequence[it] == digitSequence[it +1] }
                .sumBy { digitSequence[it] }

    }

    fun part2(input: String) : Int {

        require(input.length % 2 == 0) { "Requires even length input" }

        val size = input.length

        val modifiedInput = input + input.subSequence(0, input.length/2)

        val digitInput = modifiedInput.trim().map { it.toString().toInt() }

        return  (0 until size)
                .filter { digitInput[it] == digitInput[it + (size/2)] }
                .sumBy { digitInput[it] }
    }

}