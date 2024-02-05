import utils.*

object Day05 {

    fun part01(input: String): Long {
        val inputParts = input.splitAtNewEmptyLines()
        val seeds = inputParts[0].splitAtColon()[1].trim().splitAtWhiteSpace().map { it.toLong() }

        val mapList = inputParts.drop(0).map { input ->
            sourceToDestinationMap(
                input.splitAtNewLines().filterIndexed { index, _ -> index > 0 }.map { map ->
                    val mapRange = map.splitAtWhiteSpace()
                    Triple(mapRange[0].toLong(), mapRange[1].toLong(), mapRange[2].toLong())
                }
            )
        }

        return seeds.minOf { seed -> mapList.fold(seed) { currentValue, map -> getMapValue(currentValue, map) } }
    }

    fun part02(input: String): Long {
        val inputParts = input.splitAtNewEmptyLines()
        val seedPair = inputParts[0].splitAtColon()[1].trim().splitAtWhiteSpace().map { it.toLong() }

        val mapList = inputParts.drop(0).map { input ->
            sourceToDestinationMap(
                input.splitAtNewLines().filterIndexed { index, _ -> index > 0 }.map { map ->
                    val mapRange = map.splitAtWhiteSpace()
                    Triple(mapRange[0].toLong(), mapRange[1].toLong(), mapRange[2].toLong())
                }
            )
        }

        var location: Long = Long.MAX_VALUE
        for (index in seedPair.indices step 2) {
            location = minOf(
                location,
                (seedPair[index] until seedPair[index] + seedPair[index + 1]).minOf { seed ->
                    mapList.fold(seed) { currentValue, map ->
                        getMapValue(
                            currentValue,
                            map
                        )
                    }
                })
        }
        return location
    }

    private fun getMapValue(source: Long, mapping: Map<LongRange, Long>): Long {
        for (entry in mapping) {
            if (source in entry.key) {
                return entry.value + (source - entry.key.first)
            }
        }
        return source
    }

    private fun sourceToDestinationMap(mapRange: List<Triple<Long, Long, Long>>): Map<LongRange, Long> {
        val sourceToDestinationMap = mutableMapOf<LongRange, Long>()

        mapRange.forEach { triple ->
            sourceToDestinationMap[triple.second until triple.second + triple.third] = triple.first
        }

        return sourceToDestinationMap
    }
}