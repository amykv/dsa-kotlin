package exercises.lowesthighestquicksort

//Sort list of numbers from lowest number to greatest number using quick sort.
//
//Algorithm:
//
//Pick first element as pivot (pivot can be also last, random element but we explicitly always pick first element)
//Partition elements - start traversing from the leftmost element and if a smaller element is found, swap current
// element with list[i]. Keep track of index of smaller to elements at index (pivotIndex).
//Swap pivot with element at pivotIndex
//Recursively repeat the process for left partition (element on the left side of pivot) and right partition (element
// on the right side of the pivot)

fun main() {
    val unsortedList = mutableListOf(5, 2, 9, 1, 5, 6, 3)
    val sortedList = quickSort(unsortedList)
    println(sortedList)
}

// Time complexity: O(n^2)
// Space complexity: O(n)
private fun quickSort(list: MutableList<Int>): List<Number> {
    if (list.isEmpty()) {
        return list
    }

    val pivot = list.first() // first element as pivot (it can be any element)
    var pivotIndex = 0 // first index that can swap (number of element that are less than pivot)

    (0..list.lastIndex).forEach {
        if (pivot > list[it]) {
            list.swap(it, pivotIndex + 1)
            pivotIndex++
        }
    }

    // Move element to the correct index
    // All elements smaller than element will be on the left side of the array (smaller indexes)
    // All elements larger than element will be on the left side of the array (lager indexes)
    list.swap(0, pivotIndex)

    // Create left sub-list
    val left = list.subList(0, pivotIndex)

    // Create right sub-list
    val right = list.subList(pivotIndex + 1, list.size)

    return quickSort(left) + listOf(pivot) + quickSort(right)
}

private fun <T> MutableList<T>.swap(index1: Int, index2: Int) {
    val tmp = this[index1]
    this[index1] = this[index2]
    this[index2] = tmp
}