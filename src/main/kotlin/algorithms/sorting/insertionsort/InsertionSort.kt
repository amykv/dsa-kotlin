package algorithms.sorting.insertionsort

fun main() {
    val numbers = ArrayList(listOf(87, 34, 7, 12, 11, 54, 6, 42, 150, 15, 92, 69))
    insertionSort(numbers)
    println(numbers)
}

fun insertionSort(array: ArrayList<Int>) {
    for (i in array.indices) {
        if (array[i] <= array[0]) {
            array.add(0, array.removeAt(i))
        } else {
            if (array[i] < array[i - 1]) {
                for (j in 1 until i) {
                    if (array[i] < array[j]) {
                        array.add(j, array.removeAt(i))
                        break
                    }
                }
            }
        }
    }
}