import java.util.*
import kotlin.collections.HashSet
import kotlin.math.min

//println(processMovementInput("R12"))
//println(processMovementInput("D12"))
//println(processMovementInput("U3"))
//println(processMovementInput("L72"))
//
// we want to keep track of every location where we go through, and compare against what is being processed

val wire1Path = listOf<String>("R75", "D30", "R83", "U83", "L12", "D49", "R71", "U7", "L72")
val wire2Path = listOf<String>("U62", "R66", "U55", "R34", "D71", "R55", "D58", "R83")
val wire1Points = getAllWireTouchPoints(wire1Path)
val wire2Points = getAllWireTouchPoints(wire2Path)

val intersectionPoints = wire1Points.intersect(wire2Points)
println("intersecting points: $intersectionPoints")

val closestDistance = findClosestIntersect(intersectionPoints)
println("closest distance: $closestDistance")

fun findClosestIntersect(intersectionPoints: Set<Point>): Int {
    if (intersectionPoints.isEmpty()) {
        return 0
    }

    var closetDistance = Int.MAX_VALUE

    intersectionPoints.forEach {
        closetDistance = min(it.getManhattanDistance(), closetDistance)
    }

    return closetDistance
}

fun getAllWireTouchPoints(commands: List<String>): Set<Point> {
    // start at 0,0
    var currentPoint = Point(0,0)

    var visitedPoints = HashSet<Point>()

    commands.forEach {
        val movement = processMovementInput(it)

        for (step in 1..movement.steps) {
            currentPoint = when (movement.direction) {
                Direction.DOWN -> Point(currentPoint.x, currentPoint.y - 1)
                Direction.LEFT -> Point(currentPoint.x - 1, currentPoint.y)
                Direction.RIGHT -> Point(currentPoint.x + 1, currentPoint.y)
                Direction.UP -> Point(currentPoint.x, currentPoint.y + 1)
            }

            println("visiting point ${currentPoint.x},${currentPoint.y}")
            visitedPoints.add(currentPoint)
        }
    }

    return visitedPoints
}


/**
 * Process the movement input. This will always be in the format:
 * <Direction><Steps>
 *
 *     ex: R12 -> Right 12 steps
 */
fun processMovementInput(input: String): Movement {
    val dirString = input.get(0)
    val steps = input.substring(1).toInt()

    return when (dirString) {
        'R' -> Movement(Direction.RIGHT, steps)
        'L' -> Movement(Direction.LEFT, steps)
        'U' -> Movement(Direction.UP, steps)
        'D' -> Movement(Direction.DOWN, steps)
        else -> throw Exception("not a valid direction")
    }
}

enum class Direction {
    UP,
    DOWN,
    RIGHT,
    LEFT
}

class Point(val x: Int, val y: Int) {
    fun getManhattanDistance(): Int {
        return Math.abs(this.x) + Math.abs(this.y);
    }

    override fun equals(other: Any?): Boolean {
        if (other is Point) {
            return (this.x == other.x) and (this.y == other.y)
        }
        return false
    }

    override fun toString(): String {
        return "{ x: ${this.x}, y: ${this.y} }"
    }

    override fun hashCode(): Int {
        return Objects.hash(this.x, this.y)
    }
}
data class Movement(val direction: Direction, val steps: Int)
