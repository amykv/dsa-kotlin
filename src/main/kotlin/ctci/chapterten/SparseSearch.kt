package ctci.chapterten

// 10.5 - page 150
// Given a sorted array of strings that is interspersed with empty strings, write a method in Kotlin to find the
// location of a given string.

fun main() {
    val arr = arrayOf("at", "", "", "", "ball", "", "", "car", "", "", "dad", "", "")
    val target = "ball"
    val index = searchString(arr, target)
    if (index != -1) {
        println("The target '$target' is found at index $index.")
    } else {
        println("The target '$target' is not found in the array.")
    }
}
fun searchString(array: Array<String>, target: String): Int {
    var left = 0
    var right = array.size - 1
    while (left <= right) {
        var mid = (left + right) / 2
        if (array[mid].isEmpty()) {
            var i = mid
            while (i >= left && array[i].isEmpty()) {
                i--
            }
            if (i < left) {
                left = mid + 1
                continue
            } else {
                mid = i
            }
        }
        if (array[mid] == target) {
            return mid
        } else if (array[mid].compareTo(target) < 0) {
            left = mid + 1
        } else {
            right = mid - 1
        }
    }
    return -1
}
//This implementation uses binary search. The time complexity is O(log n) and the space complexity is O(1).