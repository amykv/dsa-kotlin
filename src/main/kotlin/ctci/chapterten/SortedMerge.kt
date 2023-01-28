package ctci.chapterten

// 10.1 - page 149
// You are given two sorted arrays, A and B, where A has a large enough buffer at the end to hold B. Write a method
// in Kotlin to merge B into A in sorted order.

fun main() {
    val A = intArrayOf(1, 3, 5, 7, 9, 0, 0, 0, 0, 0)
    val B = intArrayOf(2, 4, 6, 8, 10)
    mergeSortedArrays(A, B)
    println(A.toList())
}


fun mergeSortedArrays(A: IntArray, B: IntArray) {
    // Initialize indices for the two arrays
    var i = A.size - B.size - 1
    var j = B.size - 1
    var k = A.size - 1

    // Compare the last elements of the two arrays and place the larger one at the end of A
    while (j >= 0) {
        if (i >= 0 && A[i] > B[j]) {
            A[k] = A[i]
            i--
        } else {
            A[k] = B[j]
            j--
        }
        k--
    }
}
//The time complexity of this algorithm is O(n), where n is the total size of the two arrays, since we are iterating
// through both arrays once. The space complexity is O(1), since we are merging the arrays in place, without using any
// additional data structures.