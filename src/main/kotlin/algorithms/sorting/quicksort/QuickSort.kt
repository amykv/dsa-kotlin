package algorithms.sorting.quicksort

fun main() {
    val numbers = intArrayOf(87, 34, 7, 12, 11, 54, 6, 42, 150, 15, 92, 69)
    val quickSort = QuickSort()
    quickSort.quickSort(numbers, 0, numbers.size - 1)
    quickSort.printArray(numbers)
}

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