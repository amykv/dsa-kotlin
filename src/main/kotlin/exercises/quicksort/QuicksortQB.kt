package exercises.quicksort

//Example that uses a custom quicksort to sort NFL QBs and passing yards.

data class Quarterback(val name: String, val passingYards: Int)

fun main() {
    // Define a list of Quarterback objects with their names and passing yards
    val quarterbacks = listOf(
        Quarterback("Tom Brady", 5814),
        Quarterback("Patrick Mahomes", 4740),
        Quarterback("Josh Allen", 4544),
        Quarterback("Dak Prescott", 4335),
        Quarterback("Matthew Stafford", 4208)
    )

    // Convert the list to a mutable list
    val mutableQuarterbacks = quarterbacks.toMutableList()

    // Print the quarterbacks list before sorting
    println("Before sorting:")
    mutableQuarterbacks.forEach { println("${it.name}: ${it.passingYards} yards") }

    // Sort the mutableQuarterbacks list using the quickSort function
    quickSort(mutableQuarterbacks, 0, mutableQuarterbacks.size - 1) { qb1, qb2 ->
        qb1.passingYards - qb2.passingYards
    }

    // Print the quarterbacks list after sorting
    println("\nAfter sorting:")
    mutableQuarterbacks.forEach { println("${it.name}: ${it.passingYards} yards") }
}

// QuickSort implementation
fun <T> quickSort(list: MutableList<T>, low: Int, high: Int, comparator: (T, T) -> Int) {
    // Base case: If there are at least two elements
    if (low < high) {
        // Partition the list and get the pivot index
        val pivotIndex = partition(list, low, high, comparator)

        // Recursively sort the left partition
        quickSort(list, low, pivotIndex - 1, comparator)

        // Recursively sort the right partition
        quickSort(list, pivotIndex + 1, high, comparator)
    }
}

// Partition function for QuickSort
fun <T> partition(list: MutableList<T>, low: Int, high: Int, comparator: (T, T) -> Int): Int {
    // Select the last element as the pivot
    val pivot = list[high]
    var i = low - 1

    // Iterate through the subarray
    for (j in low until high) {
        // If the current element is smaller than the pivot
        if (comparator(list[j], pivot) < 0) {
            i++

            // Swap list[i] and list[j]
            list.swap(i, j)
        }
    }

    // Swap list[i+1] and list[high] (placing the pivot in its correct position)
    list.swap(i + 1, high)
    return i + 1
}

// Extension function to swap elements in a MutableList
fun <T> MutableList<T>.swap(index1: Int, index2: Int) {
    val temp = this[index1]
    this[index1] = this[index2]
    this[index2] = temp
}

//Space and time complexity is O(log n)