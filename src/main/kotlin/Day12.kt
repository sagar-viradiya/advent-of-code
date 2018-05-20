import utils.splitAtComma
import utils.splitAtNewLines
import utils.toIntList
import java.util.regex.Pattern

object Day12 {

    private val PATTERN = Pattern.compile("(\\d+) <-> (.+)")

    fun part1(input: String) : Int {

        val programMap = parseInput(input)

        val reachablePrograms = mutableListOf(0)

        calculateReachableProgram(reachablePrograms, programMap[0]!!, programMap)

        return reachablePrograms.size
    }

    private fun parseInput(input: String) : Map<Int, List<Int>> {

        val mutableProgramMap = mutableMapOf<Int, List<Int>>()

        for (program in input.splitAtNewLines()) {
            val matcher = PATTERN.matcher(program)
            matcher.matches()
            mutableProgramMap[matcher.group(1).toInt()] = matcher.group(2).splitAtComma().toIntList()
        }

        return mutableProgramMap

    }

    private fun calculateReachableProgram(
        reachableProgramList: MutableList<Int>,
        programList: List<Int>,
        programMap: Map<Int, List<Int>>
    ) {

        for (program in programList) {
            if (!reachableProgramList.contains(program)) {
                reachableProgramList.add(program)
                programMap[program]?.let { calculateReachableProgram(reachableProgramList, it, programMap) }
            }
        }

    }

}