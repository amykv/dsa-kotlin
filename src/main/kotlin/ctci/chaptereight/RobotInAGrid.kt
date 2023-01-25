package ctci.chaptereight

// 8.2 - page 135
// Imagine a robot sitting on the upper left corner of grid with r rows and c columns. The robot can only move in two
// directions, right and down, but certain cells are "off limits" such that the robot cannot step on them. Design an
// algorithm in Kotlin to find a path for the robot from the top left to the bottom right.

fun main() {
    val r = 4
    val c = 4
    val grid = arrayOf(
        intArrayOf(0, 1, 0, 0),
        intArrayOf(0, 1, 0, 1),
        intArrayOf(0, 0, 0, 0),
        intArrayOf(0, 1, 1, 0)
    )
    val path = mutableListOf<Pair<Int, Int>>()

    if (findPath(grid, r, c, 0, 0, path)) {
        println("Path found: $path")
    } else {
        println("No path found.")
    }
}

// Use a backtracking algorithm. The idea is to start from the top left corner of the grid, and at each cell, check if
// it's an "off limits" cell or not. If it's not, mark it as visited and recursively explore the next possible paths.
// If the robot reaches the bottom right corner, it means a path has been found.
fun findPath(grid: Array<IntArray>, r: Int, c: Int, row: Int, col: Int, path: MutableList<Pair<Int, Int>>): Boolean {
    if (row == r - 1 && col == c - 1) {
        // reached the bottom right corner
        path.add(row to col)
        return true
    }

    if (row >= r || col >= c || grid[row][col] == 1) {
        // off limits cell or out of bounds
        return false
    }

    path.add(row to col)
    grid[row][col] = 1 // mark as visited

    if (findPath(grid, r, c, row + 1, col, path) || findPath(grid, r, c, row, col + 1, path)) {
        return true
    }

    path.removeAt(path.lastIndex) // backtrack
    return false
}

//The time complexity of this algorithm is O(2^(r+c)) which is very expensive, and the space complexity is O(rc)
// because the recursion stack could potentially hold rc calls.