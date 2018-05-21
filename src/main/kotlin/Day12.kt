import utils.splitAtComma
import utils.splitAtNewLines
import utils.toIntList
import java.util.regex.Pattern

object Day12 {

    private val PATTERN = Pattern.compile("(\\d+) <-> (.+)")

    fun part1(input: String) : Int {

        val programMap = parseInput(input)

        val reachablePrograms = mutableListOf(0)

        calculateReachableProgram(reachablePrograms, 0, programMap)

        return reachablePrograms.size
    }

    fun part2(input: String) : Int {

        val programMap = parseInput(input)

        var reachablePrograms: MutableList<Int>

        var groupCount = 0

        while (!programMap.isEmpty()) {
            reachablePrograms = mutableListOf(programMap.keys.elementAt(0))
            calculateReachableProgram(reachablePrograms, programMap.keys.elementAt(0), programMap)
            reachablePrograms.clear()
            groupCount++
        }

        return groupCount
    }

    private fun parseInput(input: String) : MutableMap<Int, List<Int>> {

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
        programKey: Int,
        programMap: MutableMap<Int, List<Int>>
    ) {

        for (program in programMap[programKey]!!) {
            if (!reachableProgramList.contains(program)) {
                reachableProgramList.add(program)
                calculateReachableProgram(reachableProgramList, program, programMap)
            }
        }

        programMap.remove(programKey)

    }

}