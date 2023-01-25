package ctci.chaptereight

// 8.1 - page 134
// A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3 steps at a time. Implement a
// method in Kotlin to count how many possible ways the child can run up the stairs.

fun main() {
    val n = 5
    val memo = IntArray(n + 1) { -1 }
    val ways = countWays(n, memo)
    println("There are $ways ways to reach the $n step.")
}

// Use memoization to keep track of the number of ways to reach each step, so you don't need to recalculate it
// every time.
fun countWays(n: Int, memo: IntArray): Int {
    if (n < 0) {
        return 0
    } else if (n == 0) {
        return 1
    } else if (memo[n] > -1) {
        return memo[n]
    } else {
        memo[n] = countWays(n - 1, memo) + countWays(n - 2, memo) + countWays(n - 3, memo)
        return memo[n]
    }
}

// The time complexity of this approach is now O(n) and the space complexity is O(n)