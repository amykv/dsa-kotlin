package ctci.chaptersixteen

// 16.3 - page 181
// Given two straight line segments (represented as a start point and an end point), compute the point of
// intersection, if any.

fun main() {
    val line1 = LineSegment(Point(0.0, 0.0), Point(1.0, 1.0))
    val line2 = LineSegment(Point(0.0, 1.0), Point(1.0, 0.0))
    val intersection = findIntersection(line1, line2)
    if (intersection != null) {
        println("Intersection point: (${intersection.x}, ${intersection.y})")
    } else {
        println("The lines do not intersect.")
    }

}

//In this code, the LineSegment class is defined with two properties: start and end, both of which are Point instances.
// The Point class is also defined with two properties: x and y, both of which are Double values.

//The findIntersection method takes two LineSegment instances as arguments and returns the point of intersection
// between the two lines if it exists, or null if the lines do not intersect. The method uses the formula for
// line-line intersection to calculate the intersection point, and returns null if the intersection point falls
// outside the bounds of either line segment.
data class Point(val x: Double, val y: Double)

data class LineSegment(val start: Point, val end: Point)

fun findIntersection(line1: LineSegment, line2: LineSegment): Point? {
    val x1 = line1.start.x
    val y1 = line1.start.y
    val x2 = line1.end.x
    val y2 = line1.end.y
    val x3 = line2.start.x
    val y3 = line2.start.y
    val x4 = line2.end.x
    val y4 = line2.end.y

    val denominator = ((y4 - y3) * (x2 - x1) - (x4 - x3) * (y2 - y1))
    if (denominator == 0.0) {
        return null
    }

    val ua = ((x4 - x3) * (y1 - y3) - (y4 - y3) * (x1 - x3)) / denominator
    val ub = ((x2 - x1) * (y1 - y3) - (y2 - y1) * (x1 - x3)) / denominator

    if (ua < 0 || ua > 1 || ub < 0 || ub > 1) {
        return null
    }

    val x = x1 + ua * (x2 - x1)
    val y = y1 + ua * (y2 - y1)

    return Point(x, y)
}