package utils

/**
 * Created by sagar on 19/01/18.
 */
data class Point(val x: Int = 0, val y: Int = 0) {

    fun move(direction: Direction) = when(direction) {

        Direction.NORTH -> copy(y = y + 1)
        Direction.SOUTH -> copy(y = y - 1)
        Direction.EAST -> copy(x = x + 1)
        Direction.WEST -> copy(x = x - 1)

    }

}

enum class Direction {
    NORTH,
    SOUTH,
    EAST,
    WEST
}