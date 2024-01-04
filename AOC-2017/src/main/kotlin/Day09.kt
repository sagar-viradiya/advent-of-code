object Day09 {

    fun part1(input: String, shouldTrackGarbageCount: Boolean = false) : Int {

        var score = 1
        var inGarbage = false
        var shouldEscape = false
        var totalScore = 0
        var garbageCount = 0

        for (char in input.toCharArray()) {

            if (!shouldEscape) {

                when {
                    !shouldTrackGarbageCount && !inGarbage && char == '{'  -> totalScore += score++
                    !shouldTrackGarbageCount && !inGarbage && char == '}' -> score--
                    char == '<' -> {
                        if (inGarbage && shouldTrackGarbageCount) {
                            garbageCount++
                        } else {
                            inGarbage = true
                        }
                    }
                    char == '>' -> inGarbage = false
                    char == '!' -> shouldEscape = true
                    shouldTrackGarbageCount && inGarbage -> garbageCount++
                }

            } else {
                shouldEscape = false
            }
        }

        return if (shouldTrackGarbageCount) garbageCount else totalScore
    }

    fun part2(input: String) = part1(input, true)

}