import utils.DiskUnbalancedException
import utils.Node
import utils.splitAtComma
import utils.splitAtNewLines
import java.util.regex.Matcher
import java.util.regex.Pattern

object Day07 {

    private val PATTERN = Pattern.compile("(\\w+) \\((\\d+)\\)( -> (.*))?")

    fun part1(input: String) : String {

        val map = constructNodes(input)

        val childList = map.map { it.value.children }.flatten()

        return map.keys.minus(childList).first()

    }

    fun part2(input: String) : Int {

        val map = constructNodes(input)

        try {

            map.entries.filter { !it.value.children.isEmpty() }.forEach { calculateWeight(it.key, map) }

        } catch (e: DiskUnbalancedException) {

            return e.expectedWeight

        }

        throw IllegalStateException("All disks are balanced")

    }

    private fun calculateWeight(node: String, map: Map<String, Node>) : Int {

        if (map[node]!!.children.isEmpty()) {

            return map[node]!!.weight

        } else {

            val childWeightPairList = map[node]!!.children.map { it to calculateWeight(it, map) }

            if (childWeightPairList.size > 1) {

                val distinctWeights = childWeightPairList.map { it.second }.distinct()

                if (distinctWeights.size > 1) {

                    var firstCount = 0
                    var secondCount = 0

                    val weights = childWeightPairList.map { it.second }

                    for (weight in weights) {
                        if (weight == distinctWeights[0]) {

                            if (firstCount++ > 1) {
                                break
                            }

                        } else if (secondCount++ > 1) {
                            break
                        }
                    }

                    val expectedWeight = if (firstCount < secondCount) {
                        map[childWeightPairList[weights.indexOf(distinctWeights[0])].first]!!.weight +
                                (distinctWeights[1] - distinctWeights[0])
                    } else {
                        map[childWeightPairList[weights.indexOf(distinctWeights[1])].first]!!.weight +
                                (distinctWeights[0] - distinctWeights[1])
                    }

                    throw DiskUnbalancedException(expectedWeight)

                } else {
                    return map[node]!!.weight + childWeightPairList.sumBy { it.second }
                }

            } else {
                return map[node]!!.weight + childWeightPairList[0].second
            }

        }

    }

    private fun constructNodes(input: String) : Map<String, Node> {

        var matcher: Matcher
        val map = mutableMapOf<String, Node>()

        input.splitAtNewLines().map {
            matcher = PATTERN.matcher(it)
            matcher.matches()
            val name = matcher.group(1)
            val weight = matcher.group(2).toInt()

            if (matcher.group(3) != null) {
                map.put(name, Node(name, weight, matcher.group(4).splitAtComma()))
            } else {
                map.put(name, Node(name, weight))
            }
        }

        return map

    }


}