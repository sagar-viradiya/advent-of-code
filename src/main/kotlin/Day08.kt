import utils.dec
import utils.inc
import utils.splitAtNewLines
import utils.splitAtWhiteSpace

object Day08 {

    fun part1(input: String, trackHighestValue: Boolean = false) : Int {

        val valueMap = mutableMapOf<String, Int>()

        var highestValue: Int? = null

        input.splitAtNewLines().forEach {

            val splitInput = it.split(" if ")

            val operation = splitInput[0]
            val condition = splitInput[1]

            if (evaluateCondition(condition, valueMap)) {

                val operationSplit = operation.splitAtWhiteSpace()

                if (operationSplit[1] == "inc") {
                    valueMap[operationSplit[0]] = (valueMap[operationSplit[0]] ?: 0) inc
                            operationSplit[2].toInt()
                } else {
                    valueMap[operationSplit[0]] = (valueMap[operationSplit[0]] ?: 0) dec
                            operationSplit[2].toInt()
                }

                if (trackHighestValue && (highestValue == null || highestValue!! < valueMap[operationSplit[0]]!!)) {
                    highestValue = valueMap[operationSplit[0]]
                }

            }

        }

        return if (trackHighestValue) {
            highestValue ?: throw IllegalStateException("Freak out!!!")
        } else {
            valueMap.values.max() ?: throw IllegalStateException("Freak out!!!")
        }

    }

    fun part2(input: String) = part1(input, true)

    private fun evaluateCondition(condition: String, valueMap: Map<String, Int>) : Boolean {

        val splitInput = condition.splitAtWhiteSpace()
        val variable = splitInput[0]
        val value = splitInput[2].toInt()

        return when(splitInput[1]) {

            ">" -> (valueMap[variable] ?: 0) > value

            "<" -> (valueMap[variable] ?: 0) < value

            "<=" -> (valueMap[variable] ?: 0) <= value

            ">=" -> (valueMap[variable] ?: 0) >= value

            "==" -> (valueMap[variable] ?: 0) == value

            else -> (valueMap[variable] ?: 0) != value

        }

    }

}