import utils.splitAtNewLines
import utils.splitAtWhiteSpace

/**
 * Created by sagar on 25/01/18.
 */
object Day04 {

    fun part1(input: String) : Int {

        return input.splitAtNewLines().filter {
            val wordList = it.splitAtWhiteSpace()
            wordList.size == wordList.distinct().size

        }.count()

    }

    fun part2(input: String) : Int {

        return input.splitAtNewLines().filter {
            isValid(it)
        }.count()

    }

    private fun isValid(input: String) : Boolean {

        val wordList = input.splitAtWhiteSpace()

        var word1: String
        var word2: String
        var charList: MutableList<Char>

        for (i in 0 until wordList.size) {

            word1 = wordList[i]

            for (j in i+1 until wordList.size) {

                word2 = wordList[j]

                if(word1.length == word2.length) {

                    charList = word2.toMutableList()

                    for (i in 0 until word1.length) {

                        if (charList.contains(word1[i])) {
                            charList.removeAt(charList.indexOf(word1[i]))
                        } else {
                            break
                        }

                    }

                    if (charList.size == 0) {
                        return false
                    }

                }

            }
        }

        return true
    }

}