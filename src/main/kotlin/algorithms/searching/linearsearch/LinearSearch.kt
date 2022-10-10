package algorithms.searching.linearsearch

fun main() {
    val ls = LinearSearch()
    val arr = intArrayOf(14, 17, 64, 86, 88, 59)
    val answer = ls.linearSearch(arr, 59)
    println(answer)
}

class LinearSearch {
    fun linearSearch(arr: IntArray, key: Int): Int {
        for (i in arr.indices) {
            if (arr[i] == key) {
                return i
            }
        }

        // Element not found, return -1 works because the linearSearch function has (): Int
        return -1
    }
}