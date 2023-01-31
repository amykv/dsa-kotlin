package ctci.chapterten

// 10.3 - page 150
// Given a sorted array of n integers that has been rotated an unknown number of times, write Kotlin code to
// find an element in the array. You may assume that the array was originally sorted in increasing order.

fun main() {
    val arr = intArrayOf(15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14)
    val target = 5
    val index = binarySearch(arr, 0, arr.size - 1, target)
    if (index != -1) {
        println("Element found at index: $index")
    } else {
        println("Element not found")
    }
}

//use binary search to find the target element in the sorted and rotated array. We compare the middle element of the
// array with the target element, and depending on which half of the array is sorted, we either continue the search in
// the left half or the right half of the array. If the target is not found, the function returns -1.
fun binarySearch(arr: IntArray, low: Int, high: Int, target: Int): Int {
    if (low > high) return -1

    val mid = (low + high) / 2
    if (arr[mid] == target) return mid

    // If left side of mid is sorted
    if (arr[low] <= arr[mid]) {
        if (target >= arr[low] && target <= arr[mid]) {
            return binarySearch(arr, low, mid - 1, target)
        } else {
            return binarySearch(arr, mid + 1, high, target)
        }
    } else {
        if (target >= arr[mid] && target <= arr[high]) {
            return binarySearch(arr, mid + 1, high, target)
        } else {
            return binarySearch(arr, low, mid - 1, target)
        }
    }
}

//The time complexity of this algorithm is O(log n), because it uses binary search to search for the element in the
// array. The space complexity is O(1), because the algorithm only uses a few variables to store intermediate results,
// and does not require any additional data structures.