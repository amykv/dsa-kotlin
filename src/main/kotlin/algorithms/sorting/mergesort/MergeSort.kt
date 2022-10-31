package algorithms.sorting.mergesort

fun main() {
    val mergeSort = MergeSort()
    val numbers = ArrayList(listOf(87, 34, 7, 12, 11, 54, 6, 42, 150, 15, 92, 69))
    println(mergeSort.mergeSort(numbers))
}

class MergeSort {
    fun mergeSort(array: List<Int>): List<Int> {
        if (array.size == 1) {
            return array
        }
        val left = array.subList(0, array.size / 2)
        val right = array.subList(array.size / 2, array.size)
        return merge(mergeSort(left), mergeSort(right))
    }

    private fun merge(left: List<Int>, right: List<Int>): List<Int> {
        val result = ArrayList<Int>()
        var leftIndex = 0
        var rightIndex = 0
        while (leftIndex < left.size && rightIndex < right.size) {
            if (left[leftIndex] < right[rightIndex]) {
                result.add(left[leftIndex])
                leftIndex++
            } else {
                result.add(right[rightIndex])
                rightIndex++
            }
        }
        val leftRemaining = left.subList(leftIndex, left.size)
        val rightRemaining = right.subList(rightIndex, right.size)
        result.addAll(leftRemaining)
        result.addAll(rightRemaining)
        return result
    }
}