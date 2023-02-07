package ctci.chaptersixteen

// 16.24 - page 185
// In Kotlin, design an algorithm to find all pairs of integers within an array which sum to a specified value.

fun main() {
    val arr = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val sum = 10
    val result = findPairsWithSum(arr, sum)
    println(result)  // Output: [(1, 9), (2, 8), (3, 7), (4, 6), (5, 5)]
}

fun findPairsWithSum(arr: IntArray, sum: Int): List<Pair<Int, Int>> {
    val seen = hashSetOf<Int>()
    val result = mutableListOf<Pair<Int, Int>>()

    for (num in arr) {
        val complement = sum - num
        if (seen.contains(complement)) {
            result.add(Pair(num, complement))
        }
        seen.add(num)
    }

    return result
}
// This implementation has a time complexity of O(n), where n is the number of elements in the input array. The
// space complexity is O(n), as we are using a hash table to store the elements that have been seen so far.