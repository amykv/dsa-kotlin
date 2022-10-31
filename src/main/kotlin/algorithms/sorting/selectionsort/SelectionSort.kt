package algorithms.sorting.selectionsort

fun main() {
    val numbers = intArrayOf(87, 34, 7, 12, 11, 54, 6, 42, 150, 15, 92, 69)
    println(selectionSort(numbers).contentToString())
}

fun selectionSort(array: IntArray): IntArray {
    for (i in array.indices) {
        var smallest = i
        for (j in i until array.size) {
            if (array[j] < array[smallest]) {
                smallest = j
            }
        }
        val temp = array[i]
        array[i] = array[smallest]
        array[smallest] = temp
    }
    return array
}