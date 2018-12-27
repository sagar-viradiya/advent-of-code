object Day19 {

    fun part1(input: String): String {
        val lines = input.lines()
        val charMatrix = lines.map { it.toCharArray() }
        var direction: Direction = Direction.DOWN
        var i = 0
        var j = lines[0].indexOf('|')
        var end  = false
        val path = StringBuffer()
        while (!end) {
            when(direction) {
                is Direction.UP -> {
                    i--
                    if (i >= 0 && j < charMatrix[i].size) {
                        if (charMatrix[i][j].toInt() == 32) {
                          end = true
                        } else if (charMatrix[i][j] == '+') {
                            direction = when {
                                j == 0 -> Direction.RIGHT
                                j == charMatrix[i].size - 1 -> Direction.LEFT
                                charMatrix[i][j - 1].toInt() != 32 -> Direction.LEFT
                                else -> Direction.RIGHT
                            }
                        } else if (charMatrix[i][j] != '-' && charMatrix[i][j] != '|') {
                            path.append(charMatrix[i][j])
                        }
                    } else {
                        end = true
                    }

                }
                is Direction.DOWN -> {
                    i++
                    if (i < charMatrix.size && j < charMatrix[i].size) {
                        if (charMatrix[i][j].toInt() == 32) {
                            end = true
                        } else if (charMatrix[i][j] == '+') {
                            direction = when {
                                j == 0 -> Direction.RIGHT
                                j == charMatrix[i].size - 1 -> Direction.LEFT
                                charMatrix[i][j - 1].toInt() != 32 -> Direction.LEFT
                                else -> Direction.RIGHT
                            }
                        } else if (charMatrix[i][j] != '-' && charMatrix[i][j] != '|') {
                            path.append(charMatrix[i][j])
                        }
                    } else {
                        end = true
                    }
                }
                is Direction.LEFT -> {
                    j--
                    if (j >= 0 && charMatrix[i][j].toInt() != 32) {
                        if (charMatrix[i][j] == '+') {
                            direction = when {
                                i == 1 -> Direction.DOWN
                                i == charMatrix.size - 1 -> Direction.UP
                                j < charMatrix[i + 1].size && charMatrix[i + 1][j].toInt() != 32 -> Direction.DOWN
                                else -> Direction.UP
                            }
                        } else if (charMatrix[i][j] != '-' && charMatrix[i][j] != '|') {
                            path.append(charMatrix[i][j])
                        }
                    } else {
                        end = true
                    }
                }
                is Direction.RIGHT -> {
                    j++
                    if(j < charMatrix[i].size && charMatrix[i][j].toInt() != 32) {
                        if (charMatrix[i][j] == '+') {
                            direction = when {
                                i == 1 -> Direction.DOWN
                                i == charMatrix.size - 1 -> Direction.UP
                                j < charMatrix[i + 1].size && charMatrix[i + 1][j].toInt() != 32 -> Direction.DOWN
                                else -> Direction.UP
                            }
                        } else if (charMatrix[i][j] != '-' && charMatrix[i][j] != '|') {
                            path.append(charMatrix[i][j])
                        }
                    } else {
                        end = true
                    }
                }
            }
        }
        return path.toString()
    }

    sealed class Direction {
        object UP : Direction()
        object DOWN : Direction()
        object LEFT : Direction()
        object RIGHT : Direction()
    }

}