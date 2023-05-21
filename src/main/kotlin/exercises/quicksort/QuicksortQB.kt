package exercises.quicksort

//Example that uses a custom quicksort to sort NFL QBs and passing yards.

data class Quarterback(val name: String, val passingYards: Int)

fun main() {
    val quarterbacks = listOf(
        Quarterback("Tom Brady", 5814),
        Quarterback("Patrick Mahomes", 4740),
        Quarterback("Josh Allen", 4544),
        Quarterback("Dak Prescott", 4335),
        Quarterback("Matthew Stafford", 4208)
    )

    val mutableQuarterbacks = quarterbacks.toMutableList()

    println("Before sorting:")
    mutableQuarterbacks.forEach { println("${it.name}: ${it.passingYards} yards") }

    quickSort(mutableQuarterbacks, 0, mutableQuarterbacks.size - 1) { qb1, qb2 ->
        qb1.passingYards - qb2.passingYards
    }

    println("\nAfter sorting:")
    mutableQuarterbacks.forEach { println("${it.name}: ${it.passingYards} yards") }
}

fun <T> quickSort(list: MutableList<T>, low: Int, high: Int, comparator: (T, T) -> Int) {
    if (low < high) {
        val pivotIndex = partition(list, low, high, comparator)
        quickSort(list, low, pivotIndex - 1, comparator)
        quickSort(list, pivotIndex + 1, high, comparator)
    }
}

fun <T> partition(list: MutableList<T>, low: Int, high: Int, comparator: (T, T) -> Int): Int {
    val pivot = list[high]
    var i = low - 1

    for (j in low until high) {
        if (comparator(list[j], pivot) < 0) {
            i++
            list.swap(i, j)
        }
    }

    list.swap(i + 1, high)
    return i + 1
}

fun <T> MutableList<T>.swap(index1: Int, index2: Int) {
    val temp = this[index1]
    this[index1] = this[index2]
    this[index2] = temp
}
