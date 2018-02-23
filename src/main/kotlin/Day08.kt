import utils.dec
import utils.inc
import utils.splitAtNewLines
import utils.splitAtWhiteSpace

object Day08 {

    fun part1(input: String) : Int {

        val valueMap = mutableMapOf<String, Int>()

        input.splitAtNewLines().forEach {

            val splitInput = it.split(" if ")

            val operation = splitInput[0]
            val condition = splitInput[1]

            if (evaluateCondition(condition, valueMap)) {

                if (operation.contains(" inc ")) {

                    val operationSplit = operation.split(" inc ")
                    valueMap[operationSplit[0]] = (valueMap[operationSplit[0]] ?: 0) inc
                            operationSplit[1].toInt()

                } else {

                    val operationSplit = operation.split(" dec ")
                    valueMap[operationSplit[0]] = (valueMap[operationSplit[0]] ?: 0) dec
                            operationSplit[1].toInt()

                }

            }

        }

        return valueMap.values.max() ?: throw IllegalStateException("Freak out!!!")

    }

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