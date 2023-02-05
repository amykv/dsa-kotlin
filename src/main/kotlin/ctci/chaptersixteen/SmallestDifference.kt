package ctci.chaptersixteen

// 16.6 - page 181
// Given two arrays of integers, compute the pair of values (one value in each array) with smallest (non-negative)
// difference. Return the difference.

fun main() {
    val a = intArrayOf(1, 2, 3, 4, 5)
    val b = intArrayOf(6, 7, 8, 9, 10)
    println(smallestDifference(a, b))  // Output: 1
}

fun smallestDifference(a: IntArray, b: IntArray): Int {
    a.sort()
    b.sort()

    var i = 0
    var j = 0
    var minDiff = Int.MAX_VALUE

    while (i < a.size && j < b.size) {
        val diff = Math.abs(a[i] - b[j])
        if (diff < minDiff) {
            minDiff = diff
        }

        if (a[i] < b[j]) {
            i++
        } else {
            j++
        }
    }

    return minDiff
}

//The time complexity of this solution is O(n log n + m log m), where n and m are the lengths of the two arrays a and
// b, respectively. The first n log n and m log m terms are for sorting the arrays, and the O(n + m) term is for
// iterating through the two arrays and finding the minimum difference. The space complexity is O(1), as we're not
// using any extra data structures and only using variables to keep track of the indices and minimum difference.