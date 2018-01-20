import utils.Direction
import utils.Point

/**
 * Created by sagar on 19/01/18.
 */
object Day03 {

    fun part1(input: Int) : Int {

        val point = getPoint(input)

        return Math.abs(point.x) + Math.abs(point.y)
    }

    fun part2(input: Int) : Int {

        var direction = Direction.EAST
        var point = Point()

        val pointValueMapping = mutableMapOf(point to 1)

        var minX = 0
        var maxX = 0
        var minY = 0
        var maxY = 0
        var pointValue: Int

        if(input == 1) {
            return 2
        }

        while (true) {

            when(direction) {

                Direction.EAST -> {

                    maxX += 1

                    while (point.x != maxX) {
                        point = point.move(Direction.EAST)
                        pointValue = calculatePointValue(point, pointValueMapping)
                        if(pointValue > input) return pointValue
                        pointValueMapping[point] = pointValue

                    }

                    direction = Direction.NORTH
                }

                Direction.NORTH -> {
                    maxY += 1

                    while (point.y != maxY) {
                        point = point.move(Direction.NORTH)
                        pointValue = calculatePointValue(point, pointValueMapping)
                        if(pointValue > input) return pointValue
                        pointValueMapping[point] = pointValue
                    }

                    direction = Direction.WEST
                }

                Direction.WEST -> {
                    minX -= 1

                    while (point.x != minX) {
                        point = point.move(Direction.WEST)
                        pointValue = calculatePointValue(point, pointValueMapping)
                        if(pointValue > input) return pointValue
                        pointValueMapping[point] = pointValue
                    }

                    direction = Direction.SOUTH
                }

                Direction.SOUTH -> {
                    minY -= 1

                    while (point.y != minY) {
                        point = point.move(Direction.SOUTH)
                        pointValue = calculatePointValue(point, pointValueMapping)
                        if(pointValue > input) return pointValue
                        pointValueMapping[point] = pointValue
                    }

                    direction = Direction.EAST
                }

            }

        }

    }

    private fun calculatePointValue(point: Point, pointValueMapping: Map<Point, Int>) : Int {

        var pointValue = 0

        for (dx in -1..1) {
            for (dy in -1..1) {
                if(dx == 0 && dy == 0) continue
                pointValue += pointValueMapping[Point(point.x + dx, point.y + dy)] ?: 0
            }
        }

        return pointValue

    }

    private fun getPoint(input: Int) : Point {

        var count = input
        var direction = Direction.EAST
        var point = Point()

        var minX = 0
        var maxX = 0
        var minY = 0
        var maxY = 0

        if(count == 1) {
            return point
        }

        while (true) {

            when(direction) {

                Direction.EAST -> {

                    maxX += 1

                    while (point.x != maxX) {
                        point = point.move(Direction.EAST)
                        if (--count == 1) return point
                    }

                    direction = Direction.NORTH
                }
                Direction.NORTH -> {
                    maxY += 1

                    while (point.y != maxY) {
                        point = point.move(Direction.NORTH)
                        if (--count == 1) return point
                    }

                    direction = Direction.WEST
                }
                Direction.WEST -> {
                    minX -= 1

                    while (point.x != minX) {
                        point = point.move(Direction.WEST)
                        if (--count == 1) return point
                    }

                    direction = Direction.SOUTH
                }
                Direction.SOUTH -> {
                    minY -= 1

                    while (point.y != minY) {
                        point = point.move(Direction.SOUTH)
                        if (--count == 1) return point
                    }

                    direction = Direction.EAST
                }

            }

        }

    }

}