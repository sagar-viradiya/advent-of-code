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