package algorithms.sorting.quicksort

fun main() {
    val numbers = intArrayOf(87, 34, 7, 12, 11, 54, 6, 42, 150, 15, 92, 69)
    val quickSort = QuickSort()
    quickSort.quickSort(numbers, 0, numbers.size - 1)
    quickSort.printArray(numbers)
}

//The QuickSort algorithm is a divide-and-conquer algorithm that sorts an array by partitioning it into two subarrays,
// sorting each subarray independently, and then combining the sorted subarrays. The key operation in QuickSort is
// partitioning the array. The partitioning step selects a pivot element, rearranges the array so that all elements
// less than the pivot come before it, and all elements greater than the pivot come after it. The pivot element is
// now in its final position, and the two subarrays on either side of it can be sorted independently.
//
//The time complexity of QuickSort is O(n log n) in the average case, but can degrade to O(n^2) in the worst case if
// the pivot element is consistently chosen poorly. The space complexity of QuickSort is O(log n) due to the recursion
// used in the algorithm.

class QuickSort {
    fun quickSort(arr: IntArray, low: Int, high: Int) {
        if (low < high) {
            val pIndex = partition(arr, low, high)
            quickSort(arr, low, pIndex - 1)
            quickSort(arr, pIndex + 1, high)
        }
    }

    private fun partition(arr: IntArray, low: Int, high: Int): Int {
        val pivot = arr[high]
        var i = low - 1
        for (j in low until high) {
            if (arr[j] <= pivot) {
                i++

                // swap arr[i] and arr[j]
                val temp = arr[i]
                arr[i] = arr[j]
                arr[j] = temp
            }
        }
        val temp = arr[i + 1]
        arr[i + 1] = arr[high]
        arr[high] = temp
        return i + 1
    }

    fun printArray(arr: IntArray) {
        for (value in arr) print("$value ")
        println()
    }
}