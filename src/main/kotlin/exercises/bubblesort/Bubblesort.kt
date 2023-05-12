package exercises.bubblesort

//Instructions
//
//Sort list of numbers from lowest number to greatest number using bubble sort.
//Algorithm
//
//Starting from the beginning of the list, compare every adjacent pair, swap their position if they are not in the
// right order (the latter one is smaller than the former one). After each iteration, one less element (the last one)
// is needed to be compared until there are no more elements left to be compared.

// Time complexity (Best): Ω(n) - all data besides one element are sorted
// Time complexity (Average): Θ(n^2)
// Time complexity (Worst): O(n^2)
// Space complexity: O(1)

fun main() {
    val nums = listOf<Int>(6, 2, 5, 10, 11, 1, 3)
    println(bubbleSort(nums))
    //println(nums)

}
    private fun bubbleSort(list: List<Int>): List<Number> {
        val sorted = list.toMutableList()

        (0..sorted.lastIndex).forEach { i ->
            var swapped = false
            (0 until (sorted.size - i - 1)).forEach { j ->
                val element = sorted[j]
                val nextElement = sorted[j + 1]

                if (element > nextElement) {
                    sorted[j] = nextElement
                    sorted[j + 1] = element
                    swapped = true
                }
            }

            if (!swapped) {
                return sorted
            }
        }

        return sorted
    }