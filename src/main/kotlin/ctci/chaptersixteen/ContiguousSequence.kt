package ctci.chaptersixteen

// 16.17 - page 183
// You are given an array of integers (both positive and negative). Find the contiguous sequence with the largest
// sum. Return the sum.

fun main() {
    val arr1 = intArrayOf(1, -2, 3, 10, -4, 7, 2, -5)
    val arr2 = intArrayOf(-2, -3, 4, -1, -2, 1, 5, -3)
    val arr3 = intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)

    assert(maxSubarraySum(arr1) == 18)
    assert(maxSubarraySum(arr2) == 7)
    assert(maxSubarraySum(arr3) == 6)
}

//This function takes an integer array as input and returns the maximum sum of any contiguous subarray in the array.
// We initialize two variables, maxSum and currentSum, to the first element of the array. We then loop through the
// array, updating currentSum to be the maximum of the current element and the sum of the current element and the
// previous subarray, and updating maxSum to be the maximum of the current value of maxSum and the current value
// of currentSum.
fun maxSubarraySum(arr: IntArray): Int {
    var maxSum = arr[0]
    var currentSum = arr[0]

    for (i in 1 until arr.size) {
        currentSum = maxOf(arr[i], currentSum + arr[i])
        maxSum = maxOf(maxSum, currentSum)
    }

    return maxSum
}
//time complexity of O(n) and a space complexity of O(1).