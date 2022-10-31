package algorithms.sorting.bubblesort

fun main() {
    val numbers = intArrayOf(87, 34, 7, 12, 11, 54, 6, 42, 150, 15, 92, 69)
    bubbleSort(numbers)
    println(numbers.contentToString())
}

fun bubbleSort(array: IntArray) {
    for (i in array.indices) {
        for (j in 0 until array.size - 1) {
            if (array[j] > array[j + 1]) {
                val temp = array[j]
                array[j] = array[j + 1]
                array[j + 1] = temp
            }
        }
    }
}